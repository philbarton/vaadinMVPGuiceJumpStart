package ria.ordermanagement.search.results;

import com.google.inject.ImplementedBy;
import ria.common.MvpPresenter;
import ria.ordermanagement.events.OrderEvent;
import ria.ordermanagement.events.OrderEventHandler;
import ria.ordermanagement.events.OrderEventType;
import ria.ordermanagement.search.results.read.OrderSearchResultsReadPresenter;

import static ria.ordermanagement.OrderApplication.getApplicationData;
import static ria.ordermanagement.OrderApplication.getEventBus;

@ImplementedBy(OrderSearchResultsReadPresenter.class)
public abstract class OrderSearchResultsPresenter implements MvpPresenter<OrderSearchResultsView> {
    protected OrderSearchResultsView orderSearchResultsView;

    public OrderSearchResultsView getView() {
        orderSearchResultsView.buildView();
        return orderSearchResultsView;
    }

    protected void registerHandlers() {
        getEventBus().addHandler(OrderEvent.TYPE, new OrderEventHandler() {
            public void onEvent(OrderEvent event, OrderEventType eventType) {
                if (eventType.equals(OrderEventType.INIT_ORDERS_SEARCH)) {
                    orderSearchResultsView.setModel(getApplicationData().getContainer());
                }
            }
        });
    }
}
