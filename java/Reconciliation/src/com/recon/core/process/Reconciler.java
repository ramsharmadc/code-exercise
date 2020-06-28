package com.recon.core.process;

import com.recon.common.FileConstants;
import com.recon.model.ReconciledRecord;
import com.recon.model.TransactionRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class Reconciler {
  public void start(File fX, File fY) throws IOException, ParseException {
    if (fX != null && fY != null) {
      RecordReader recdr = new RecordReader();
      Map<String, List<TransactionRecord>> mapdTxns = recdr.readRecords(fX, fY);

      // run rules
      RecordMatcher recMatchr = new RecordMatcher();
      List<ReconciledRecord> recondRecords = recMatchr.match(mapdTxns);

      // write output
      File f = new File(FileConstants.reportFile);
      ReportPublisher pub = new ReportPublisher(f);
      pub.publish(recondRecords);
    } else
      throw new FileNotFoundException("Invalid files passed.");
  }
}
