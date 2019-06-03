package org.vaadin.tutorial.router.views;

import static org.vaadin.tutorial.router.views.WatermelonView.*;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.router.Route;

import org.vaadin.tutorial.router.layouts.InternalLayout;

@Route(value = NAV, layout = InternalLayout.class)
public class WatermelonView extends Div {

  public static final String NAV = FruityView.NAV + "/" + "Watermelon";

  public WatermelonView() {
    add(
      new Html(
        new H3("Nice choice! Watermelon is my favorite too!").getText()));
    add(new Html("<i>-- Yours, Web Robot.</i>"));
  }
}
