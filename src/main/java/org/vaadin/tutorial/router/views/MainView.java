package org.vaadin.tutorial.router.views;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import org.vaadin.tutorial.router.layouts.InternalLayout;
import org.vaadin.tutorial.router.views.LoginView;

@Route(value = "", layout = InternalLayout.class)
@PWA(name = "Router tutorial for Vaadin Flow", shortName = "Router Tutorial")
public class MainView extends Div  {

  public MainView() {
    add(new Html("<h4>Welcome <i>" + LoginView.username + "</i>!</h4>"));
  }
}
