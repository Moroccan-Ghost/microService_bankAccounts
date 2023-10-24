package com.enset.microService_bankAccounts.web;

import com.enset.microService_bankAccounts.dto.BankAccountRequestDTO;
import com.enset.microService_bankAccounts.dto.BankAccountResponseDTO;
import com.enset.microService_bankAccounts.entities.BankAccount;
import com.enset.microService_bankAccounts.entities.Customer;
import com.enset.microService_bankAccounts.repositories.BankAccountRepository;
import com.enset.microService_bankAccounts.repositories.CustomerRepository;
import com.enset.microService_bankAccounts.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException("No Account Found"));
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccountRequestDTO){
        return accountService.addAccount(bankAccountRequestDTO);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccountRequestDTO){
        return accountService.updateAccount(id, bankAccountRequestDTO);
    }

    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
        bankAccountRepository.deleteById(id);
        return true;
    }

    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }

}
/*
@Data @NoArgsConstructor @AllArgsConstructor
class BankAccountDTO{
    private String type;
    private Double balance;
    private String currency;

}*/