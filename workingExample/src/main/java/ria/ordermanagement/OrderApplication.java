package ria.ordermanagement;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.HttpServletRequestListener;
import com.vaadin.ui.Window;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderApplication extends Application implements HttpServletRequestListener {
    private static ThreadLocal<EventBus> EVENT_BUS = new ThreadLocal<EventBus>();
    protected final EventBus eventBusInstance = new SimpleEventBus();
    private static ThreadLocal<Window> ROOT_WINDOW = new ThreadLocal<Window>();
    protected final Window windowInstance = new Window("DPS 2");
    protected Window mainWindow;
    protected Injector injector;

    @Override
    public void init() {
        mainWindow = getRootWindow();
        setEventBus(eventBusInstance);
        setRootWindow(windowInstance);
        injector = Guice.createInjector();
        OrderRootPresenter orderRootPresenter = injector.getInstance(OrderRootPresenter.class);
        mainWindow.addComponent(orderRootPresenter.getView());
        setMainWindow(mainWindow);
    }

    public void onRequestStart(HttpServletRequest request, HttpServletResponse response) {
        setEventBus(eventBusInstance);
        setRootWindow(windowInstance);
    }

    public void onRequestEnd(HttpServletRequest request, HttpServletResponse response) {
        EVENT_BUS.remove();
        ROOT_WINDOW.remove();
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
}
