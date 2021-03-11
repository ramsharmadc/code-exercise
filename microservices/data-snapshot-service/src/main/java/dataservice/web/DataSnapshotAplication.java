package dataservice.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"dataservice"})
public class DataSnapshotAplication {

  public static void main(String[] args) {
    SpringApplication.run(DataSnapshotAplication.class, args);
  }
}
