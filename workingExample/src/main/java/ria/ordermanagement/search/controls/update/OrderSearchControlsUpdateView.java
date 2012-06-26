package ria.ordermanagement.search.controls.update;

import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import ria.ordermanagement.search.controls.OrderSearchControlsView;

public class OrderSearchControlsUpdateView extends OrderSearchControlsView {
    @Override
    protected Component getLabel() {
        return new Label("Controls Update View");
    }
}
