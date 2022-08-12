package main.tests.test01;

import main.actors.Patient;
import main.fmwk.core.Actor;
import main.fmwk.core.actions.EmaApp;
import main.fmwk.core.actions.Navigate;
import main.fmwk.core.verifications.Verify;
import main.macros.GoTo;
import main.screens.PatientChart;
import main.tests.CoreTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static main.actors.PatientBuilder.newPatient;
import static main.macros.CreateVisitMacro.createAcneCounselingVisit;
import static main.macros.LoginMacro.login;

public class TestClassOne extends CoreTest {

    static final Actor JANE_DOE = Actor.withName("Jane Doe");

    @BeforeClass
    public void openAppAndInit() {
        JANE_DOE.uses(browser).to(Navigate.to(EmaApp.class));
    }

    @Test
    public void testCaseOne() {
        JANE_DOE.attemptsTo(login());
        var p = JANE_DOE.isVisiting(newPatient(Patient::new)
            .withName("LeonMfKrV", "Abeamaddboo")
            .havingMrn("MRNBTZ5O0Drrf"));

        JANE_DOE.attemptsTo(GoTo.patientChart(p));
        JANE_DOE.wantsTo(Verify.locator(PatientChart.REVERSED_NAME).isVisible());
        JANE_DOE.attemptsTo(createAcneCounselingVisit());
    }

}
