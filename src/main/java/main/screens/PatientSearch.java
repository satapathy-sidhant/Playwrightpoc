package main.screens;

import main.screens.core.locatorstrategy.LocateBy;

public class PatientSearch {

    private PatientSearch() {
    }

    public static final String PATIENT_SEARCH_NG_SELECT = LocateBy.css("[data-identifier='filterBy'] input");
    public static final String SEARCH_BOX_OPTIONS = LocateBy.css("ema-patients-filter ng-dropdown-panel[role='listbox'] div[role='option'] span");
    public static final String PATIENT_SEARCH_TEXT_BOX = LocateBy.css("input[data-identifier='filterValue']");
    public static final String SEARCH_BUTTON = LocateBy.css("button[data-identifier='save']");
    public static final String FIRST_SEARCH_RESULT = LocateBy.xpath("//td[@data-identifier='lastName']//a[.='%s']");

}
