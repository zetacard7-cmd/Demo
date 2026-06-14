package NaveenAutomation;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class ShadowDom {
	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));
		BrowserContext bc = browser.newContext();
		Page page = bc.newPage();
		page.setDefaultTimeout(60000);

		page.navigate("https://practice.expandtesting.com/shadowdom");
		String text = page.locator("div[id=\"shadow-host\"] #my-btn").textContent();
		System.out.println(text);
		
	}	
}
