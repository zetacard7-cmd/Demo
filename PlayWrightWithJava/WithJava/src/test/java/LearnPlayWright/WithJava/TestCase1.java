package LearnPlayWright.WithJava;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestCase1 {
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);
		
		Browser browser = playwright.chromium().launch(lp);
		
		BrowserContext bc_1 = browser.newContext();
		
		Page page = bc_1.newPage();
		page.setDefaultTimeout(50000);
		page.navigate("https://www.myntra.com/");
		System.out.println(page.title());
		page.locator("'Beauty'").first().click();
		page.locator("'Kids'").click();
		page.locator("'Men'").last().click();
		
	}

}
