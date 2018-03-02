package com.cts.userinfo.template;

import com.cts.userinfo.UserInfoApplication;
import com.cts.userinfo.controller.UserInfoController;
import com.cts.userinfo.service.UserInfoService;

import com.cts.userinfo.vo.UserInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = UserInfoApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerControllerTest {

    public static final String CONTENT_TYPE = "Content-type";
    public static final ResultMatcher OK = status().isOk();
    public static final String SOME_NAME = "SOME_NAME";
    public static final ResultMatcher RESPONSE_FORMAT = content().contentType(MediaType.APPLICATION_JSON_UTF8);

    private MockMvc mockMVC;

    @Mock
    private UserInfoService userInfoService;

    @Autowired
    private WebApplicationContext wac;

    @InjectMocks
    private UserInfoController controller;
    private UserInfo customer = new UserInfo("1", "123");

    @Before
    public void setup() {
        this.mockMVC = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void shouldGetCustomers() throws Exception {
        mockMVC.perform(get("/")).andExpect(status().isOk())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAddCustomerPage() throws Exception {

        given(userInfoService.createUserInfo(Mockito.any(UserInfo.class))).willReturn(customer);
        String content = new Gson().toJson(customer);
        this.mockMVC.perform(post("/createUser")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(OK)
                .andReturn();


    }


}
