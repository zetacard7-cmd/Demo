package NaveenAutomation;

import java.util.List;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AmazonVisibility {
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("msedge"));
		BrowserContext bc = browser.newContext();
		Page page = bc.newPage();
		
		page.navigate("https://www.amazon.in/");
		
		page.locator("#twotabsearchtextbox").fill("Mobile");
		String text = page.locator(".left-pane-results-container>div:nth-child(4)").textContent();
		System.out.println(text);
		
		List<String> allText = page.locator("//a[contains(text(),'Amazon')]").allTextContents();
		
		System.out.println(allText.size());
		
		for(int i = 0 ; i < allText.size() ; i++) {
			
			System.out.println(allText.get(i));
		}
	}
	

}
