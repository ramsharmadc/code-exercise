package com.recon.model;

import com.recon.common.RuleOutcome;

import java.io.Serializable;

public class ReconciledRecord implements Serializable {

  private static final long serialVersionUID = 8857101351648274164L;
  private TransactionRecord txnRecX;
  private TransactionRecord txnRecY;
  private RuleOutcome reconOutcome;

  public TransactionRecord getTxnRecX() {
    return txnRecX;
  }

  public void setTxnRecX(TransactionRecord txnRec) {
    this.txnRecX = txnRec;
  }

  public TransactionRecord getTxnRecY() {
    return txnRecY;
  }

  public void setTxnRecY(TransactionRecord txnRec) {
    this.txnRecY = txnRec;
  }

  public RuleOutcome getReconOutcome() {
    return reconOutcome;
  }

  public void setReconOutcome(RuleOutcome reconFind) {
    this.reconOutcome = reconFind;
  }

  @Override
  public String toString() {
    return txnRecX.getTransactionId() + txnRecY.getTransactionId();
  }
}
