package LearnPlayWright.WithJava;

import java.util.Arrays;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FristCry {
		public static void main(String[] args) throws Exception {
			
			Playwright play = Playwright.create();
			Browser brow =play.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
			BrowserContext bc = brow.newContext(new Browser.NewContextOptions()
					  .setGeolocation(41.890221, 12.492348)
					  .setPermissions(Arrays.asList("geolocation")));
			Page page = bc.newPage(); 
			page.navigate("https://www.firstcry.com/");
			page.locator("#search_box").first().click();
			page.locator("#search_box").first().pressSequentially("Mobile");
			Locator loc = page.locator("div[aria-hidden=\"true\"] li");
			page.locator("span[class=\"edittext\"]").first().hover();
			
			for(int i = 0 ; i < loc.count() ; i++) {
				
				System.out.println(loc.nth(i).innerText().trim());
				String text = loc.nth(i).innerText().trim();
				Thread.sleep(2000);
//				if(text.equalsIgnoreCase("Cradle toy")) {
//					loc.nth(i).click();
//					break;
//				}
			}
			System.out.println(loc.count());
			
			
			
		}

}
