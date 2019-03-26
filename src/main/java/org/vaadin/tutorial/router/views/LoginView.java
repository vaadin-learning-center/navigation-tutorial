package org.vaadin.tutorial.router.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

import org.vaadin.tutorial.router.layouts.MainLayout;

@Route(value = "login", layout = MainLayout.class)
public class LoginView extends LoginForm implements HasUrlParameter<String> {

  public static String username = "";
  private String parameter = "";

  @Override
  public void setParameter(BeforeEvent event, String parameter) {
    this.parameter = parameter;
  }

  public LoginView() {
    addLoginListener(evt -> {
      LoginView.username = evt.getUsername();
      UI.getCurrent().navigate(parameter);
    });
  }
}
