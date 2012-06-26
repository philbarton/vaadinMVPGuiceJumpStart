package ria.ordermanagement;

import com.vaadin.ui.VerticalLayout;
import ria.ordermanagement.search.summary.OrderSearchView;

public class OrderRootView extends VerticalLayout {
    private OrderSearchView orderSearchView;

    public void setOrderSearchView(OrderSearchView orderSearchView) {
        this.orderSearchView = orderSearchView;
    }

    public void selectOrderSearchView() {
        removeAllComponents();
        addComponent(orderSearchView);
    }
}
