package ria.ordermanagement.search.controls;

import com.google.inject.ImplementedBy;
import ria.common.MvpPresenter;
import ria.ordermanagement.search.controls.read.OrderSearchControlsReadPresenter;

@ImplementedBy(OrderSearchControlsReadPresenter.class)
public abstract class OrderSearchControlsPresenter implements MvpPresenter<OrderSearchControlsView> {
    protected OrderSearchControlsView orderSearchControlsView;

    public OrderSearchControlsView getView() {
        orderSearchControlsView.buildView();
        return orderSearchControlsView;
    }
}
