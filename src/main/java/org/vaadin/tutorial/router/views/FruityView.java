package org.vaadin.tutorial.router.views;

import static org.vaadin.tutorial.router.views.FruityView.*;
import static org.vaadin.tutorial.router.views.FruityView.NAV_ALIAS_APPLE;
import static org.vaadin.tutorial.router.views.FruityView.NAV_ALIAS_FRUIT;
import static org.vaadin.tutorial.router.views.FruityView.NAV_ALIAS_FRUITS;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import org.vaadin.tutorial.router.layouts.InternalLayout;

@Route(value = NAV, layout = InternalLayout.class)
@RouteAlias(value = NAV_ALIAS_FRUIT, layout = InternalLayout.class)
@RouteAlias(value = NAV_ALIAS_FRUITS, layout = InternalLayout.class)
@RouteAlias(value = NAV_ALIAS_APPLE, layout = InternalLayout.class)
public class FruityView extends Div implements HasUrlParameter<String> {

  public static final String NAV = "fruity";
  public static final String NAV_ALIAS_FRUIT = "fruit";
  public static final String NAV_ALIAS_FRUITS = "fruits";
  public static final String NAV_ALIAS_APPLE = "apple";

  @Override
  public void setParameter(BeforeEvent event,
                          @OptionalParameter String parameter) {
    if (parameter != null) {
      add(new H4(parameter + " is a nice selection! Try again."));
    }
  }

  public FruityView() {
    add(new H3("Select your favorite fruit:").getText());

    RadioButtonGroup<String> group = new RadioButtonGroup<>();
    group.setItems("Apple" , "Banana" , "Watermelon");
    group.addValueChangeListener(evt -> {
      UI.getCurrent().navigate(NAV + "/" + evt.getValue());
    });
    add(group);
  }
}