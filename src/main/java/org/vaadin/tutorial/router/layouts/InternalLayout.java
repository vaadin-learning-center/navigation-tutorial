package org.vaadin.tutorial.router.layouts;

import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.RouterLink;

import org.vaadin.tutorial.router.views.MainView;
import org.vaadin.tutorial.router.views.FruityView;

public class InternalLayout extends MainLayout {

  private Tabs tabs = new Tabs();

  @Override
  public void beforeEnter(BeforeEnterEvent event) {
    super.beforeEnter(event);

    // Not the best hack
    if(!event.getLocation().getPath().equals("")) {
      tabs.setSelectedIndex(1);
    }
  }

  public InternalLayout() {
    tabs.add(
      new Tab(new RouterLink("Welcome", MainView.class))
      , new Tab(new RouterLink("Fruity", FruityView.class)));
    add(tabs);
  }
}