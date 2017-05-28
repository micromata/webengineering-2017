package com.micromata.webengineering.demo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class AddressServiceImpl implements AddressService {
    @Value("${addressService.address}")
    private String serverAddress;

    @Override
    public String getServerURL() {
        return serverAddress;
    }
}
