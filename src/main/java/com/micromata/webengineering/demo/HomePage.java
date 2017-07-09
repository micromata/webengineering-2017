package com.micromata.webengineering.demo;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/**
 * Default homepage for Wicket.
 */
@WicketHomePage
public class HomePage extends WebPage {
    private String message = "Hello world (variable)";

    public HomePage() {
        add(new Label("message", message));
    }
}
