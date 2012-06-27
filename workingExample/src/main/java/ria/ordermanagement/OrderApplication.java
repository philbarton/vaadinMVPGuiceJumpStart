package ria.ordermanagement;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.HttpServletRequestListener;
import com.vaadin.ui.Window;
import ria.ordermanagement.events.OrderEvent;
import ria.ordermanagement.events.OrderEventType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderApplication extends Application implements HttpServletRequestListener {
    private static ThreadLocal<EventBus> EVENT_BUS = new ThreadLocal<EventBus>();
    protected final EventBus eventBusInstance = new SimpleEventBus();
    private static ThreadLocal<Window> ROOT_WINDOW = new ThreadLocal<Window>();
    protected final Window windowInstance = new Window("DPS 2");
    private static ThreadLocal<ApplicationData> APPLICATION_DATA = new ThreadLocal<ApplicationData>();
    private ApplicationData applicationData;
    protected Window mainWindow;
    protected Injector injector;

    @Override
    public void init() {
        mainWindow = getRootWindow();
        setEventBus(eventBusInstance);
        setRootWindow(windowInstance);
        //injector = Guice.createInjector();
        injector = Guice.createInjector(new OrderModule());
        applicationData = injector.getInstance(ApplicationData.class);
        setApplicationData(applicationData);
        OrderRootPresenter orderRootPresenter = injector.getInstance(OrderRootPresenter.class);
        mainWindow.addComponent(orderRootPresenter.getView());
        setMainWindow(mainWindow);
        getEventBus().fireEvent(new OrderEvent(OrderEventType.INIT_ORDERS_SEARCH));
    }

    public void onRequestStart(HttpServletRequest request, HttpServletResponse response) {
        setEventBus(eventBusInstance);
        setRootWindow(windowInstance);
        setApplicationData(applicationData);
    }

    public void onRequestEnd(HttpServletRequest request, HttpServletResponse response) {
        EVENT_BUS.remove();
        ROOT_WINDOW.remove();
        APPLICATION_DATA.remove();
    }

    public static EventBus getEventBus() {
        return EVENT_BUS.get();
    }

    public static void setEventBus(EventBus eventBus) {
        if (getEventBus() == null) {
            EVENT_BUS.set(eventBus);
        }
    }

    public static Window getRootWindow() {
        return ROOT_WINDOW.get();
    }

    public static void setRootWindow(Window rootWindow) {
        if (getRootWindow() == null) {
            ROOT_WINDOW.set(rootWindow);
        }
    }

    public static ApplicationData getApplicationData() {
        return APPLICATION_DATA.get();
    }

    public static void setApplicationData(ApplicationData applicationData) {
        if (getApplicationData() == null) {
            APPLICATION_DATA.set(applicationData);
        }
    }
}
