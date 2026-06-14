package LearnPlayWright.WithJava;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Googe {
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);
		
		Browser browser = playwright.chromium().launch(lp);
		BrowserContext bc_5 = browser.newContext();
		Page page = bc_5.newPage();
		page.navigate("https://www.google.com/");
		
		String text =page.locator("input[aria-label=\"Google Search\"]").last().getAttribute("data-ved");
		System.out.println(text);
		
		
	}

}
