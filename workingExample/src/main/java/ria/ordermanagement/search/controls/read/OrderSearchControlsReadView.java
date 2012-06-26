package ria.ordermanagement.search.controls.read;

import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import ria.ordermanagement.search.controls.OrderSearchControlsView;

public class OrderSearchControlsReadView extends OrderSearchControlsView {
    @Override
    protected Component getLabel() {
        return new Label("Controls Read View");
    }
}
