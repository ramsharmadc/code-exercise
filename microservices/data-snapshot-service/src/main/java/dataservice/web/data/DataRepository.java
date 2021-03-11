package dataservice.web.data;

import java.util.List;
import dataservice.web.model.FileRecord;

public interface DataRepository {

  FileRecord findByPrimaryKey(String primaryKey);

  List<FileRecord> findAll();

  boolean create(FileRecord fileRec);

  boolean create(List<FileRecord> fileRecList);

  boolean delete(String primaryKey);

  boolean delete(FileRecord fileRec);

  boolean update(FileRecord fileRec);

  void dump();

  void truncate();

  int size();
}
