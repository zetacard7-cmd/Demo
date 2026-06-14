package LearnPlayWright.WithJava;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestingBabaDropDownMenu {
		public static void main(String[] args) {
			
			Playwright playwright = Playwright.create();
			LaunchOptions lp = new LaunchOptions();
			lp.setChannel("chrome");
			lp.setHeadless(false);
			
			Browser browser = playwright.chromium().launch(lp);
			BrowserContext bc = browser.newContext();
			Page page = bc.newPage();
			page.setDefaultTimeout(60000);
			page.navigate("https://testingbaba.com/old/");
			page.locator("'x'").click();
			page.locator("a[href=\"newdemo.html\"]").click();
			page.locator("button[data-target=\"#widget\"]").click();
			page.locator("a[href=\"#tab_24\"]").click();
			page.locator("").click();
// nav[id="navbar"]>ul>li+li+li+li
			
			
		}

}
