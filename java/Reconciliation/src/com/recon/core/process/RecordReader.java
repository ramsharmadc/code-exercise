package com.recon.core.process;

import com.recon.common.FileConstants;
import com.recon.model.TransactionRecord;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

public class RecordReader {

  public Map<String, List<TransactionRecord>> readRecords(File txnFileForX,
      File txnFileForY) throws IOException, ParseException {
    List<TransactionRecord> recordsX = readTransactions(txnFileForX);
    List<TransactionRecord> recordsY = readTransactions(txnFileForY);
    Map<String, List<TransactionRecord>> mapdTxns = new HashMap<>();
    mapdTxns.put(FileConstants.fileAliasForLeftSide, recordsX);
    mapdTxns.put(FileConstants.fileAliasForRightSide, recordsY);
    return mapdTxns;
  }

  private List<TransactionRecord> readTransactions(File f)
      throws FileNotFoundException, IOException, ParseException {
    List<TransactionRecord> records = new ArrayList<>();
    try (FileInputStream fip = new FileInputStream(f);
        Scanner scn = new Scanner(fip);) {
      while (scn.hasNext()) {
        String line = scn.nextLine();
        String[] tokens = line.split(";");
        TransactionRecord rec =
            new TransactionRecord(tokens[0].trim(), tokens[1].trim(),
                new Date(tokens[2].trim()), new BigDecimal(tokens[3].trim()));
        records.add(rec);
      }
    }
    return records;
  }
}
