package ria.ordermanagement;

import com.google.inject.Inject;
import ria.common.MvpPresenter;
import ria.ordermanagement.search.summary.OrderSearchPresenter;

public class OrderRootPresenter implements MvpPresenter<OrderRootView> {
    protected OrderRootView orderRootView;
    protected OrderSearchPresenter orderSearchPresenter;

    @Inject
    public OrderRootPresenter(final OrderRootView orderRootView,
                              final OrderSearchPresenter orderSearchPresenter) {
        this.orderRootView = orderRootView;
        this.orderSearchPresenter = orderSearchPresenter;
    }

    public OrderRootView getView() {
        orderRootView.setOrderSearchView(orderSearchPresenter.getView());
        orderRootView.selectOrderSearchView();
        return orderRootView;
    }
}
