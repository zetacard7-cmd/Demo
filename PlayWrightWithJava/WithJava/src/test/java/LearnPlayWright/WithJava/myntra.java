package LearnPlayWright.WithJava;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class myntra {
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome").setHeadless(false);
		
		Browser browser =playwright.chromium().launch(lp);
		BrowserContext bc_6 = browser.newContext();
		Page page = bc_6.newPage();
		page.navigate("https://www.myntra.com/");
		
		//page.locator("a[data-color=\"#ee5f73\"]").hover();
		String text2 = page.locator("//div[@class=\"desktop-navLink\"]/div[1]").first().innerText();
		String text = page.locator("//div[@class=\"desktop-navLink\"]/div[1]").first().textContent();
		
		System.out.println(text2);
		System.out.println("-----------------------------------");
		System.out.println(text);


	}

}
