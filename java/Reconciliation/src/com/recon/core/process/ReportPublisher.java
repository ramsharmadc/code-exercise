package com.recon.core.process;

import com.recon.common.FileConstants;
import com.recon.common.RuleOutcome;
import com.recon.model.ReconciledRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReportPublisher {

  private File reportFile;

  public ReportPublisher(File f) {
    reportFile = f;
  }

  public void publish(List<ReconciledRecord> recondRecords)
      throws FileNotFoundException, IOException {
    // create buckets for each category
    if (recondRecords != null && !recondRecords.isEmpty()) {
      List<ReconciledRecord> exactMatches =
          createBucket(recondRecords, RuleOutcome.EXACT);
      List<ReconciledRecord> weekMatches =
          createBucket(recondRecords, RuleOutcome.WEAK);
      List<ReconciledRecord> breaks =
          createBucket(recondRecords, RuleOutcome.BREAK);

      // create the report now
      try (FileOutputStream f_out = new FileOutputStream(reportFile);
          OutputStreamWriter write_out = new OutputStreamWriter(f_out);) {

        // keep building output string
        StringBuilder strB = new StringBuilder();
        strB.append("# XY exact matches\n");
        appendMatches(strB, exactMatches);

        strB.append("# XY weak matches\n");
        appendMatches(strB, weekMatches);

        strB.append("# X breaks\n");
        appendBreaksForX(strB, breaks);

        strB.append("# Y breaks\n");
        appendBreaksForY(strB, breaks);

        // finally write to output stream
        System.out.println(
            "Writing Reconciliation report to - " + FileConstants.reportFile);
        write_out.write(strB.toString());
      }
    }
  }

  private void appendMatches(StringBuilder strB,
      List<ReconciledRecord> records) {
    for (ReconciledRecord r : records) {
      strB.append(r.toString() + ", ");
    }
    strB.append("\n\n");
  }

  private void appendBreaksForX(StringBuilder strB,
      List<ReconciledRecord> breaks) {
    for (ReconciledRecord r : breaks) {
      strB.append(r.getTxnRecX().getTransactionId() + ", ");
    }
    strB.append("\n\n");
  }

  private void appendBreaksForY(StringBuilder strB,
      List<ReconciledRecord> breaks) {
    for (ReconciledRecord r : breaks) {
      strB.append(r.getTxnRecY().getTransactionId() + ", ");
    }
  }

  private List<ReconciledRecord> createBucket(
      List<ReconciledRecord> recondRecords, RuleOutcome type) {
    List<ReconciledRecord> breaks = new ArrayList<>();
    for (ReconciledRecord r : recondRecords) {
      if (type.equals(r.getReconOutcome())) {
        breaks.add(r);
      }
    }
    return breaks;
  }
}
