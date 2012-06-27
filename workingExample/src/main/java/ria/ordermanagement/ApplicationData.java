package ria.ordermanagement;

import com.google.inject.Inject;
import com.vaadin.data.util.IndexedContainer;
import ria.service.OrderService;

public class ApplicationData {
    IndexedContainer container;

    @Inject
    public void setOrderService(OrderService orderService) {
        container = orderService.getOrderContainer();
    }

    public IndexedContainer getContainer() {
        return container;
    }
}
