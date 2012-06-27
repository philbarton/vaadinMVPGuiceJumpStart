package ria.ordermanagement.search.results.update;

import com.vaadin.data.Container;
import com.vaadin.event.Action;
import com.vaadin.event.ItemClickEvent;
import ria.common.FmActions;
import ria.ordermanagement.events.OrderEvent;
import ria.ordermanagement.events.OrderEventType;
import ria.ordermanagement.search.results.OrderSearchResultsView;

import static ria.ordermanagement.OrderApplication.getApplicationData;
import static ria.ordermanagement.OrderApplication.getEventBus;

public class OrderSearchResultsUpdateView extends OrderSearchResultsView implements Action.Handler, ItemClickEvent.ItemClickListener {
    @Override
    public void buildView() {
        super.buildView();
        addListener((ItemClickEvent.ItemClickListener) this);
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

    public void itemClick(ItemClickEvent event) {
        if (event.getButton() == ItemClickEvent.BUTTON_RIGHT) {
            setValue(event.getItemId());
        }
    }

}
