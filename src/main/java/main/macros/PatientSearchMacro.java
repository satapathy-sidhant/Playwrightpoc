package main.macros;

import main.actors.Patient;
import main.fmwk.core.actions.Click;
import main.fmwk.core.actions.Enter;
import main.fmwk.core.actions.Performable;
import main.fmwk.core.actions.Tasks;
import main.screens.PatientSearch;
import main.screens.core.locatorstrategy.LocateBy;

public class PatientSearchMacro {

    private PatientSearchMacro() {
    }

    public static Performable searchExistingPatient(Patient p) {
        return Tasks.listOf(Enter.text("MRN").on(PatientSearch.PATIENT_SEARCH_NG_SELECT),
            Click.on(getMatchingSearchByElement("MRN")),
            Enter.text(p.getMrn()).on(PatientSearch.PATIENT_SEARCH_TEXT_BOX),
            Click.on(PatientSearch.SEARCH_BUTTON),
            Click.on(getMatchingFirstSearchResultElement(p)));
    }

    private static String getMatchingSearchByElement(String searchStrategy) {
        return LocateBy.cssText(PatientSearch.SEARCH_BOX_OPTIONS, searchStrategy);
    }

    private static String getMatchingFirstSearchResultElement(Patient p) {
        return String.format(PatientSearch.FIRST_SEARCH_RESULT, p.getLastName());
    }
}
