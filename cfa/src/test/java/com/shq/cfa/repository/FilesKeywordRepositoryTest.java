package com.shq.cfa.repository;

import com.shq.cfa.entity.FilesKeyword;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class FilesKeywordRepositoryTest {
  @Autowired
  FilesKeywordRepository filesKeywordRepository;
  @Test
  public void saveTast(){
    FilesKeyword filesKeyword = new FilesKeyword();
    filesKeyword.setKeyword("民事");
    filesKeyword.setType("民事案卷");
    filesKeyword.setWeight(1);
    FilesKeyword result = filesKeywordRepository.save(filesKeyword);
    Assert.assertNotNull(result);

  }

}