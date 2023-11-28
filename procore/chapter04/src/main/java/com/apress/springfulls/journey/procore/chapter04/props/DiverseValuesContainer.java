package com.apress.springfulls.journey.procore.chapter04.props;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
@Component("builtInSample")
public class DiverseValuesContainer {
  private byte[] bytes; // ByteArrayPropertyEditor
  private Character character; //CharacterEditor
  private Class<?> cls; // ClassEditor
  private Boolean trueOrFalse; // CustomBooleanEditor
  private List<String> stringList; // CustomCollectionEditor
  private Date date; // CustomDateEditor
  private Float floatValue; // CustomNumberEditor
  private File file; // FileEditor
  private InputStream stream; // InputStreamEditor
  private Locale locale; // LocaleEditor

  private Pattern pattern;
  private Properties properties;
  private String trimString;
  private URL url;


  @Value("A")
  public void setCharacter(Character character) {
    log.info("Setting character: {}", character);
    this.character = character;
  }

  @Value("java.lang.String")
  public void setCls(Class<?> cls) {
    log.info("Setting class: {}", cls.getName());
    this.cls = cls;
  }

  @Value("#{systemProperties['java.io.tmpdir']}#{systemProperties['file.separator']}test.txt")
  public void setFile(File file) {
    log.info("Setting file: {}", file.getAbsolutePath());
    this.file = file;
  }

  @Value("en_US")
  public void setLocale(Locale locale) {
    log.info("Setting locale: {}", locale.getDisplayName());
    this.locale = locale;
  }

  @Value("name=Ben age=41")
  public void setProperties(Properties properties) {
    log.info("Loaded {}", properties.size() + " properties");
    this.properties = properties;
  }

  @Value("https://iuliana-cosmina.com")
  public void setUrl(URL url) {
    log.info("Setting URL: {}", url.toExternalForm());
    this.url = url;
  }

  @Value("John Mayer")
  public void setBytes(byte... bytes) {
    log.info("Setting bytes: {}", Arrays.toString(bytes));
    this.bytes = bytes;
  }

  @Value("true")
  public void setTrueOrFalse(Boolean trueOrFalse) {
    log.info("Setting Boolean: {}", trueOrFalse);
    this.trueOrFalse = trueOrFalse;
  }

  @Value("#{valuesHolder.stringList}")
  public void setStringList(List<String> stringList) {
    log.info("Setting stringList with: {}", stringList);
    this.stringList = stringList;
  }

  @Value("20/08/1981")
  public void setDate(Date date) {
    log.info("Setting date: {}", date);
    this.date = date;
  }

  @Value("123.45678")
  public void setFloatValue(Float floatValue) {
    log.info("Setting float value: {}", floatValue);
    this.floatValue = floatValue;
  }

  @Value("#{valuesHolder.inputStream}")
  public void setStream(InputStream stream) {
    this.stream = stream;
    log.info("Setting stream & reading from it: {}",
            new BufferedReader(new InputStreamReader(stream)).lines().parallel().
                    collect(Collectors.joining("\n")));
  }

  @Value("a*b")
  public void setPattern(Pattern pattern) {
    log.info("Setting pattern: {}", pattern);
    this.pattern = pattern;
  }

  @Value(" String need trimming ")
  public void setTrimString(String trimString) {
    log.info("Setting trim string: {}", trimString);
    this.trimString = trimString;
  }

  public static class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
      var dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
      registry.registerCustomEditor(Date.class,
              new CustomDateEditor(dateFormatter, true));
      registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
  }

}
