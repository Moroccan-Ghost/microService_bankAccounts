package com.enset.microService_bankAccounts.service;

import com.enset.microService_bankAccounts.dto.BankAccountRequestDTO;
import com.enset.microService_bankAccounts.dto.BankAccountResponseDTO;
import com.enset.microService_bankAccounts.entities.BankAccount;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);
    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO);
}
