package ria.ordermanagement.search.results.read;

import com.google.inject.Inject;
import ria.ordermanagement.search.results.OrderSearchResultsPresenter;

public class OrderSearchResultsReadPresenter extends OrderSearchResultsPresenter {
    @Inject
    public OrderSearchResultsReadPresenter(final OrderSearchResultsReadView orderSearchResultsReadView) {
        this.orderSearchResultsView = orderSearchResultsReadView;
    }
}
