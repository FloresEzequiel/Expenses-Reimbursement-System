package com.revature.models;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 * This is the model class that stores the values from a SQL query from
 * the ers_reimbursement table
 */
public class Reimbursement {
    Integer id;
    Double amount;
    Timestamp submitted;
    Timestamp resolved;
    String description;
    String receipt;
    Integer author;
    Integer resolver;
    Integer status;
    Integer type;

    public Reimbursement(Integer id, Double amount, Timestamp submitted, Timestamp resolved, String description, String receipt, Integer author, Integer status, Integer type) {
        this.id = id;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.receipt = receipt;
        this.author = author;
        this.status = status;
        this.type = type;
    }

    public Reimbursement() {
    }

    public Reimbursement(Integer id, Double amount, Timestamp submitted, Timestamp resolved, String description, String receipt, Integer author, Integer resolver, Integer status, Integer type) {
        this.id = id;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.receipt = receipt;
        this.author = author;
        this.resolver = resolver;
        this.status = status;
        this.type = type;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Timestamp getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Timestamp submitted) {
        this.submitted = submitted;
    }

    public Timestamp getResolved() {
        return resolved;
    }

    public void setResolved(Timestamp resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getResolver() {
        return resolver;
    }

    public void setResolver(Integer resolver) {
        this.resolver = resolver;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", amount=" + amount +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                ", description='" + description + '\'' +
                ", receipt='" + receipt + '\'' +
                ", author=" + author +
                ", resolver=" + resolver +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}
