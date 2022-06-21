package com.asantos.newbank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asantos.newbank.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	
	Account findByAccount(String account); 

}
