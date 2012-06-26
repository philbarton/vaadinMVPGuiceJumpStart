package ria.ordermanagement.search.results.update;

import com.google.inject.Inject;
import ria.ordermanagement.search.results.OrderSearchResultsPresenter;

public class OrderSearchResultsUpdatePresenter extends OrderSearchResultsPresenter {
    @Inject
    public OrderSearchResultsUpdatePresenter(final OrderSearchResultsUpdateView orderSearchResultsUpdateView) {
        this.orderSearchResultsView = orderSearchResultsUpdateView;
    }
}
