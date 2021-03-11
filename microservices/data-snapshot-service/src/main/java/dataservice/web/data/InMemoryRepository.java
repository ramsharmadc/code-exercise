package dataservice.web.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import dataservice.web.model.FileRecord;


/**
 * The In-Memory database repository is a simulation any RDBMS or NoSql DB. CRUD operation can be
 * performed on this Database repository. Database will be cleared once the system is restarted.
 * This DB repository can be replaced with any other data repository.
 * 
 */
@Component
public class InMemoryRepository implements DataRepository {

  private static final Logger LOGGER = LogManager.getLogger(InMemoryRepository.class);
  private static final Map<String, FileRecord> MEM_DB = new ConcurrentHashMap<>();

  @PostConstruct
  public void init() {
    LOGGER.info("initializing In-Memory database...");
  }

  @Override
  public FileRecord findByPrimaryKey(String primaryKey) {
    if (MEM_DB.containsKey(primaryKey))
      return MEM_DB.get(primaryKey);
    else
      return null;
  }

  @Override
  public List<FileRecord> findAll() {
    List<FileRecord> fileRecords = new ArrayList<>();
    MEM_DB.entrySet().stream().forEach(x -> fileRecords.add(x.getValue()));
    return fileRecords;
  }

  @Override
  public boolean create(FileRecord fileRec) {
    if (validFileRecord(fileRec)) {
      FileRecord fileRecordDao = new FileRecord(fileRec.getPrimaryKey(), fileRec.getName(),
          fileRec.getDescription(), fileRec.getUpdatedTimestamp());
      MEM_DB.put(fileRecordDao.getPrimaryKey(), fileRecordDao);
      return true;
    }
    return false;
  }

  @Override
  public boolean create(List<FileRecord> fileRecList) {
    if (fileRecList != null && !fileRecList.isEmpty()) {
      fileRecList.stream().forEach(x -> create(x));
      return true;
    }
    return false;
  }

  @Override
  public boolean delete(String primaryKey) {
    MEM_DB.entrySet().removeIf(x -> x.getKey().equals(primaryKey));
    return true;
  }

  @Override
  public boolean delete(FileRecord fileRec) {
    if (fileRec != null) {
      delete(fileRec);
      return true;
    }
    return false;
  }

  @Override
  public boolean update(FileRecord fileRec) {
    if (validFileRecord(fileRec)) {
      create(fileRec);
      return true;
    }
    return false;
  }

  @Override
  public void dump() {
    LOGGER.info("Database records..");
    MEM_DB.entrySet().parallelStream().forEach(x -> LOGGER.info(x.toString()));
  }

  @Override
  public void truncate() {
    MEM_DB.clear();
  }

  @Override
  public int size() {
    return MEM_DB.size();
  }

  private boolean validFileRecord(FileRecord fileRec) {
    return !(StringUtils.isEmpty(fileRec.getPrimaryKey()) || StringUtils.isEmpty(fileRec.getName())
        || StringUtils.isEmpty(fileRec.getDescription())
        || StringUtils.isEmpty(fileRec.getUpdatedTimestamp()));
  }
}
