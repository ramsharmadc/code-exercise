package dataservice.web.controller;

import java.util.Calendar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import dataservice.web.model.FileRecord;
import dataservice.web.service.DataSnapshotService;

@Controller
@RequestMapping("/dataservice")
public class DataSnapshotController {

  private static final Logger LOGGER = LogManager.getLogger(DataSnapshotController.class);

  @Autowired
  private DataSnapshotService dataSnapshotService;

  @RequestMapping(method = RequestMethod.GET, value = "/ping")
  @ResponseBody
  public ResponseEntity<String> ping() {
    LOGGER.info("Received a Ping");
    return ResponseEntity.status(HttpStatus.OK).body("Service is up and running");
  }

  /**
   * API to upload the files. It takes file as a multipart file.
   */
  @PostMapping("/upload")
  @ResponseBody
  public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
    long uploadStartTime = Calendar.getInstance().getTimeInMillis();
    boolean fileUploadSuccess = false;
    try {
      LOGGER.info("File upload started");
      fileUploadSuccess = dataSnapshotService.uploadFile(file);
      long uploadFinishTime = Calendar.getInstance().getTimeInMillis();
      long timeTaken = uploadFinishTime - uploadStartTime;
      LOGGER.info("File upload finished in {} milli seconds", timeTaken);
    } catch (Exception e) {
      LOGGER.error("Error occurred while uploading file", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failure");
    }
    if (fileUploadSuccess)
      return ResponseEntity.status(HttpStatus.CREATED).body("Success");
    else
      return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Success");
  }

  @RequestMapping(method = RequestMethod.GET, value = "/get/{key}")
  @ResponseBody
  public ResponseEntity<FileRecord> get(@PathVariable("key") String key) {
    long startSearchAt = Calendar.getInstance().getTimeInMillis();
    FileRecord fileRecord = null;
    try {
      if (StringUtils.isEmpty(key)) {
        LOGGER.warn("Invalid key to search.");
      } else {
        LOGGER.info("Searching for key -> [{}] ", key);
        fileRecord = dataSnapshotService.get(key);
      }
      long startFinishedAt = Calendar.getInstance().getTimeInMillis();
      long timeTaken = startFinishedAt - startSearchAt;
      LOGGER.info("Search finished in {} milli seconds", timeTaken);
    } catch (Exception e) {
      LOGGER.error("Error occurred while searching for token -> [{}]", key, e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(fileRecord);
    }
    if (fileRecord != null)
      return ResponseEntity.status(HttpStatus.OK).body(fileRecord);
    else
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(fileRecord);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/remove/{key}")
  @ResponseBody
  public ResponseEntity<String> remove(@PathVariable("key") String key) {
    long requestStartTime = Calendar.getInstance().getTimeInMillis();
    boolean ifDeleted = false;
    try {
      if (StringUtils.isEmpty(key)) {
        LOGGER.warn("Invalid key to remove");
      } else {
        LOGGER.info("Removing reord for key -> [{}] ", key);
        ifDeleted = dataSnapshotService.remove(key);
      }
      long requestEndTime = Calendar.getInstance().getTimeInMillis();
      long timeTaken = requestEndTime - requestStartTime;
      LOGGER.info("Request served in {} milli seconds", timeTaken);
    } catch (Exception e) {
      LOGGER.error("Error occurred while searching for token -> [{}]", key, e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failure");
    }
    if (ifDeleted) {
      return ResponseEntity.status(HttpStatus.OK).body("Success");
    } else {
      return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Success");
    }
  }
}
