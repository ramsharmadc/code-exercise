package com.recon.core.process;

import com.recon.common.FileConstants;
import com.recon.common.RuleOutcome;
import com.recon.core.rule.TransactionReconRule;
import com.recon.model.ReconciledRecord;
import com.recon.model.TransactionRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecordMatcher {

  private List<ReconciledRecord> match(List<TransactionRecord> X,
      List<TransactionRecord> Y) {

    List<ReconciledRecord> recondRecords = new ArrayList<>();

    for (int i = 0; i < X.size(); i++) {
      TransactionReconRule rule = new TransactionReconRule();
      RuleOutcome ruleOutcm = rule.run(X.get(i), Y.get(i));

      TransactionRecord x = X.get(i);
      TransactionRecord y = Y.get(i);

      ReconciledRecord recondRec = new ReconciledRecord();
      recondRec.setTxnRecX(x);
      recondRec.setTxnRecY(y);
      recondRec.setReconOutcome(ruleOutcm);
      recondRecords.add(recondRec);
    }
    return recondRecords;
  }

  public List<ReconciledRecord> match(
      Map<String, List<TransactionRecord>> mapdtxns) {
    List<TransactionRecord> recordsX =
        mapdtxns.get(FileConstants.fileAliasForLeftSide);
    List<TransactionRecord> recordsY =
        mapdtxns.get(FileConstants.fileAliasForRightSide);
    return match(recordsX, recordsY);
  }
}
