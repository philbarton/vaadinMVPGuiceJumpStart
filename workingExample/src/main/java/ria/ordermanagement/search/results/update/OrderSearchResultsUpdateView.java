package ria.ordermanagement.search.results.update;

import com.vaadin.data.Container;
import com.vaadin.event.Action;
import ria.common.FmActions;
import ria.ordermanagement.events.OrderEvent;
import ria.ordermanagement.events.OrderEventType;
import ria.ordermanagement.search.results.OrderSearchResultsView;

import static ria.ordermanagement.OrderApplication.getApplicationData;
import static ria.ordermanagement.OrderApplication.getEventBus;

public class OrderSearchResultsUpdateView extends OrderSearchResultsView implements Action.Handler {
    @Override
    public void buildView() {
        super.buildView();
        addActionHandler(this);
    }

    public Action[] getActions(Object o, Object o1) {
        return FmActions.EDIT_ACTIONS;
    }

    public void handleAction(Action action, Object sender, Object target) {
        if (action.equals(FmActions.EDIT_ACTION)) {
            Container container = getApplicationData().getContainer();
            getApplicationData().setSelectedItem(container.getItem(target));
            getEventBus().fireEvent(new OrderEvent(OrderEventType.EDIT_ORDER_SELECTED));
        }
    }
}
