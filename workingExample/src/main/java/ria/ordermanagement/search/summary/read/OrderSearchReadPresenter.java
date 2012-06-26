package ria.ordermanagement.search.summary.read;

import com.google.inject.Inject;
import ria.ordermanagement.search.controls.read.OrderSearchControlsReadPresenter;
import ria.ordermanagement.search.results.read.OrderSearchResultsReadPresenter;
import ria.ordermanagement.search.summary.OrderSearchPresenter;
import ria.ordermanagement.search.summary.OrderSearchView;

public class OrderSearchReadPresenter extends OrderSearchPresenter {
    @Inject
    public OrderSearchReadPresenter(final OrderSearchView orderSearchView,
                                    final OrderSearchResultsReadPresenter orderSearchResultsReadPresenter,
                                    final OrderSearchControlsReadPresenter orderSearchControlsReadPresenter) {
        this.orderSearchView = orderSearchView;
        this.orderSearchResultsPresenter = orderSearchResultsReadPresenter;
        this.orderSearchControlsPresenter = orderSearchControlsReadPresenter;
    }
}
