package com.micromata.webengineering.demo;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class ExamplePage extends BasePage {
    private List<String> list;

    public ExamplePage() {
        // Add 10 random elements.
        list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(UUID.randomUUID().toString());
        }

        ListView<String> listview = new ListView<String>("list", list) {
            protected void populateItem(ListItem item) {
                item.add(new Label("element", item.getModel()));
            }
        };
        add(listview);
    }
}
