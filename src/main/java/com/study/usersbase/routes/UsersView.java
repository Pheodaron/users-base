package com.study.usersbase.routes;

import com.study.usersbase.entity.User;
import com.study.usersbase.repository.UserRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "users")
@PageTitle("All users")
public class UsersView extends VerticalLayout {
    Grid<User> grid = new Grid<>(User.class);
    TextField field = new TextField();
    UserRepository userRepository;

    public UsersView(UserRepository userRepository) {
        this.userRepository = userRepository;
        addClassName("users-view");
        setSizeFull();
        configureGrid();

        add(getToolbar(), grid);

        grid.setItems(userRepository.findAll());
    }

    private void configureGrid() {
        grid.addClassNames("user-grid");
        grid.setSizeFull();
        grid.setColumns("firstName", "lastName", "surname", "dateOfBirth", "phone", "email");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private HorizontalLayout getToolbar() {
        field.setPlaceholder("this will be users");
        field.setClearButtonVisible(true);

        Button addUsersButton = new Button("Add users");
        
        var toolbar = new HorizontalLayout(field, addUsersButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }
}
