package ria.ordermanagement;

import com.google.inject.AbstractModule;
import ria.ordermanagement.search.summary.OrderSearchPresenter;
import ria.ordermanagement.search.summary.update.OrderSearchUpdatePresenter;

public class OrderModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(OrderSearchPresenter.class).to(OrderSearchUpdatePresenter.class);
    }
}
