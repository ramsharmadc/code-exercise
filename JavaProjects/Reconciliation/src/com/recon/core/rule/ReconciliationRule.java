package com.recon.core.rule;

import com.recon.common.RuleOutcome;
import com.recon.model.Record;

public interface ReconciliationRule {

  RuleOutcome run(Record recA, Record recB);
}
