package com.cts.userinfo.template

import com.cts.userinfo.UserInfoApplication
import com.cts.userinfo.controller.UserInfoController
import com.cts.userinfo.service.UserInfoService

import com.cts.userinfo.vo.UserInfo
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

import org.mockito.InjectMocks
import org.mockito.Mock

import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

import org.mockito.BDDMockito.given
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post


@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(classes = arrayOf(UserInfoApplication::class))
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class CustomerControllerTest {

    private var mockMVC: MockMvc? = null

    @Mock
    private val userInfoService: UserInfoService? = null

    @Autowired
    private val wac: WebApplicationContext? = null

    @InjectMocks
    private val controller: UserInfoController? = null
    private val customer = UserInfo("1", "123")

    @Before
    fun setup() {
        this.mockMVC = MockMvcBuilders.standaloneSetup(controller).build()
    }


    @Test
    @Throws(Exception::class)
    fun shouldGetCustomers() {
        mockMVC!!.perform(get("/")).andExpect(status().isOk)
                .andExpect(status().isOk)
    }

    @Test
    @Throws(Exception::class)
    fun shouldGetAddCustomerPage() {

        given(userInfoService!!.createUserInfo(Mockito.any(UserInfo::class.java))).willReturn(customer)
        val content = Gson().toJson(customer)
        this.mockMVC!!.perform(post("/createUser")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(OK)
                .andReturn()


    }

    companion object {

        val CONTENT_TYPE = "Content-type"
        val OK = status().isOk
        val SOME_NAME = "SOME_NAME"
        val RESPONSE_FORMAT = content().contentType(MediaType.APPLICATION_JSON_UTF8)
    }


}
