package main.macros;

import main.fmwk.core.actions.Click;
import main.fmwk.core.actions.Enter;
import main.fmwk.core.actions.Performable;
import main.fmwk.core.actions.Tasks;

import static main.screens.core.LoginScreen.*;

public class LoginMacro {

    private LoginMacro() {
    }

    public static Performable login() {
        return Tasks.listOf(
            Enter.text("jdoe").on(USERNAME_TEXT_BOX),
            Enter.text("Changeme1").on(PASSWORD_TEXT_BOX),
            Click.on(LOGIN_BTN));
    }
}
