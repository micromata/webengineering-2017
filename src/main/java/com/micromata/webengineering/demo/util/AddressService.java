package com.micromata.webengineering.demo.util;

import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.net.InetAddress;

/**
 * Helper functions to retrieve the server's hostname, ip and port for the running application.
 * <p>
 * See https://stackoverflow.com/questions/29929896/how-to-get-local-server-host-and-port-in-spring-boot as found by
 * a google search for "spring-boot get host and ip".
 */
@Service
@Configuration
public class AddressService implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {
    private int port;

    /**
     * Return the host address as an IP address.
     *
     * @return address
     */
    public String getHostAddress() {
        return InetAddress.getLoopbackAddress().getHostAddress();
    }


    /**
     * Return the host address as a DNS-resolvable name.
     *
     * @return address
     */
    public String getHostName() {
        return InetAddress.getLoopbackAddress().getHostName();
    }


    /**
     * This method is called when a particular event (noted in the interface) is executed. In our case, the event
     * was the start of the embedded application container as statet in the generic parameter.
     *
     * @param event the occurred event
     */
    @Override
    public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
        port = event.getEmbeddedServletContainer().getPort();
    }


    /**
     * Return the port of the application.
     *
     * @return port
     */
    public int getPort() {
        return port;
    }

    /**
     * Return server URL with http:// prefix.
     *
     * @return server URL.
     */
    public String getServerURL() {
        return "http://" + getHostName() + ":" + getPort();
    }
}
