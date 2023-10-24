package com.enset.microService_bankAccounts;

import com.enset.microService_bankAccounts.entities.BankAccount;
import com.enset.microService_bankAccounts.entities.Customer;
import com.enset.microService_bankAccounts.enums.AccountType;
import com.enset.microService_bankAccounts.repositories.BankAccountRepository;
import com.enset.microService_bankAccounts.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class MicroServiceBankAccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceBankAccountsApplication.class, args);
	}
	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
		return args -> {
			Stream.of("Mohamed","Yassin","Karam").forEach( c -> {
				Customer customer = Customer.builder()
						.name(c)
						.build();
				customerRepository.save(customer);
			});

			customerRepository.findAll().forEach(customer -> {
				for (int i = 0; i < 3; i++) {
					BankAccount bankAccount = BankAccount.builder()
							.id(UUID.randomUUID().toString())
							.type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
							.balance(Math.random() * 50000)
							.createdAt(new Date())
							.currency("MAD")
							.customer(customer)
							.build();
					bankAccountRepository.save(bankAccount);
				}
			});


		};
	}
}
