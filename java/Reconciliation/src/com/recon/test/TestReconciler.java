package com.recon.test;

import com.recon.common.RuleOutcome;
import com.recon.core.rule.ReconciliationRule;
import com.recon.core.rule.TransactionReconRule;
import com.recon.model.TransactionRecord;

import java.math.BigDecimal;
import java.util.Date;

public class TestReconciler {

  public static void main(String[] args) {
    TestReconciler testCase = new TestReconciler();
    int result_1 = testCase.testExactMatchRule();
    int result_2 = testCase.testWeakMatchRule();
    int result_3 = testCase.testBreakRule();

    int passedCount = 0, failedCount = 0;

    if (result_1 == 0)
      passedCount += 1;
    else
      failedCount += 1;

    if (result_2 == 0)
      passedCount += 1;
    else
      failedCount += 1;

    if (result_3 == 0)
      passedCount += 1;
    else
      failedCount += 1;

    System.out.println("Total Test cases passed - " + passedCount);
    System.out.println("Total Test cases failed - " + failedCount);
  }

  public int testExactMatchRule() {
    TransactionRecord X = new TransactionRecord("x0", "0000190",
        new Date("01-Jun-2016"), new BigDecimal("123.01"));
    TransactionRecord Y = new TransactionRecord("y0", "0000190",
        new Date("01-Jun-2016"), new BigDecimal("123.01"));

    ReconciliationRule rule = new TransactionReconRule();
    RuleOutcome exact = rule.run(X, Y);

    if (!RuleOutcome.EXACT.equals(exact)) {
      System.out.println("Test Failed: testExactMatchRule.");
      return 1;
    } else {
      System.out.println("Test Passed: testExactMatchRuled.");
      return 0;
    }
  }

  public int testWeakMatchRule() {
    TransactionRecord X = new TransactionRecord("x0", "0000190",
        new Date("01-Jun-2016"), new BigDecimal("123.01"));
    TransactionRecord Y = new TransactionRecord("y0", "0000190",
        new Date("02-Jun-2016"), new BigDecimal("123.00"));

    ReconciliationRule rule = new TransactionReconRule();
    RuleOutcome exact = rule.run(X, Y);

    if (!RuleOutcome.WEAK.equals(exact)) {
      System.out.println("Test Failed: testWeakMatchRule.");
      return 1;
    } else {
      System.out.println("Test Passed: testWeakMatchRule.");
      return 0;
    }
  }

  public int testBreakRule() {
    TransactionRecord X = new TransactionRecord("x0", "0000190",
        new Date("01-Jun-2016"), new BigDecimal("123.01"));
    TransactionRecord Y = new TransactionRecord("y0", "0000190",
        new Date("10-Jun-2016"), new BigDecimal("123.98"));

    ReconciliationRule rule = new TransactionReconRule();
    RuleOutcome exact = rule.run(X, Y);

    if (!RuleOutcome.BREAK.equals(exact)) {
      System.out.println("Test Failed: testWeakMatchRule.");
      return 1;
    } else {
      System.out.println("Test Passed: testWeakMatchRule.");
      return 0;
    }
  }
}
