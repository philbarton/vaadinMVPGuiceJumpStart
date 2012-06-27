package ria.ordermanagement.search.controls;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import ria.common.MvpView;
import ria.ordermanagement.events.OrderEvent;
import ria.ordermanagement.events.OrderEventType;

import static ria.ordermanagement.OrderApplication.getEventBus;

public abstract class OrderSearchControlsView extends HorizontalLayout implements MvpView {
    private Boolean needsBuilding = true;

    public void buildView() {
        if (needsBuilding) {
            needsBuilding = false;
            Button searchBtn = new Button("Search",
                    new Button.ClickListener() {
                        public void buttonClick(Button.ClickEvent event) {
                            getEventBus().fireEvent(new OrderEvent(OrderEventType.SEARCH_BUTTON_PRESSED));
                        }
                    });
            addComponent(searchBtn);
        }
    }
}
