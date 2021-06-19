package ru.sberbank.SpringBootBankAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sberbank.SpringBootBankAPI.domain.Account;
import ru.sberbank.SpringBootBankAPI.domain.Card;
import ru.sberbank.SpringBootBankAPI.domain.User;
import ru.sberbank.SpringBootBankAPI.repos.AccountRepo;
import ru.sberbank.SpringBootBankAPI.repos.CardRepo;
import ru.sberbank.SpringBootBankAPI.repos.UserRepo;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.Random;

@Controller
public class GreetingController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    CardRepo cardRepo;

    @Autowired
    AccountRepo accountRepo;

    @GetMapping("/")
    public String redirect() {
        return "greeting";
    }

    @GetMapping("/clients")
    public String showAvailableActions(){
        return "client";
    }


    @GetMapping("/cards")
   // @PreAuthorize("hasAuthority('admin')")
    public String getAllCards(
            Principal principal,
            Model model
    ) {
        String login = principal.getName();
        User user = userRepo.findByUsername(login);
        List<Card> cardsList = cardRepo.findAllByClientId(user.getId());
        model.addAttribute("cards",cardsList);
        return "client";
    }

/*    @GetMapping("/balance")
    public String getBalance (@RequestParam (name = "card_id") Long cardId, Model model){
        Card card = cardRepo.getById(cardId);
        Account account = card.getAccount();
        BigDecimal balance = account.getBalance();
        model.addAttribute(balance);
        return "client";
    }*/

    @GetMapping("/accounts")
    public String getAllAccounts(
            Principal principal,
            Model model
    ) {
        String login = principal.getName();
        User user = userRepo.findByUsername(login);
        List<Account> accountList = accountRepo.findByUserId(user.getId());
        model.addAttribute("accounts", accountList);
        return "client";
    }

    @PostMapping("/newcard")
    public String createNewCard(@RequestParam(name = "accountid", required = true) Long accountId, Model model) {
        Account account = accountRepo.getById(accountId);

        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int digit = random.nextInt(9);
            stringBuilder.append(digit);
        }
        Card card = new Card();
        card.setNumber(stringBuilder.toString());
        card.setAccount(account);
        cardRepo.save(card);
        model.addAttribute("new_card_num",card.getNumber());
        return "client";
    }
}
