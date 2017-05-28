package com.micromata.webengineering.demo.post.util;


import com.micromata.webengineering.demo.util.AddressService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Note that this is a CONSTRUCTED example since in this particular case we would simple change the definition
 * in application.properties.
 */
@Service
@Profile("test")
public class AddressServiceTestImpl implements AddressService {
    @Override
    public String getServerURL() {
        return "foo";
    }
}
