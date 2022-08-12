package main.screens;

import main.screens.core.locatorstrategy.LocateBy;

public class PatientOverview {

    public static final String ALLOW_SAME_DAY_VISIT_BTN = LocateBy.cssText("button", "Create Visit");

    public static class NavTabs {
        public static final String CREATE_NEW_VISIT_BTN = LocateBy.id("newVirtualExamSetup-btn");
    }
}
