package dataservice.web.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import dataservice.web.data.DataRepository;
import dataservice.web.model.FileRecord;

@Service
public class FileStorageService implements StorageService {

  private static final Logger LOGGER = LogManager.getLogger(FileStorageService.class);

  @Autowired
  private DataRepository dataRepository;

  @Override
  public boolean persist(File file) {
    try {
      return readFileAndPersistRecords(file);
    } catch (IOException e) {
      LOGGER.error("Error while persisting the file records", e);
      return false;
    }
  }

  @Override
  public boolean persist(File[] files) {
    if (files != null && files.length > 0) {
      return Arrays.asList(files).stream().map(file -> persist(file)).anyMatch(x -> x == false);
    } else
      return false;
  }

  private boolean persistRecord(FileRecord fileRec) {
    return dataRepository.create(fileRec);
  }

  /**
   * Read the file line by line, create records and persist in data repository
   * 
   * @return true if the file is persisted otherwise false
   * @throws IOException
   */
  private boolean readFileAndPersistRecords(File file) throws IOException {
    List<String> rawLines =
        Files.readAllLines(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8);
    boolean headerRead = false;

    if (rawLines != null && !rawLines.isEmpty()) {

      boolean isFullFilePersisted = false;;

      for (String lineRecord : rawLines) {

        if (!headerRead) {
          headerRead = true;
          continue;
        }

        // if record is valid then only read, otherwise skip the record
        if (validLineRecord(lineRecord)) {
          String[] recTokens = lineRecord.split(",");
          String primaryKey = recTokens[0];
          String name = recTokens[1];
          String description = recTokens[2];
          String updateTimestampStr = recTokens[3];

          if (validDateTime(updateTimestampStr)) {
            isFullFilePersisted = true;
            LocalDateTime updateTimestamp = LocalDateTime.parse(updateTimestampStr);
            FileRecord fileRec = new FileRecord(primaryKey, name, description, updateTimestamp);
            isFullFilePersisted &= persistRecord(fileRec);
          }
        }
      }
      return isFullFilePersisted;
    }
    return false;
  }


  private boolean validLineRecord(String lineRecord) {
    String[] recTokens = lineRecord.split(",");
    if (recTokens.length != 4) {
      return false;
    }
    boolean validAll = true;
    for (String s : recTokens) {
      validAll &= validToken(s);
    }
    return validAll;
  }

  private boolean validToken(String token) {
    return !(StringUtils.isEmpty(token));
  }

  private boolean validDateTime(String dateTimeiLiteral) {
    try {
      LocalDateTime.parse(dateTimeiLiteral);
    } catch (Exception e) {
      return false;
    }
    return true;
  }
}
