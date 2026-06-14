package LearnPlayWright.WithJava;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ndtvNewsAndW3Schools {
	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);
		
		Browser browser = playwright.chromium().launch(lp);
		BrowserContext bc_2 = browser.newContext();
		Page page = bc_2.newPage();
		page.navigate("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		//page.pause();
		FrameLocator frame1 = page.frameLocator("//iframe[@id=\"iframeResult\"]");
		FrameLocator frame2 = frame1.frameLocator("//iframe[@title=\"Iframe Example\"]");
//		page.frame("//iframe[@src=\"demo_iframe.htm\"]");
//		page.locator("This page is displayed in an iframe").innerText();
//		System.out.println(page.locator("'This page is displayed in an iframe'").innerText());
		System.out.println(frame2.locator("h1").innerText());
		page.locator("//a[@id=\"getwebsitebtn\"]").click();
	}

}
