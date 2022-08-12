package main.fmwk.core.actions;

import main.fmwk.core.Actor;

public class Tasks implements Performable {

    private final Performable[] taskList;

    private Tasks(Performable... tasks) {
        this.taskList = tasks;
    }

    public static Performable listOf(Performable... tasks) {
        return new Tasks(tasks);
    }

    @Override public void performAs(Actor actor) {
        actor.attemptsTo(taskList);
    }
}
