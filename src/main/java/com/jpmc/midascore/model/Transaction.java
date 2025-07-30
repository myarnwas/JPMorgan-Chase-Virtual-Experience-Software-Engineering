package com.jpmc.midascore.model;

import java.math.BigDecimal;


public class Transaction {
    private String id;
    private BigDecimal amount;
    private String timestamp;

    // Constructor بدون معاملات (مطلوب من Spring/Kafka للتنزيل)
    public Transaction() {
    }

    // Constructor مع كل الخصائص (اختياري)
    public Transaction(String id, BigDecimal amount, String timestamp) {
        this.id = id;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    // toString (مفيد للطباعات والديباغ)
    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
