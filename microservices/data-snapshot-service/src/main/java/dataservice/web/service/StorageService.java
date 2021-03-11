package dataservice.web.service;

import java.io.File;

public interface StorageService {

  boolean persist(File file);

  boolean persist(File[] files);
}
