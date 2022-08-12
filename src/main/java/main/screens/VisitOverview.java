package main.screens;

import main.screens.core.locatorstrategy.LocateBy;

public class VisitOverview {
    private VisitOverview() {
    }

    public static final String VER_BTN = LocateBy.id("resumeExam-btn");
    public static final String FINALIZE_BTN = LocateBy.cssText("button", "Finalize Visit");
    public static final String FINALIZE_NOTE_BTN = LocateBy.id("_submitPrimary");
    public static final String FINALIZING_LINK = LocateBy.xpath("//a[contains(@data-identifier,'Finalizing')]");

    public static class Ver {
        public static final String BODY_MAP = LocateBy.id("map");
        public static final String PERFORM_EXAM_BTN = LocateBy.cssText("label", "Perform Exam");
        public static final String EXAM_FULL_SKIN = LocateBy.xpath("//ema-modal//button[normalize-space()='Exam - Full Skin']");
        public static final String PLAN_DONE_BTN = LocateBy.css("button[data-identifier='procedureButtonSave']");
        public static final String EXAM_DONE_BTN = LocateBy.css("button[data-identifier='done-with-exam-button']");
        public static final String IMPRESSIONS_BTN = LocateBy.xpath("//input[@name='selectedDiagnosis' and @data-diagnosisname='%s']//preceding-sibling::label");
        public static final String PLAN_BTN = LocateBy.xpath("//input[@name='selectedProcedure' and @data-label='%s']//preceding-sibling::label");
        public static final String SAVE_IMPRESSION_PLAN_BTN = LocateBy.id("saveDiagBtn");
        public static final String SAVE_VISIT_NOTE_BTN = LocateBy.id("save-btn");
    }
}
