package com.haimp03.onfashion.repository;

import com.haimp03.onfashion.entity.Transaction;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE transactions set status = :status WHERE transaction_id = :transaction_id", nativeQuery = true)
    public void updateTransactionStatus(@Param("transaction_id") Long transaction_id,@Param("status") String status);
}
