package LearnPlayWright.WithJava;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JqueryDropplable {
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);
		
		
		Browser browser = playwright.chromium().launch(lp);
		BrowserContext bc_3 = browser.newContext();
		Page page = bc_3.newPage();
		page.navigate("https://jqueryui.com/droppable/");
		FrameLocator frame = page.frameLocator("//iframe[@class=\"demo-frame\"]");
		frame.locator("//div[@id=\"draggable\"]").dragTo(frame.locator("//div[@id=\"droppable\"]"));

		
	}
	
	

}
