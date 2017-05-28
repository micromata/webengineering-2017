package com.micromata.webengineering.demo.util;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTest {
    @Autowired
    private AddressService addressService;

    @Test
    public void testService() {
        assertEquals("foo", addressService.getServerURL());
    }
}
