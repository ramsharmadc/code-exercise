package com.recon.core.rule;

import com.recon.common.RuleOutcome;
import com.recon.common.RulesConstant;
import com.recon.model.Record;
import com.recon.model.TransactionRecord;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class TransactionReconRule implements ReconciliationRule {

  private RuleOutcome ruleLogic(TransactionRecord A, TransactionRecord B) {

    int threshold = RuleOutcome.EXACT.ordinal();

    // Check Posting Date
    if (!(A.getPostingDate().equals(B.getPostingDate()))) {
      // dates are not equal, check the day difference
      int dayDiff = absoluteDayDiff(A.getPostingDate(), B.getPostingDate());
      threshold =
          adjustThreshold(threshold, (dayDiff <= RulesConstant.dayDiffThreshold)
              ? RuleOutcome.WEAK
              : RuleOutcome.BREAK);
    }

    // Check Amount
    if (!(A.getAmount().equals(B.getAmount()))) {
      double amtDiff = absoluteAmountDiff(A.getAmount(), B.getAmount());
      threshold = adjustThreshold(threshold,
          (amtDiff <= RulesConstant.amountDiffThreshold)
              ? RuleOutcome.WEAK
              : RuleOutcome.BREAK);
    }

    // Check Account ID
    if (!(A.getAccountId().equals(B.getAccountId()))) {
      threshold = adjustThreshold(threshold, RuleOutcome.BREAK);
    }

    return threshold == RuleOutcome.EXACT.ordinal()
        ? RuleOutcome.EXACT
        : (threshold == RuleOutcome.WEAK.ordinal()
            ? RuleOutcome.WEAK
            : RuleOutcome.BREAK);
  }

  private int absoluteDayDiff(Date date1, Date date2) {
    return Math.abs(dayDiff(date1, date2));
  }

  private int dayDiff(Date date1, Date date2) {
    Calendar c1 = Calendar.getInstance();
    Calendar c2 = Calendar.getInstance();
    c1.setTime(date1);
    c2.setTime(date2);

    // weekend(special) scenarios
    if ((c1.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY
        || c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
        && (c2.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
            || c2.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)) {
      return 1;
    }

    return (c1.get(Calendar.DAY_OF_WEEK) - c2.get(Calendar.DAY_OF_WEEK));
  }

  private double absoluteAmountDiff(BigDecimal amtA, BigDecimal amtB) {
    return Math.abs(amountDiff(amtA, amtB));
  }

  private double amountDiff(BigDecimal amtA, BigDecimal amtB) {
    return amtA.subtract(amtB).doubleValue();
  }

  private int adjustThreshold(int threshold, RuleOutcome newThreshold) {
    return (newThreshold.ordinal() > threshold)
        ? newThreshold.ordinal()
        : threshold;
  }

  @Override
  public RuleOutcome run(Record A, Record B) {
    return ruleLogic((TransactionRecord) A, (TransactionRecord) B);
  }
}
