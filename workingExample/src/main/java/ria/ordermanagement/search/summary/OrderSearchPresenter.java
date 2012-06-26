package ria.ordermanagement.search.summary;

import com.google.inject.ImplementedBy;
import ria.common.MvpPresenter;
import ria.ordermanagement.search.controls.OrderSearchControlsPresenter;
import ria.ordermanagement.search.results.OrderSearchResultsPresenter;
import ria.ordermanagement.search.summary.read.OrderSearchReadPresenter;

@ImplementedBy(OrderSearchReadPresenter.class)
public abstract class OrderSearchPresenter implements MvpPresenter<OrderSearchView> {
    protected OrderSearchResultsPresenter orderSearchResultsPresenter;
    protected OrderSearchControlsPresenter orderSearchControlsPresenter;
    protected OrderSearchView orderSearchView;

    public OrderSearchView getView() {
        orderSearchView.setOrderSearchResultsView(orderSearchResultsPresenter.getView());
        orderSearchView.setOrderSearchControlsView(orderSearchControlsPresenter.getView());
        orderSearchView.buildView();
        return orderSearchView;
    }
}
