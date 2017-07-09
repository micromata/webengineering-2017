package com.micromata.webengineering.demo;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;

/**
 * Default homepage for Wicket.
 */
@WicketHomePage
public class HomePage extends BasePage {
    private String message = "Hello world (variable)";

    public HomePage() {
        PropertyModel<String> messageModel = new PropertyModel<>(this, "message");
        add(new Label("message", messageModel));


        Form<?> form = new Form("form");
        form.add(new TextField<>("msgInput", messageModel));
        add(form);

        add(new Link("link") {
            @Override
            public void onClick() {
                setResponsePage(ExamplePage.class);
            }
        });
    }
}
