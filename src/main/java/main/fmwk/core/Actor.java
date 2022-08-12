package main.fmwk.core;

import com.microsoft.playwright.Page;
import main.actors.Actors;
import main.actors.Patient;
import main.fmwk.core.actions.Performable;
import main.fmwk.core.actions.Waiting;
import main.fmwk.core.verifications.Verifiable;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public final class Actor extends BrowserManager {

    private Patient p;
    private boolean found;

    private Actor(String name) {
    }

    public static Actor withName(String name) {
        return new Actor(name);
    }

    public Actor uses(Page page) {
        setApp(page);
        return this;
    }

    public Actor and() {
        return this;
    }

    public void attemptsTo(Performable... tasks) {
        Arrays.stream(tasks).filter(Objects::nonNull).forEachOrdered(t -> t.performAs(this));
    }

    public void to(Performable tasks) {
        Optional.ofNullable(tasks).ifPresent(t -> t.performAs(this));
    }

    public boolean is(Waiting... waiter) {
        var yesNo = false;
        for (Waiting wait : waiter) {
            yesNo = wait.waitWithTimeOutAs(this);
        }
        return yesNo;
    }

    public void wantsTo(Verifiable verify) {
        verify.verifyAs(this);
    }

    public <T extends Actors<Patient>> Patient isVisiting(T t) {
        return t.build();
    }

}
