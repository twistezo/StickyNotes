package com.twistezo.repositories;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NoteDAOTest {

    @Autowired
    private NoteDAO noteDAO;

    @Autowired
    private UserDAO userDAO;

    @Test
    public void findById() throws Exception {
        Assertions.assertThat(noteDAO.findById(1L)).isNotNull();
    }

    @Test
    public void findAllByOrderByDateDesc() throws Exception {
        Assertions.assertThat(noteDAO.findAllByOrderByDateDesc()).isNotNull();
    }

    @Test
    public void findAllByAuthor() throws Exception {
        Assertions.assertThat(noteDAO.findAllByAuthor(userDAO.getOne(1L))).isNotNull();
    }

}