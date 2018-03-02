package com.cts.userinfo.template;

import com.cts.userinfo.dao.UserInfoDAO;
import com.cts.userinfo.service.UserInfoService;
import com.cts.userinfo.vo.UserInfo;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by ganesanns on 04/08/17.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @InjectMocks
    UserInfoService customerService;

    @Mock
    UserInfoDAO customerDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCreateTheCustomer() throws Exception {
        UserInfo customer = new UserInfo("Sample", "somepassword");
        Mockito.when(customerDao.saveAndFlush(customer)).thenReturn(customer);
        UserInfo actual = customerService.createUserInfo(customer);
        assertEquals(customer.getUserId(), actual.getUserId());
    }

    @Test
    public void thatRespondListOfCustomers() {
        List<UserInfo> customerList = new ArrayList<>();
        customerList.add(new UserInfo("Test UserInfo", ""));
//        Mockito.when(customerDao.findAll()).thenReturn(customerList);

        List<UserInfo> actualCustomerList = customerService.readAllUsers();
        assertThat(actualCustomerList.size(), is(customerList.size()));
    }

}
