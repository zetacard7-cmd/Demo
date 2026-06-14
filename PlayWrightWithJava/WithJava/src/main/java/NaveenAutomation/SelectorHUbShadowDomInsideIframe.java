package NaveenAutomation;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SelectorHUbShadowDomInsideIframe {
	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));
		BrowserContext bc = browser.newContext();
		Page page = bc.newPage();
		page.setDefaultTimeout(60000);

		page.navigate("https://selectorshub.com/shadow-dom-in-iframe/");
		Locator teaBox = page.frameLocator("iframe#pact").locator("div#snacktime #tea");
		teaBox.fill("yes");
	}
}
