package com.lz.cfa.repository;

import com.lz.cfa.entity.FilesKeyword;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilesKeywordRepositoryTest {
  @Autowired
  FilesKeywordRepository filesKeywordRepository;
  @Test
  public void saveTast(){
    FilesKeyword filesKeyword = new FilesKeyword();
    filesKeyword.setKeyword("民事");
    filesKeyword.setType(1);
    filesKeyword.setWeight(1f);
    FilesKeyword result = filesKeywordRepository.save(filesKeyword);
    Assert.assertNotNull(result);

  }

}