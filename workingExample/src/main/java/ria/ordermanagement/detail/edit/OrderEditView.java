package ria.ordermanagement.detail.edit;

import com.google.inject.Inject;
import com.vaadin.data.Item;
import com.vaadin.ui.Button;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Window;
import ria.common.MvpView;
import ria.ordermanagement.detail.OrderFormFieldFactory;
import ria.ordermanagement.events.OrderEvent;
import ria.ordermanagement.events.OrderEventType;
import ria.service.OrderService;

import java.util.ArrayList;
import java.util.List;

import static ria.ordermanagement.OrderApplication.getEventBus;

public class OrderEditView extends Window implements MvpView {
    private boolean needsBuilding = true;
    private Form leftForm;
    private Form rightForm;
    private OrderFormFieldFactory formFieldFactory;

    public void buildView() {
        if (needsBuilding) {
            needsBuilding = false;
            setWidth("600px");
            setPositionX(40);
            setPositionY(40);
            HorizontalLayout formLayout = new HorizontalLayout();
            leftForm = createForm();
            rightForm = createForm();
            formLayout.addComponent(leftForm);
            formLayout.addComponent(rightForm);
            addComponent(formLayout);
            HorizontalLayout controlsLayout = new HorizontalLayout();
            Button cancelBtn = new Button("Cancel",
                    new Button.ClickListener() {
                        public void buttonClick(Button.ClickEvent event) {
                            getEventBus().fireEvent(new OrderEvent(OrderEventType.CANCEL_EDIT_BUTTON_PRESSED));
                        }
                    });
            controlsLayout.addComponent(cancelBtn);

            Button saveBtn = new Button("Save",
                    new Button.ClickListener() {
                        public void buttonClick(Button.ClickEvent event) {
                            getEventBus().fireEvent(new OrderEvent(OrderEventType.SAVE_EDIT_BUTTON_PRESSED));
                        }
                    });
            controlsLayout.addComponent(saveBtn);

            addComponent(controlsLayout);
        }
    }

    protected List<Object> getLeftFormOrder() {
        List<Object> order = new ArrayList<Object>();
        order.add(OrderService.ORDER_DESCRIPTION_PROPERTY_ID);
        return order;
    }

    protected List<Object> getRightFormOrder() {
        List<Object> order = new ArrayList<Object>();
        order.add(OrderService.ORDER_QUANTITY_PROPERTY_ID);
        order.add(OrderService.ORDER_UNITPRICE_PROPERTY_ID);
        return order;
    }

    public void setModel(Item item) {
        leftForm.setItemDataSource(item, getLeftFormOrder());
        rightForm.setItemDataSource(item, getRightFormOrder());
    }

    private Form createForm() {
        Form form = new Form();
        form.getLayout().setMargin(true, false, true, true);
        form.setWriteThrough(false);
        form.setFormFieldFactory(formFieldFactory);
        form.setValidationVisible(false);
        return form;
    }

    public void commit() {
        leftForm.commit();
        rightForm.commit();
    }

    public void discard() {
        leftForm.discard();
        rightForm.discard();
    }

    @Inject
    public void setFormFieldFactory(OrderFormFieldFactory formFieldFactory) {
        this.formFieldFactory = formFieldFactory;
    }
}
