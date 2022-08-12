package main.fmwk.core.actions;


import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.WaitForSelectorState;
import main.fmwk.core.Actor;

public class Waiting {

    private String locator;
    private final double timeOut;
    public static final double TEN = 10;
    public static final double FIVE = 5;

    private Waiting(double timeOut) {
        this.timeOut = timeOut;
    }

    public static Waiting seconds(double timeOut) {
        return new Waiting(timeOut * 1000);
    }

    public Waiting on(String locator) {
        this.locator = locator;
        return this;
    }

    public static Waiting waitingForSeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Waiting(seconds);
    }

    public boolean waitWithTimeOutAs(Actor actor) {
        try {
            actor.getDriver()
                .waitForSelector(locator, new Page.WaitForSelectorOptions()
                    .setState(WaitForSelectorState.VISIBLE)
                    .setState(WaitForSelectorState.ATTACHED)
                    .setTimeout(timeOut));
            return true;
        } catch (TimeoutError te) {
            System.out.println("Timed out waiting for " + locator);
            return false;
        }
    }

}
