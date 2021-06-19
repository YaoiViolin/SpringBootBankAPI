package ru.sberbank.SpringBootBankAPI.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.sberbank.SpringBootBankAPI.domain.Card;

import java.util.List;

public interface CardRepo extends JpaRepository<Card, Long> {

    @Query(value = "select * from card join\n" +
            "account on account.id = account_id\n" +
            "where user_id = :userid", nativeQuery = true)
    List<Card> findAllByClientId (@Param("userid") Long userId);
}
