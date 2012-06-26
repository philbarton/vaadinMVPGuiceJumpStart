package ria.ordermanagement.search.results;

import com.google.inject.ImplementedBy;
import ria.common.MvpPresenter;
import ria.ordermanagement.search.results.read.OrderSearchResultsReadPresenter;

@ImplementedBy(OrderSearchResultsReadPresenter.class)
public abstract class OrderSearchResultsPresenter implements MvpPresenter<OrderSearchResultsView> {
    protected OrderSearchResultsView orderSearchResultsView;

    public OrderSearchResultsView getView() {
        orderSearchResultsView.buildView();
        return orderSearchResultsView;
    }
}
