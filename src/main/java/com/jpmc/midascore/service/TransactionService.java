package com.jpmc.midascore.service;

import com.jpmc.midascore.model.TransactionRecord;
import com.jpmc.midascore.model.User;
import com.jpmc.midascore.repository.TransactionRecordRepository;
import com.jpmc.midascore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRecordRepository transactionRecordRepository;

    @Transactional
    public void validateAndRecordTransaction(Long senderId, Long recipientId, Double amount) {
        User sender = userRepository.findById(senderId).orElse(null);
        User recipient = userRepository.findById(recipientId).orElse(null);

        if (sender == null || recipient == null) {
            return; // Invalid sender or recipient
        }

        if (sender.getBalance() < amount) {
            return; // Insufficient balance
        }

        // Adjust balances
        sender.setBalance(sender.getBalance() - amount);
        recipient.setBalance(recipient.getBalance() + amount);

        // Save updates to users
        userRepository.save(sender);
        userRepository.save(recipient);

        // Record the transaction
        TransactionRecord record = new TransactionRecord(amount, LocalDateTime.now(), sender, recipient);
        transactionRecordRepository.save(record);
    }
}
