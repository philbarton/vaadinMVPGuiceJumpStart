package ria.ordermanagement.events;

import com.google.gwt.event.shared.EventHandler;

public interface OrderEventHandler extends EventHandler {
    public void onEvent(OrderEvent event, OrderEventType eventType);
}
