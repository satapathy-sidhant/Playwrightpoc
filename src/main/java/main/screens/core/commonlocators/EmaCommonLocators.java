package main.screens.core.commonlocators;

import main.screens.core.locatorstrategy.LocateBy;

public class EmaCommonLocators {

    private EmaCommonLocators() {
    }

    public static final String PLEASE_WAIT_MODAL = LocateBy.cssText("h3", "Please Wait...");

    public static class FilterLocators {
        public static final String FILTERS_BTN = LocateBy.text("Filters");
        public static final String APPLY_FILTER_BTN = LocateBy.cssText("button", "Apply Filter");
        public static final String PATIENT_UI_SELECT = LocateBy.css("patient-select input.ui-select-search");
        public static final String PATIENT_UI_SELECT_OPTION = LocateBy.cssText("span", "%s");
        public static final String DATE_FROM = LocateBy.css("input[id='date.from']");
    }

}
