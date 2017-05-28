package com.micromata.webengineering.demo.util;

/**
 * Helper functions to retrieve server URL for return correct entity resource paths.
 *
 * Since we possibly are behind load balancers and want to be as deployment agnostic as possible we simply configure
 * our host URL.
 */
public interface AddressService {
    /**
     * Return server URL.
     *
     * @return server URL.
     */
    String getServerURL();
}
