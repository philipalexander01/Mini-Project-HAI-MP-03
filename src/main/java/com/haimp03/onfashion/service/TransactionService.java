package com.haimp03.onfashion.service;

import com.haimp03.onfashion.entity.Transaction;
import com.haimp03.onfashion.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Iterable<Transaction> findAll(){
        return transactionRepository.findAll();
    }

    public void updateTransactionStatus(Long id, String status){
        transactionRepository.updateTransactionStatus(id, status);
    }

    public void deleteById(Long id){
        transactionRepository.deleteById(id);
    }

    public void addTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
