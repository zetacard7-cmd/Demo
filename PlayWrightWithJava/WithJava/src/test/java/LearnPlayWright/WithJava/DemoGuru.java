package LearnPlayWright.WithJava;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DemoGuru {
	public static void main(String[] args) throws Exception {
		
		Playwright playwright = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);
		
		Browser browser = playwright.chromium().launch(lp);
		BrowserContext bc_1 = browser.newContext();
		Page page = bc_1.newPage();
		
		page.navigate("https://demo.guru99.com/test/guru99home/");
		//page.locator("a[style=\"font-size: 14px;margin-left: 200px;\"]").click();
		//page.locator("li[class=\"dropdown\"]").first().click();
		//page.locator("//li[@class='dropdown']").first().click();
		Locator menu = page.locator("li.dropdown").first();

		System.out.println(menu.isVisible());
		System.out.println(menu.textContent());

		menu.click();
		
	}

}
