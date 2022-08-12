package main.fmwk.core;

import com.microsoft.playwright.Page;

public abstract class BrowserManager {

    private Page app;

    protected void setApp(Page app) {
        this.app = app;
    }

    public Page getDriver() {
        return this.app;
    }
}
