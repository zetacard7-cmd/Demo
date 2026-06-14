package LearnPlayWright.WithJava;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class QAPalygrround {
	public static void main(String[] args) {
		
		Playwright play = Playwright.create();
		Browser brow =play.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext bc = brow.newContext();
		Page page = bc.newPage();
		
		page.navigate("https://qaplayground.com/practice/data-table");
		Locator loc = page.locator("table[data-testid=\"books-table\"]>tbody tr");
		
		for(int i = 0 ; i < loc.count() ; i++) {
			
			System.out.println(loc.nth(i).textContent());
		}
		
		Locator l1 = page.locator("#books-table td:nth-child(5)");
		
		for(int j = 0 ; j < l1.count() ; j++) {
			
			System.out.println(l1.nth(j).textContent());
		}
		
	
	}

}
