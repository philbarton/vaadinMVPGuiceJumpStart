package ria.ordermanagement.search.controls;

import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;
import ria.common.MvpView;

public abstract class OrderSearchControlsView extends VerticalLayout implements MvpView {
    private Boolean needsBuilding = true;

    public void buildView() {
        if (needsBuilding) {
            needsBuilding = false;
            addComponent(getLabel());
        }
    }

    protected abstract Component getLabel();
}
