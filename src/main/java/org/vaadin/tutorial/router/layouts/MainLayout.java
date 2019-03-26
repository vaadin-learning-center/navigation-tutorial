package org.vaadin.tutorial.router.layouts;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.RouterLayout;

import org.vaadin.tutorial.router.views.LoginView;

public class MainLayout
  extends VerticalLayout implements RouterLayout, BeforeEnterObserver {

  @Override
  public void beforeEnter(BeforeEnterEvent event) {
    if(!event.getLocation().getPath().equals("login")
      && LoginView.username.equals("")) {
      event.forwardTo("login", event.getLocation().getPath());
    }
  }

  public MainLayout() {
    add(new Html("<h1>Vaadin Router Tutorial Inc.</h1>"));
  }
}