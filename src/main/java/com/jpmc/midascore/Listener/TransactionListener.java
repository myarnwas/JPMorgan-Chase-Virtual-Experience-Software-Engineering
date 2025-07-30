package com.jpmc.midascore.Listener;
import com.jpmc.midascore.model.Transaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.jpmc.midascore.Configuration.KafkaTopicConfig;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TransactionListener {
    private final KafkaTopicConfig kafkaTopicConfig;

    @Autowired
    public TransactionListener(KafkaTopicConfig kafkaTopicConfig) {
        this.kafkaTopicConfig = kafkaTopicConfig;
    }

    @KafkaListener(
    topics = "${kafka.topic}",
    groupId = "midas-group",
    containerFactory = "transactionKafkaListenerContainerFactory"
)

    public void listen(Transaction transaction) {
        System.out.println("✅ Received transaction: " + transaction);
    }
    /*@KafkaListener(topics = "#{kafkaTopicConfig.topic}", groupId = "midas-group", containerFactory = "transactionKafkaListenerContainerFactory")
    public void listen(Transaction transaction) {
        System.out.println("Received transaction: " + transaction);
        // No need to process the transaction yet
    }*/
    
}
