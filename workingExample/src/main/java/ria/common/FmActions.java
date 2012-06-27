package ria.common;

import com.vaadin.event.Action;
import com.vaadin.terminal.ThemeResource;

public class FmActions {
    public static final Action EDIT_ACTION = new Action("Edit");
    public static final Action VIEW_ACTION = new Action("View",
            new ThemeResource("./img/iconLeaf_gif.gif"));
    public static final Action DELETE_ACTION = new Action("Delete",
            new ThemeResource("./img/x16.png"));
    public static final Action[] NO_ACTIONS = new Action[0];
    public static final Action[] UPDATE_AND_DELETE_ACTIONS = new Action[]{EDIT_ACTION, DELETE_ACTION};
    public static final Action[] VIEW_ACTIONS = new Action[]{VIEW_ACTION};
    public static final Action[] EDIT_ACTIONS = new Action[]{EDIT_ACTION};
    public static final Action[] DELETE_ACTIONS = new Action[]{DELETE_ACTION};
}
