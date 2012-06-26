package ria.ordermanagement.search.controls.update;

import com.google.inject.Inject;
import ria.ordermanagement.search.controls.OrderSearchControlsPresenter;

public class OrderSearchControlsUpdatePresenter extends OrderSearchControlsPresenter {
    @Inject
    public OrderSearchControlsUpdatePresenter(final OrderSearchControlsUpdateView orderSearchControlsUpdateView) {
        this.orderSearchControlsView = orderSearchControlsUpdateView;
    }
}
