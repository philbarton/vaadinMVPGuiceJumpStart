package ria.ordermanagement.search.controls.update;

import com.vaadin.ui.Button;
import ria.ordermanagement.events.OrderEvent;
import ria.ordermanagement.events.OrderEventType;
import ria.ordermanagement.search.controls.OrderSearchControlsView;

import static ria.ordermanagement.OrderApplication.getEventBus;

public class OrderSearchControlsUpdateView extends OrderSearchControlsView {
    @Override
    public void buildView() {
        Button createBtn = new Button("Create",
                new Button.ClickListener() {
                    public void buttonClick(Button.ClickEvent event) {
                        getEventBus().fireEvent(new OrderEvent(
                                OrderEventType.CREATE_BUTTON_PRESSED));
                    }
                });
        addComponent(createBtn);

        super.buildView();
    }
}
