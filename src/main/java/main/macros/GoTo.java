package main.macros;

import main.actors.Patient;
import main.fmwk.core.actions.Click;
import main.fmwk.core.actions.Performable;
import main.fmwk.core.actions.Tasks;

import static main.screens.homescreen.HomeScreenCommon.PATIENT_NAV_TAB;

public class GoTo {

    public static Performable patientChart(Patient p) {
        return Tasks.listOf(
            Click.on(PATIENT_NAV_TAB),
            PatientSearchMacro.searchExistingPatient(p));
    }
}
