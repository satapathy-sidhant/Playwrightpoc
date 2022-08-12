package main.macros;

import main.fmwk.core.actions.Click;
import main.fmwk.core.actions.Performable;
import main.fmwk.core.actions.Tasks;
import main.fmwk.core.actions.Waiting;
import main.screens.PatientOverview;
import main.screens.VisitOverview;
import main.screens.core.locatorstrategy.LocateBy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static main.fmwk.core.actions.Waiting.TEN;
import static main.screens.core.commonlocators.EmaCommonLocators.PLEASE_WAIT_MODAL;

public class CreateVisitMacro {

    private CreateVisitMacro() {
    }

    public static Performable createAcneCounselingVisit() {
        return Tasks.listOf(
            Click.on(PatientOverview.NavTabs.CREATE_NEW_VISIT_BTN),
            Click.on(PatientOverview.ALLOW_SAME_DAY_VISIT_BTN)
                .after(Waiting.seconds(TEN).on(PatientOverview.ALLOW_SAME_DAY_VISIT_BTN)),
            Click.on(VisitOverview.VER_BTN)
                .after(
                    Waiting.seconds(TEN).on(PLEASE_WAIT_MODAL),
                    Waiting.seconds(TEN).on(LocateBy.cssText("span", LocalDate.now().format(DateTimeFormatter.ofPattern("'Visit on 'MMMM d',' yyyy"))))),
            Click.on(VisitOverview.Ver.PERFORM_EXAM_BTN),
            Click.on(VisitOverview.Ver.EXAM_FULL_SKIN),
            Click.on(VisitOverview.Ver.EXAM_DONE_BTN),
            Click.on(getImpressionXpathFor("Acne")),
            Click.on(getPlanXpathFor("Counseling - Acne")),
            Click.on(VisitOverview.Ver.PLAN_DONE_BTN),
            Click.on(VisitOverview.Ver.SAVE_IMPRESSION_PLAN_BTN),
            Click.on(VisitOverview.Ver.SAVE_VISIT_NOTE_BTN),
            Click.on(VisitOverview.FINALIZE_BTN)
                .after(Waiting.seconds(TEN).on(VisitOverview.FINALIZE_BTN)),
            Click.on(VisitOverview.FINALIZE_NOTE_BTN));
    }

    private static String getImpressionXpathFor(String impression) {
        // Click.on(VisitOverview.FINALIZING_LINK).looping(5).after(waitingForSeconds(5))
        return String.format(VisitOverview.Ver.IMPRESSIONS_BTN, impression);
    }

    private static String getPlanXpathFor(String plan) {
        return String.format(VisitOverview.Ver.PLAN_BTN, plan);
    }

}
