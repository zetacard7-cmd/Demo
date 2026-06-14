package NaveenAutomation;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LoginPage {
	
		public static void main(String[] args) {
			
			Playwright playwright = Playwright.create();
			
			Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));
			
			BrowserContext bc = browser.newContext();
			
			Page page = bc.newPage();
			
			page.navigate("https://practice.expandtesting.com/login");
			page.locator("#username").fill("practice");
			page.fill("input[type*=sw]", "SuperSecretPassword!");
			page.locator("button[id=\"submit-login\"]").click();
		}

}
