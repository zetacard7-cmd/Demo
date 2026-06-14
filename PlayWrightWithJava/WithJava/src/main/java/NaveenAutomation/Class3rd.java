package NaveenAutomation;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Class3rd {
		public static void main(String[] args) {
			
			Playwright playwright = Playwright.create();
			Browser browser =playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));
			BrowserContext bc = browser.newContext();
			Page page = bc.newPage();
			
			page.navigate("https://www.amazon.in/");
			page.locator("input[aria-label=\"Search Amazon.in\"]").fill("Mobile Phones");
			
			Locator loc = page.locator(".left-pane-results-container>div");
			page.locator(".left-pane-results-container>div:nth-child(3)").hover();
			//loc.first().waitFor();
			
			for(int i = 0 ; i < loc.count() ; i++) {
				
				System.out.println(loc.nth(i).textContent());
				String text = loc.nth(i).textContent();
				
				if(text.equalsIgnoreCase("mobile phones under 10000 5g")) {
					
					loc.nth(i).click();
				}
				
			}

		}

}
