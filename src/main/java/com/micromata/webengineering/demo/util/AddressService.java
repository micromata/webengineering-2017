package com.micromata.webengineering.demo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Helper functions to retrieve server URL for return correct entity resource paths.
 *
 * Since we possibly are behind load balancers and want to be as deployment agnostic as possible we simply configure
 * our host URL.
 */
@Service
public class AddressService {
    @Value("${addressService.address}")
    private String serverAddress;

    /**
     * Return server URL.
     *
     * @return server URL.
     */
    public String getServerURL() {
        return serverAddress;
    }
}
