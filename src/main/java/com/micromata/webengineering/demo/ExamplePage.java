package com.micromata.webengineering.demo;

import org.apache.wicket.markup.html.WebPage;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class ExamplePage extends WebPage {
    private List<String> list;

    public ExamplePage() {
        // Add 10 random elements.
        list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(UUID.randomUUID().toString());
        }
    }
}
