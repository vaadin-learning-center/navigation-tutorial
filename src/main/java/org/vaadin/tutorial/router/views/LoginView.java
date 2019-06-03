package org.vaadin.tutorial.router.views;

import static com.vaadin.flow.server.VaadinSession.getCurrent;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.Optional.ofNullable;
import static org.vaadin.tutorial.router.views.LoginView.*;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

import org.vaadin.tutorial.router.layouts.MainLayout;

@Route(value = NAV, layout = MainLayout.class)
public class LoginView extends Composite<Div>
    implements HasUrlParameter<String> {

  public static final String NAV = "login";

  public static final String ATTRIBUTE_USERNAME = "username";
  public static final String ATTRIBUTE_IS_AUTH = "auth";

  private final LoginForm loginForm = new LoginForm();
  private String parameter = "";

  @Override
  public void setParameter(BeforeEvent event , String parameter) {
    this.parameter = parameter;
  }

  public LoginView() {
    loginForm.addLoginListener(event -> {
      VaadinSession vaadinSession = getCurrent();
      UI current = UI.getCurrent();

//      Boolean isAuthenticated = (vaadinSession.getAttribute(Boolean.class) == null)
//                                ? FALSE
//                                : vaadinSession.getAttribute(Boolean.class);
      Boolean isAuthenticated = ofNullable((Boolean)getCurrent().getAttribute(ATTRIBUTE_IS_AUTH))
          .orElse(FALSE);

      if (!isAuthenticated) {
        String username = event.getUsername();
        String password = event.getPassword();
        vaadinSession.setAttribute(ATTRIBUTE_USERNAME , username);
        vaadinSession.setAttribute(ATTRIBUTE_IS_AUTH , TRUE);
      }

      current.navigate(parameter);
    });
    getContent().add(loginForm);
  }
}
