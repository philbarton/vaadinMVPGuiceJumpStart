package ria.ordermanagement.detail.edit;

import com.google.inject.Inject;
import ria.common.MvpDialoguePresenter;
import ria.ordermanagement.events.OrderEvent;
import ria.ordermanagement.events.OrderEventHandler;
import ria.ordermanagement.events.OrderEventType;

import static ria.ordermanagement.OrderApplication.*;

public class OrderEditPresenter implements MvpDialoguePresenter {
    private OrderEditView orderEditView;

    @Inject
    public OrderEditPresenter(OrderEditView orderEditView) {
        this.orderEditView = orderEditView;
        registerHandlers();
    }

    private void registerHandlers() {
        getEventBus().addHandler(OrderEvent.TYPE, new OrderEventHandler() {
            public void onEvent(OrderEvent event, OrderEventType eventType) {
                if (eventType.equals(OrderEventType.EDIT_ORDER_SELECTED)) {
                    orderEditView.buildView();
                    orderEditView.setModel(getApplicationData().getSelectedItem());
                    getRootWindow().addWindow(orderEditView);
                }
            }
        });
        getEventBus().addHandler(OrderEvent.TYPE, new OrderEventHandler() {
            public void onEvent(OrderEvent event, OrderEventType eventType) {
                if (eventType.equals(OrderEventType.CANCEL_EDIT_BUTTON_PRESSED)) {
                    orderEditView.discard();
                    getRootWindow().removeWindow(orderEditView);
                }
            }
        });
        getEventBus().addHandler(OrderEvent.TYPE, new OrderEventHandler() {
            public void onEvent(OrderEvent event, OrderEventType eventType) {
                if (eventType.equals(OrderEventType.SAVE_EDIT_BUTTON_PRESSED)) {
                    orderEditView.commit();
                    getRootWindow().removeWindow(orderEditView);
                }
            }
        });
    }
}
