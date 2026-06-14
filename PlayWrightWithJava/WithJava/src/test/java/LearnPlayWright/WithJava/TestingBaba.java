package LearnPlayWright.WithJava;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestingBaba {
	public static void main(String[] args) {

		Playwright playwright = Playwright.create();

		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);

		Browser browser = playwright.chromium().launch(lp);

		BrowserContext bc_1 = browser.newContext();

		Page page = bc_1.newPage();
		page.navigate("https://testingbaba.com/old/index.html");
		System.out.println(page.title());
		page.locator("'×'").click();
		page.locator("'Practice'").click();
		page.locator("//button[@data-target=\"#elements\"]").click();
		page.locator("'check box'").click();
		FrameLocator frame1 = page.frameLocator("//iframe[@src=\"Checkbox.html\"]");
		frame1.locator("//input[@id=\"myCheck\"]").click();
		
		


	}

}
