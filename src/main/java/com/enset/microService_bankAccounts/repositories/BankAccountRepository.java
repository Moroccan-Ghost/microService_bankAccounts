package com.enset.microService_bankAccounts.repositories;

import com.enset.microService_bankAccounts.entities.BankAccount;
import com.enset.microService_bankAccounts.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource /*This annotation will generate the rest methods auto (get post..)*/
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
    @RestResource(path = "/byType") /*it will look like this : /bankAccount/search/byType?t=CURRENT_ACCOUNT */
    List<BankAccount> findByType(@Param("t") AccountType type);
}
