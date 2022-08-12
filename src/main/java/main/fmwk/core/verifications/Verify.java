package main.fmwk.core.verifications;

import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.assertions.PageAssertions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import main.fmwk.core.Actor;

public class Verify implements Verifiable {

    private String locator;
    private String value;
    private String name;
    private VerificationStrategy strategy;

    private Verify(String locator) {
        this.locator = locator;
    }

    private Verify(){}

    public static Verify locator(String locator) {
        return new Verify(locator);
    }

    public static Verify page() {
        return new Verify();
    }

    public Verifiable hasId(String value) {
        strategy = VerificationStrategy.ID;
        this.value = value;
        return this;
    }

    public Verifiable hasClass(String value) {
        strategy = VerificationStrategy.CLASS;
        this.value = value;
        return this;
    }

    public Verifiable hasTitle(String value) {
        strategy = VerificationStrategy.PAGE_TITLE;
        this.value = value;
        return this;
    }

    public Verifiable containsText(String value) {
        strategy = VerificationStrategy.CONTAINS_TEXT;
        this.value = value;
        return this;
    }

    public Verifiable isVisible() {
        strategy = VerificationStrategy.LOCATOR_VISIBLE;
        return this;
    }

    public Verifiable hasCSS(String name, String value) {
        strategy = VerificationStrategy.CSS;
        this.value = value;
        this.name = name;
        return this;
    }

    @Override public void verifyAs(Actor actor) {
        switch (strategy) {
            case ID:
                PlaywrightAssertions.assertThat(actor.getDriver().locator(locator)).hasId(value, new LocatorAssertions.HasIdOptions().setTimeout(5000));
                break;
            case CLASS:
                PlaywrightAssertions.assertThat(actor.getDriver().locator(locator)).hasClass(value, new LocatorAssertions.HasClassOptions().setTimeout(5000));
                break;
            case CSS:
                PlaywrightAssertions.assertThat(actor.getDriver().locator(locator)).hasCSS(name, value, new LocatorAssertions.HasCSSOptions().setTimeout(5000));
                break;
            case PAGE_TITLE:
                PlaywrightAssertions.assertThat(actor.getDriver()).hasTitle(value, new PageAssertions.HasTitleOptions().setTimeout(5000));
                break;
            case LOCATOR_VISIBLE:
                PlaywrightAssertions.assertThat(actor.getDriver().locator(locator)).isEnabled(new LocatorAssertions.IsEnabledOptions().setTimeout(5000));
                System.out.println(locator + " was visible");
                break;
            case CONTAINS_TEXT:
                PlaywrightAssertions.assertThat(actor.getDriver().locator(locator)).containsText(value, new LocatorAssertions.ContainsTextOptions().setUseInnerText(true).setTimeout(5000));
                break;
            case MATCHES_TEXT:
                PlaywrightAssertions.assertThat(actor.getDriver().locator(locator)).hasText(value, new LocatorAssertions.HasTextOptions().setUseInnerText(true).setTimeout(5000));
                break;
        }
    }
}
