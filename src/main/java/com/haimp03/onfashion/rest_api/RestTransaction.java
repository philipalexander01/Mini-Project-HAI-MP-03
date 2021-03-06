package com.haimp03.onfashion.rest_api;

import com.haimp03.onfashion.dto.TransactionData;
import com.haimp03.onfashion.entity.Transaction;
import com.haimp03.onfashion.service.TransactionService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/admin/transactions")
public class RestTransaction {
    @Autowired
    private TransactionService transactionService;

    @Autowired
	private ModelMapper modelMapper;

    @GetMapping
    public ArrayList<TransactionData> index(){
        ArrayList<TransactionData> transactions = new ArrayList<>();
        for (Transaction transaction : transactionService.findAll()) {
            transactions.add(modelMapper.map(transaction, TransactionData.class));
        }
        return transactions;
    }


}
