package ria.ordermanagement.search.summary.update;

import com.google.inject.Inject;
import ria.ordermanagement.search.controls.update.OrderSearchControlsUpdatePresenter;
import ria.ordermanagement.search.results.update.OrderSearchResultsUpdatePresenter;
import ria.ordermanagement.search.summary.OrderSearchPresenter;
import ria.ordermanagement.search.summary.OrderSearchView;

public class OrderSearchUpdatePresenter extends OrderSearchPresenter {
    @Inject
    public OrderSearchUpdatePresenter(final OrderSearchView orderSearchView,
                                      final OrderSearchResultsUpdatePresenter orderSearchResultsUpdatePresenter,
                                      final OrderSearchControlsUpdatePresenter orderSearchControlsUpdatePresenter) {
        this.orderSearchView = orderSearchView;
        this.orderSearchResultsPresenter = orderSearchResultsUpdatePresenter;
        this.orderSearchControlsPresenter = orderSearchControlsUpdatePresenter;
    }
}
