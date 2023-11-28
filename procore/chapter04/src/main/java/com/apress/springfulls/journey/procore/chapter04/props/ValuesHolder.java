package com.apress.springfulls.journey.procore.chapter04.props;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@Getter
@Component
public class ValuesHolder {
  List<String> stringList;
  InputStream inputStream;

  public ValuesHolder(List<String> stringList) {
    this.stringList = List.of("Mayer", "Psihoza", "Mazikeen");
    try {
      this.inputStream = new FileInputStream(
              System.getProperty("java.io.tmpdir")
                      + System.getProperty("file.separator")
                      + "test.txt"
      );
    } catch (FileNotFoundException e) {
      e.printStackTrace(); // we are not interested in this exception
    }
  }
}
