package org.vaadin.tutorial.router.views;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import org.vaadin.tutorial.router.layouts.InternalLayout;

@Route(value = "fruity", layout = InternalLayout.class)
@RouteAlias(value = "fruit", layout = InternalLayout.class)
@RouteAlias(value = "fruits", layout = InternalLayout.class)
@RouteAlias(value = "apple", layout = InternalLayout.class)
public class FruityView extends Div implements HasUrlParameter<String> {

  @Override
  public void setParameter(BeforeEvent event
    , @OptionalParameter String parameter) {
    if(parameter!=null) {
      add(new Html("<h4><i>" + parameter + "</i> is a nice selection! Try again.</h4>"));
    }
  }

  public FruityView() {
    add(new Html("<h3>Select your favorite fruit:</h3>"));

    RadioButtonGroup<String> group = new RadioButtonGroup<>();    
    group.setItems("Apple", "Banana", "Watermelon");
    group.addValueChangeListener(evt -> {
      UI.getCurrent().navigate("fruity/" + evt.getValue());
    });
    add(group);
  }
}