package dataservice.web.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import dataservice.web.data.DataRepository;
import dataservice.web.model.FileRecord;

@Component
public class DataSnapshotService {

  private static final Logger LOGGER = LogManager.getLogger(DataSnapshotService.class);

  @Autowired
  private FileStorageService storageService;

  @Autowired
  private DataRepository dataRepository;

  public boolean uploadFile(MultipartFile multipartFile) {
    try {
      File file = convertMultiPartToFile(multipartFile);
      storageService.persist(new File[] {file});
    } catch (IOException e) {
      LOGGER.error("Error while uploading the file", e);
      return false;
    }
    return true;
  }

  public FileRecord get(String primaryKey) {
    return dataRepository.findByPrimaryKey(primaryKey);
  }

  public boolean remove(String primaryKey) {
    return dataRepository.delete(primaryKey);
  }

  private File convertMultiPartToFile(MultipartFile file) throws IOException {
    File convFile = new File(file.getOriginalFilename());
    FileOutputStream fos = new FileOutputStream(convFile);
    fos.write(file.getBytes());
    fos.close();
    return convFile;
  }
}
