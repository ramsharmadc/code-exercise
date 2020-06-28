package com.recon;

import com.recon.common.FileConstants;
import com.recon.core.process.Reconciler;

import java.io.File;

public class StartReconciliation {
  public static void main(String args[]) {
    System.out.println("Reconcilaition started");
    Reconciler recon = new Reconciler();
    try {
      if (args.length == 2 && (args[0] != null && args[1] != null)) {
        String fileNameX = args[0];
        String fileNameY = args[1];
        System.out.println("Reading files from location:");
        System.out.println("File 1: " + FileConstants.transactionFileX);
        System.out.println("File 2: " + FileConstants.transactionFileY);
        File fX = new File(fileNameX);
        File fY = new File(fileNameY);
        recon.start(fX, fY);
      } else {
        System.out
            .println("Usgae Error: Run Like {command filename1 filename2}");
        System.out.println("Using default location to read transaction files.");
        System.out.println("File 1: " + FileConstants.transactionFileX);
        System.out.println("File 2: " + FileConstants.transactionFileY);
        File fX = new File(FileConstants.transactionFileX);
        File fY = new File(FileConstants.transactionFileY);
        recon.start(fX, fY);
      }
    } catch (Exception e) {
      System.out.println("ERROR - " + e.getMessage());
      e.printStackTrace();
    }
    System.out.println("Reconcilaition finished");
  }
}
