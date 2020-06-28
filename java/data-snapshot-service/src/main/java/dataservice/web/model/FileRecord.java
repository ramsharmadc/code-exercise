package dataservice.web.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class FileRecord {

  private String primaryKey;
  private String name;
  private String description;
  private LocalDateTime updatedTimestamp;

  public FileRecord(String primaryKey, String name, String description,
      LocalDateTime updatedTimestamp) {
    super();
    this.primaryKey = primaryKey;
    this.name = name;
    this.description = description;
    this.updatedTimestamp = updatedTimestamp;
  }

  public String getPrimaryKey() {
    return primaryKey;
  }

  public void setPrimaryKey(String primaryKey) {
    this.primaryKey = primaryKey;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescriptio(String description) {
    this.description = description;
  }

  public LocalDateTime getUpdatedTimestamp() {
    return updatedTimestamp;
  }

  public void setUpdatedTimestamp(LocalDateTime updatedTimestamp) {
    this.updatedTimestamp = updatedTimestamp;
  }

  @Override
  public String toString() {
    return "FileRecord [primaryKey=" + primaryKey + ", name=" + name + ", description="
        + description + ", updatedTimestamp=" + updatedTimestamp + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(primaryKey, name, description, updatedTimestamp);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof FileRecord))
      return false;
    if (this == obj)
      return true;
    FileRecord fileRec = (FileRecord) obj;
    return (Objects.equals(this.primaryKey, fileRec.primaryKey)
        && Objects.equals(this.name, fileRec.name)
        && Objects.equals(this.description, fileRec.description)
        && Objects.equals(this.updatedTimestamp, fileRec.updatedTimestamp));
  }
}
