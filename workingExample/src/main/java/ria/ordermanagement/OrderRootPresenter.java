package ria.ordermanagement;

import com.google.inject.Inject;
import ria.common.MvpPresenter;
import ria.ordermanagement.events.OrderEvent;
import ria.ordermanagement.events.OrderEventHandler;
import ria.ordermanagement.events.OrderEventType;
import ria.ordermanagement.search.summary.OrderSearchPresenter;

import static ria.ordermanagement.OrderApplication.getEventBus;

public class OrderRootPresenter implements MvpPresenter<OrderRootView> {
    protected OrderRootView orderRootView;
    protected OrderSearchPresenter orderSearchPresenter;

    @Inject
    public OrderRootPresenter(final OrderRootView orderRootView,
                              final OrderSearchPresenter orderSearchPresenter) {
        this.orderRootView = orderRootView;
        this.orderSearchPresenter = orderSearchPresenter;
        registerHandlers();
    }

    private void registerHandlers() {
        getEventBus().addHandler(OrderEvent.TYPE, new OrderEventHandler() {
            public void onEvent(OrderEvent event, OrderEventType eventType) {
                if (eventType.equals(OrderEventType.INIT_ORDERS_SEARCH)) {
                    orderRootView.setOrderSearchView(orderSearchPresenter.getView());
                    orderRootView.selectOrderSearchView();
                }
            }
        });
    }

    public OrderRootView getView() {
        return orderRootView;
    }
}
