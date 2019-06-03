package org.vaadin.tutorial.router.layouts;

import static com.vaadin.flow.server.VaadinSession.getCurrent;
import static java.lang.Boolean.FALSE;
import static java.util.Optional.ofNullable;
import static org.vaadin.tutorial.router.views.LoginView.ATTRIBUTE_IS_AUTH;
import static org.vaadin.tutorial.router.views.LoginView.NAV;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.RouterLayout;

public class MainLayout
    extends VerticalLayout implements RouterLayout, BeforeEnterObserver {

  @Override
  public void beforeEnter(BeforeEnterEvent event) {
    String path = event.getLocation().getPath();

//    Boolean isAuthenticated = (getCurrent().getAttribute(Boolean.class) == null)
//                              ? FALSE
//                              : getCurrent().getAttribute(Boolean.class);

    Boolean isAuthenticated = ofNullable((Boolean)getCurrent().getAttribute(ATTRIBUTE_IS_AUTH))
                              .orElse(FALSE);

    //second access - login view
    if (! isAuthenticated &&
        ! path.equals(NAV)) {
      event.forwardTo(NAV , path);
    }
  }

  public MainLayout() {
    add(new H1("Vaadin Router Tutorial Inc."));
  }
}