package ru.sberbank.SpringBootBankAPI.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sberbank.SpringBootBankAPI.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {
}
