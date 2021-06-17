package ru.sberbank.SpringBootBankAPI.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sberbank.SpringBootBankAPI.domain.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {
    Account getAccountByNumber(String number);
}
