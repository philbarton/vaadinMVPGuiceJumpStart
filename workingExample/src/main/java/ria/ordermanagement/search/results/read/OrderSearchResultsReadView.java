package ria.ordermanagement.search.results.read;

import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import ria.ordermanagement.search.results.OrderSearchResultsView;

public class OrderSearchResultsReadView extends OrderSearchResultsView {
    @Override
    protected Component getLabel() {
        return new Label("Results Read View");
    }
}
