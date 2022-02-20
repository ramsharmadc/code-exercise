package com.recon.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TransactionRecord extends Record implements Serializable {

  private static final long serialVersionUID = -337073332369797840L;
  private String transactionId;
  private String accountId;
  private Date postingDate;
  private BigDecimal amount;

  public TransactionRecord(String transactionId, String accountId,
      Date postingDate, BigDecimal amount) {
    super();
    this.transactionId = transactionId;
    this.accountId = accountId;
    this.postingDate = postingDate;
    this.amount = amount;
  }

  public String getAccountId() {
    return accountId;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public Date getPostingDate() {
    return postingDate;
  }

  public String getTransactionId() {
    return transactionId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public void setPostingDate(Date postingDate) {
    this.postingDate = postingDate;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  @Override
  public String toString() {
    return getTransactionId() + ";" + getAccountId() + ";" + getPostingDate()
        + ";" + getAmount();
  }
}
