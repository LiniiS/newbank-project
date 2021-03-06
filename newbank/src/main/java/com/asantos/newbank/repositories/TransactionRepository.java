package com.asantos.newbank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asantos.newbank.entities.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
