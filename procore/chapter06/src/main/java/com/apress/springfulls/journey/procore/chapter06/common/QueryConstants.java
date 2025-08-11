package com.apress.springfulls.journey.procore.chapter06.common;

public enum QueryConstants {
  ;
  public static final String FIND_BY_FIRST_NAME = "select id, first_name, last_name, birth_date from tbl_singer where first_name = :first_name";
  public static final String NAMED_FIND_NAME = "select CONCAT(first_name , ' ' , last_name) from tbl_singer where id = :singerId";
  public static final String PARAMETRIZED_FIND_NAME = "select CONCAT(first_name , ' ' , last_name) from tbl_singer where id = ?";
  public static final String FIND_NAME = "select first_name, last_name from tbl_singer where id=";

  public static final String SIMPLE_INSERT = "insert into tbl_singer (first_name, last_name, birth_date) values (?, ?, ?)";
  public static final String SIMPLE_DELETE = "delete from tbl_singer where id=?";
  public static final String ALL_SELECT = "select * from tbl_singer";
  public static final String ALL_JOIN_SELECT = "select s.id, s.first_name, s.last_name, s.birth_date, " +
          "a.id AS album_id, a.title, a.release_date " +
          "from tbl_singer s " +
          "left join tbl_album a on s.id = a.singer_id";

  public static final String UPDATE_SINGER = "update tbl_singer set first_name=:first_name, last_name=:last_name, birth_date=:birth_date where id=:id";

  public static final String INSERT_SINGER = "insert into tbl_singer (first_name, last_name, birth_date) values (:first_name, :last_name, :birth_date)";

  public static final String INSERT_SINGER_ALBUM = "insert into ALBUM (singer_id, title, release_date) values (:singer_id, :title, :release_date)";
  public static final String FIND_SINGER_ALBUM = "SELECT s.id, s.first_name, s.last_name, s.birth_date" +
          ", a.id AS album_id, a.title, a.release_date FROM tbl_singer s " +
          "LEFT JOIN ALBUM a ON s.id = a.singer_id";
}
