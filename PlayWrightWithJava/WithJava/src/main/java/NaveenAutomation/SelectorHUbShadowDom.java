package NaveenAutomation;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class SelectorHUbShadowDom {
	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));
		BrowserContext bc = browser.newContext();
		Page page = bc.newPage();
		page.setDefaultTimeout(60000);

		page.navigate("https://selectorshub.com/xpath-practice-page/");
		page.locator("#userName input[title=\"user name field\"]").fill("Rau Sharma");
		page.locator("div[qaid=\"country\"] #pizza").fill("Margareeta");
		page.locator("div[id=\"concepts\"] #training").fill("Landrover");
		page.locator("div[id=\"userPass\"] #pwd").fill("12346789");



	}
}
