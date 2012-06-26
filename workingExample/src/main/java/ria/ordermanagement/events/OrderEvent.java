package ria.ordermanagement.events;

import com.google.gwt.event.shared.GwtEvent;

public class OrderEvent extends GwtEvent<OrderEventHandler> {
    public static Type<OrderEventHandler> TYPE = new Type<OrderEventHandler>();
    private OrderEventType eventType;

    public OrderEvent(OrderEventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "Cash Receipt Event";
    }

    @Override
    public GwtEvent.Type<OrderEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(OrderEventHandler orderEventHandler) {
        orderEventHandler.onEvent(this, eventType);
    }
}
