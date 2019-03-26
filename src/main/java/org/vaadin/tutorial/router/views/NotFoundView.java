package org.vaadin.tutorial.router.views;

import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.HasErrorParameter;
import com.vaadin.flow.router.NotFoundException;
import com.vaadin.flow.router.ParentLayout;

import org.vaadin.tutorial.router.layouts.MainLayout;

import javax.servlet.http.HttpServletResponse;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;

@ParentLayout(MainLayout.class)
public class NotFoundView extends Div
  implements HasErrorParameter<NotFoundException> {

  private Label error = new Label();

  public NotFoundView() {
    add(error);
  }

  @Override
  public int setErrorParameter(
    BeforeEnterEvent event,
    ErrorParameter<NotFoundException> parameter) {

    error.setText("Can not find URL: " + event.getLocation().getPath());
    return HttpServletResponse.SC_NOT_FOUND;
  }
}