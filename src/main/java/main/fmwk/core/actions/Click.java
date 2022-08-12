package main.fmwk.core.actions;

import main.fmwk.core.Actor;

public class Click implements Performable {

    private final String locator;
    private Waiting[] waitConditions;
    private int count = 1;

    private Click(String locator) {
        this.locator = locator;
    }

    public static Click on(String locator) {
        return new Click(locator);
    }

    public Performable after(Waiting... waitConditions) {
        this.waitConditions = waitConditions;
        return this;
    }

    public Click looping(int count) {
        this.count = count;
        return this;
    }

    @Override public void performAs(Actor actor) {
        if (waitConditions == null || actor.is(waitConditions)) {
            if (count >= 2) {
                for (int i = 0; i < count; i++) {
                    if (actor.getDriver().locator(locator).count() == 1) {
                        actor.getDriver().click(locator);
                    } else break;
                }
            } else {
                System.out.println("clicking locator :" + locator);
                actor.getDriver().click(locator);
            }
        } else {
            System.err.println("[Warning - Potential Failure] -- locator was not clicked because waiting conditions failed: " + locator);
        }
    }
}
