package ria.ordermanagement.search.controls.read;

import com.google.inject.Inject;
import ria.ordermanagement.search.controls.OrderSearchControlsPresenter;

public class OrderSearchControlsReadPresenter extends OrderSearchControlsPresenter {
    @Inject
    public OrderSearchControlsReadPresenter(final OrderSearchControlsReadView orderSearchControlsReadView) {
        this.orderSearchControlsView = orderSearchControlsReadView;
    }
}
