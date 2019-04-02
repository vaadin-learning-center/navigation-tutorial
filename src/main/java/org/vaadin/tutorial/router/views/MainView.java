package org.vaadin.tutorial.router.views;

import static org.vaadin.tutorial.router.views.LoginView.ATTRIBUTE_USERNAME;
import static org.vaadin.tutorial.router.views.MainView.*;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.server.VaadinSession;

import org.vaadin.tutorial.router.layouts.InternalLayout;
import org.vaadin.tutorial.router.views.LoginView;

@Route(value = NAV, layout = InternalLayout.class)
public class MainView extends Div  {

  public static final String NAV = "";

  public MainView() {
    VaadinSession vaadinSession = VaadinSession.getCurrent();
    String username = (String) vaadinSession.getAttribute(ATTRIBUTE_USERNAME);

    add(new Html("<h4>Welcome <i>" + username + "</i>!</h4>"));
  }
}
