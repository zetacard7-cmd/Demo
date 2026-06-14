package LearnPlayWright.WithJava;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DYnamicDropDown {
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);
		
		Browser browser = playwright.chromium().launch(lp);
		BrowserContext bc = browser.newContext();
		Page page = bc.newPage();
		
		page.navigate("https://www.amazon.in/");
		page.locator("input[role=\"searchbox\"]").fill("Vivo X200t");
		//page.locator("#nav-search-submit-button").click();
		
		Locator loc = page.locator("//div[@class=\"left-pane-results-container\"]/div/div/div/span");
		loc.first().waitFor();
		
		List<String> list = loc.allInnerTexts();
		
		for(int i = 0 ; i < list.size() ; i++) {
			
			System.out.println(list.get(i));
		}
		
	}

}
