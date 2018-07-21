package com.cts.userinfo.template

import com.cts.userinfo.dao.UserInfoDAO
import com.cts.userinfo.service.UserInfoService
import com.cts.userinfo.vo.UserInfo
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.*


import org.junit.Test as test

/**
 * Created by ganesanns on 04/08/17.
 */


//@RunWith(SpringJUnit4ClassRunner::class)
//@SpringBootTest
class CustomerServiceTest {

    @InjectMocks
    internal var customerService: UserInfoService? = null

    @Mock
    internal var customerDao: UserInfoDAO? = null

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @test
    @Throws(Exception::class)
    fun shouldCreateTheCustomer() {
        val customer = UserInfo("Sample", "somepassword")
        Mockito.`when`(customerDao!!.saveAndFlush(customer)).thenReturn(customer)
        val actual = customerService!!.createUserInfo(customer)
        assertEquals(customer.userId, actual.userId)
    }

    @Test
    fun thatRespondListOfCustomers() {
        val customerList = ArrayList<UserInfo>()
        customerList.add(UserInfo("Test UserInfo", ""))
        //        Mockito.when(customerDao.findAll()).thenReturn(customerList);

        val actualCustomerList = customerService!!.readAllUsers()
        assertThat(actualCustomerList.size, `is`<Int>(customerList.size))
    }

    @Test
    fun unitTest1() {
        assertTrue(true)
    }

}
