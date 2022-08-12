package main.screens.core.locatorstrategy;

public interface LocateBy {

    static String id(String idString) {
        return String.format("id=%s", idString);
    }

    static String dataId(String dataIdentifier) {
        return String.format("[data-identifier='%s'", dataIdentifier);
    }

    static String text(String innerText) {
        return String.format("text=%s", innerText);
    }

    static String css(String css) {
        return String.format("css=%s", css);
    }

    static String dataIdentifier(String identifier) {
        return String.format("css=[data-identifier='%s']", identifier);
    }

    static String xpath(String xpath) {
        return xpath;
    }

    static String cssText(String css, String text) {
        return String.format("%s:has-text(\"%s\")", css, text);
    }

}
