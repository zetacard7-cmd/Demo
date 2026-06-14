package NaveenAutomation;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ClassOne {
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));
		BrowserContext bc = browser.newContext();
		Page page = bc.newPage();
		
		page.navigate("https://www.google.com/");
		System.out.println(page.title());
		page.locator("textarea[aria-label=\"Search\"]").fill("Vehicle");
		page.locator("input[aria-label=\"Google Search\"]").last().click();
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
		System.out.println(Paths.get("example.png").toAbsolutePath());
		browser.close();
		playwright.close();
	}

}
