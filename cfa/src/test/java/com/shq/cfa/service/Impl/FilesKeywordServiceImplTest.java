package com.shq.cfa.service.Impl;

import com.shq.cfa.entity.FilesKeyword;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilesKeywordServiceImplTest {
  @Autowired
  private FilesKeywordServiceImpl filesKeywordService;
  @Test
  public void findOne() throws Exception {
    FilesKeyword filesKeyword = filesKeywordService.findOne(1);
    Assert.assertEquals("1",Integer.toString(filesKeyword.getId()));
  }

  @Test
  public void save() throws Exception {
    FilesKeyword filesKeyword = new FilesKeyword();
    filesKeyword.setKeyword("刑事");
    filesKeyword.setType(2);
    filesKeyword.setWeight(1l);
    FilesKeyword result = filesKeywordService.save(filesKeyword);
    Assert.assertNotNull(result);
  }

  @Test
  public void findByKeyword() throws Exception {
    FilesKeyword filesKeyword = filesKeywordService.findByKeywordLike("民事");
  }

  @Test
  public void findAll() throws Exception {
    List<FilesKeyword> filesKeywordList = filesKeywordService.findAll();
    Assert.assertNotEquals(0,filesKeywordList.size());
  }

  @Test
  public void findByType() throws Exception {
    List<FilesKeyword> filesKeywordList = filesKeywordService.findByType("民事");
  }

}