/*
 * Copyright 2000-2016 Vaadin Ltd.
 *
 * Modifications Copyright 2017 appreciated
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.uitest;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class GridView extends VerticalLayout implements View {

    List<Person> people = new ArrayList<>();

    public GridView() {
        Random random = new Random();

        for (int i = 0; i < 300; i++) {
            people.add(new Person(UUID.randomUUID().toString(), random.nextInt(), i));
        }

        setMargin(true);
        setSpacing(true);

        Label h1 = new Label("Tables");
        h1.addStyleName(ValoTheme.LABEL_H1);
        addComponent(h1);

        HorizontalLayout wrap = new HorizontalLayout();
        wrap.addStyleName(ValoTheme.LAYOUT_HORIZONTAL_WRAPPING);
        wrap.setSpacing(true);
        addComponent(wrap);

        com.vaadin.ui.Grid<Person> grid = getGrid();
        addComponent(grid);

        grid = getGrid();
        grid.setFrozenColumnCount(1);
        grid.setSelectionMode(com.vaadin.ui.Grid.SelectionMode.MULTI);
        grid.getEditor().setEnabled(true);
        addComponent(grid);

        grid = getGrid();
        grid.setCaption("Single");
        grid.setSelectionMode(com.vaadin.ui.Grid.SelectionMode.SINGLE);
        grid.getEditor().setEnabled(true);
        addComponent(grid);

        grid = getGrid();
        grid.setCaption("None");
        grid.setSelectionMode(com.vaadin.ui.Grid.SelectionMode.NONE);
        grid.getEditor().setEnabled(true);
        addComponent(grid);

        grid = getGrid();
        grid.setCaption("Multi");
        grid.setSelectionMode(com.vaadin.ui.Grid.SelectionMode.MULTI);
        grid.getEditor().setEnabled(true);
        addComponent(grid);

        grid = getGrid(3);
        grid.setCaption("Multi 2");
        grid.setSelectionMode(com.vaadin.ui.Grid.SelectionMode.MULTI);
        grid.getEditor().setEnabled(true);
        addComponent(grid);
    }


    private com.vaadin.ui.Grid<Person> getGrid() {
        return getGrid(people.size());
    }

    private com.vaadin.ui.Grid<Person> getGrid(int size) {
        com.vaadin.ui.Grid<Person> grid = new com.vaadin.ui.Grid<>();
        grid.setItems(people.subList(0, size));
        grid.addColumn(Person::getName).setCaption("Name 1");
        grid.addColumn(Person::getName).setCaption("Name 2");
        grid.addColumn(Person::getName).setCaption("Name 3");
        grid.addColumn(Person::getName).setCaption("Name 4");
        grid.addColumn(Person::getBirthYear).setCaption("Year of birth 1");
        grid.addColumn(Person::getBirthYear).setCaption("Year of birth 2");
        grid.addColumn(Person::getBirthYear).setCaption("Year of birth 3");
        grid.addColumn(Person::getBirthYear).setCaption("Year of birth 4");
        grid.addColumn(Person::getBirthYear).setCaption("Year of birth 5");
        grid.addColumn(Person::getBirthYear).setCaption("Year of birth 6");
        grid.addColumn(Person::getID).setCaption("ID");
        grid.addColumn(Person::getName).setCaption("Name 5");
        return grid;
    }


    @Override
    public void enter(ViewChangeEvent event) {
    }

    class Person {
        private final String name;
        private final int id;
        private final int year;

        public Person(String name, int year, int id) {
            this.name = name;
            this.year = year;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public int getBirthYear() {
            return year;
        }

        public int getID() {
            return id;
        }
    }

}
