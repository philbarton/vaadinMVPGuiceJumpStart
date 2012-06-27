package ria.ordermanagement.search.results;

import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Table;
import ria.common.MvpView;
import ria.service.OrderService;

public abstract class OrderSearchResultsView extends Table implements MvpView {
    private Boolean needsBuilding = true;

    public void buildView() {
        if (needsBuilding) {
            needsBuilding = false;
            setPageLength(4);
            setWidth("100%");
        }
    }

    public void setModel(IndexedContainer container) {

        setContainerDataSource(container);

        // Set alignments
        setColumnAlignments(new String[]{Table.ALIGN_LEFT,
                Table.ALIGN_RIGHT, Table.ALIGN_RIGHT});

        // Set column widths
        setColumnExpandRatio(OrderService.ORDER_DESCRIPTION_PROPERTY_ID, 1);

    }

}
