package NaveenAutomation;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class TestingBabaLocators {
	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));
		BrowserContext bc = browser.newContext();
		Page page = bc.newPage();
		page.setDefaultTimeout(60000);

		page.navigate("https://testingbaba.com/old/");
		page.locator("button[class=\"close\"]").first().click();
		String text = page.locator("h2:has-text('Welcome To ')").textContent();
		System.out.println(text);
		page.locator("'Practice'").click();
		page.locator("button[data-toggle=\"collapse\"]").first().click();
		page.locator("'web tables'").click();
		page.frameLocator("iframe[src=\"Webtable.html\"]").locator("input[name=\"name\"]").last().fill("Raju Saju");
	
  }

}
