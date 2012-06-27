package ria.ordermanagement.search.results.update;

import com.google.inject.Inject;
import ria.ordermanagement.detail.edit.OrderEditPresenter;
import ria.ordermanagement.search.results.OrderSearchResultsPresenter;

public class OrderSearchResultsUpdatePresenter extends OrderSearchResultsPresenter {
    @Inject
    public OrderSearchResultsUpdatePresenter(final OrderSearchResultsUpdateView orderSearchResultsUpdateView,
                                             final OrderEditPresenter createdToRegisterHandlers) {
        this.orderSearchResultsView = orderSearchResultsUpdateView;
        registerHandlers();
    }
}
