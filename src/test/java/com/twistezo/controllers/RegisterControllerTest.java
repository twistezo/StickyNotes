package com.twistezo.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author twistezo (19.02.2017)
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RegisterController registerController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(registerController).isNotNull();
    }

    @Test
    @WithMockUser(roles="USER")
    public void checkPageStatus() throws Exception {
        this.mockMvc.perform(get("/register")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles="USER")
    public void checkPostMethod() throws Exception {

        this.mockMvc.perform(post("/register")
                .param("username", "user1")
                .param("password", "asd")
                .with(csrf()))
                .andExpect(status().isOk());
    }
}