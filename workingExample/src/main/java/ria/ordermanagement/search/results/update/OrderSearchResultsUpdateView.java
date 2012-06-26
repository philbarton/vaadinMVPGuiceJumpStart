package ria.ordermanagement.search.results.update;

import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import ria.ordermanagement.search.results.OrderSearchResultsView;

public class OrderSearchResultsUpdateView extends OrderSearchResultsView {
    @Override
    protected Component getLabel() {
        return new Label("Results Update View");
    }
}
