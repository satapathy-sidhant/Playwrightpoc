package main.fmwk.core.actions;

import main.fmwk.core.Actor;

public class Navigate implements Performable {

    private final String url;

    private Navigate(String url) {
        this.url = url;
    }

    public static Performable to(Class<EmaApp> clazz) {
        try {
            return new Navigate((String) clazz.getDeclaredField("appUrl").get(null));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override public void performAs(Actor actor) {
        actor.getDriver().navigate(url);
    }
}
