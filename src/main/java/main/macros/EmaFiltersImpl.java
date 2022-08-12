package main.macros;

import com.microsoft.playwright.Page;
import main.screens.core.commonlocators.EmaCommonLocators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmaFiltersImpl {

    Page ema;

    public EmaFiltersImpl(Page ema) {
        this.ema = ema;
    }

    public void selectExactPatientFromOptions(String patientReversedNameWithComma) {
        var exactOption = String.format(EmaCommonLocators.FilterLocators.PATIENT_UI_SELECT_OPTION, patientReversedNameWithComma);
        ema.click(exactOption);
    }

    public void filterForToday() {
        ema.fill(EmaCommonLocators.FilterLocators.DATE_FROM, LocalDate.now().format(DateTimeFormatter.ofPattern("MMddyyyy")));
    }

    public void applyFilter() {
        ema.click(EmaCommonLocators.FilterLocators.APPLY_FILTER_BTN);
    }
}
