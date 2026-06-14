package LearnPlayWright.WithJava;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Yahoo {
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);
		
		Browser browser = playwright.chromium().launch(lp);
		BrowserContext bc = browser.newContext();
		Page page = bc.newPage();
		
		page.navigate("https://in.search.yahoo.com/");
		page.locator("#yschsp").fill("Mobile");
		
		Locator loc = page.locator(".sa-list-ctn>ul>li");
		loc.first().waitFor();
		
		List<String> li = loc.allTextContents();
		
		for(int i = 0 ; i < li.size() ; i++) {
			
			System.out.println(li.get(i));
		}
		
	}

}
