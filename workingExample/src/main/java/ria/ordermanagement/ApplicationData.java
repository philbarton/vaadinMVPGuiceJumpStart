package ria.ordermanagement;

import com.google.inject.Inject;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import ria.service.OrderService;

public class ApplicationData {
    IndexedContainer container;
    Item selectedItem;

    @Inject
    public void setOrderService(OrderService orderService) {
        container = orderService.getOrderContainer();
    }

    public IndexedContainer getContainer() {
        return container;
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }
}
