package main.fmwk.core.actions;

import main.fmwk.core.Actor;

public class Enter implements Performable {

    String textToEnter;
    String locator;
    private Waiting[] waitConditions;

    private Enter(String textToEnter) {
        this.textToEnter = textToEnter;
    }

    public static Enter text(String a) {
        return new Enter(a);
    }

    public Performable after(Waiting... waitConditions) {
        this.waitConditions = waitConditions;
        return this;
    }

    public Performable on(String by) {
        this.locator = by;
        return this;
    }

    @Override public void performAs(Actor actor) {
        if (waitConditions == null || actor.is(waitConditions)) {
            actor.getDriver().fill(locator, textToEnter);
        } else {
            System.err.println("[Warning - Potential Failure] -- string was not entered because waiting conditions failed: " + locator);
        }
    }
}
