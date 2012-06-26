package ria.ordermanagement.search.results;

import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;
import ria.common.MvpView;


public abstract class OrderSearchResultsView extends VerticalLayout implements MvpView {
    private Boolean needsBuilding = true;

    public void buildView() {
        if (needsBuilding) {
            needsBuilding = false;
            addComponent(getLabel());
        }
    }

    protected abstract Component getLabel();
}
