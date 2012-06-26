package ria.ordermanagement.search.summary;

import com.vaadin.ui.VerticalLayout;
import ria.common.MvpView;
import ria.ordermanagement.search.controls.OrderSearchControlsView;
import ria.ordermanagement.search.results.OrderSearchResultsView;

public class OrderSearchView extends VerticalLayout implements MvpView {
    protected boolean needsBuilding = true;
    protected OrderSearchResultsView orderSearchResultsView;
    protected OrderSearchControlsView orderSearchControlsView;

    public void buildView() {
        if (needsBuilding) {
            needsBuilding = false;
            addComponent(orderSearchResultsView);
            addComponent(orderSearchControlsView);
        }
    }

    public void setOrderSearchResultsView(OrderSearchResultsView orderSearchResultsView) {
        this.orderSearchResultsView = orderSearchResultsView;
    }

    public void setOrderSearchControlsView(OrderSearchControlsView orderSearchControlsView) {
        this.orderSearchControlsView = orderSearchControlsView;
    }
}
