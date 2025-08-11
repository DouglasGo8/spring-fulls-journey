package com.apress.springfulls.journey.procore.chapter06.plain.dao.pojos;

import com.apress.springfulls.journey.procore.chapter06.plain.dao.CoreDao;
import com.apress.springfulls.journey.procore.chapter06.plain.pojos.Singer;

import java.util.Optional;
import java.util.Set;

public interface SingerDao extends CoreDao {
  Set<Singer> findAll();

  Set<Singer> findByFirstName(String firstName);

  String findNameById(Long id);

  String findLastNameById(Long id);

  String findFirstNameById(Long id);

  Singer insert(Singer singer);

  void update(Singer singer);

  void delete(Long singerId);

  Set<Singer> findAllWithAlbums();

  void insertWithAlbum(Singer singer);
}
