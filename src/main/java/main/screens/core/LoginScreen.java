package main.screens.core;

import main.screens.core.locatorstrategy.LocateBy;

public class LoginScreen {

    public static final String USERNAME_TEXT_BOX = LocateBy.id("username");
    public static final String PASSWORD_TEXT_BOX = LocateBy.id("password");
    public static final String LOGIN_BTN = LocateBy.css("[name='login']");
}
