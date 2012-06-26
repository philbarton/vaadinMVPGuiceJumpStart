package ria.ordermanagement;

import com.vaadin.ui.Component;
import ria.common.MvpPresenter;
import ria.ordermanagement.events.OrderEvent;
import ria.ordermanagement.events.OrderEventHandler;
import ria.ordermanagement.events.OrderEventType;
import ria.ordermanagement.search.summary.OrderSearchPresenter;

import static ria.ordermanagement.OrderApplication.getEventBus;

public class OrderRootPresenter implements MvpPresenter<OrderRootView> {
    protected OrderRootView orderRootView;
    protected OrderSearchPresenter orderSearchPresenter;

    public OrderRootPresenter(OrderRootView orderRootView, OrderSearchPresenter orderSearchPresenter) {
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
