package NaveenAutomation;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;

public class Class2nd {
	public static void main(String[] args) {
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      BrowserContext context = browser.newContext();
	   // Start tracing before creating / navigating a page.
	      context.tracing().start(new Tracing.StartOptions()
	        .setScreenshots(true)
	        .setSnapshots(true)
	        .setSources(true));

	      Page page = context.newPage();
	      page.navigate("https://www.amazon.com/");
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sparkle Pick-A-Size Paper")).click();
	      page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("12 Double Rolls (Pack of 1)")).click();
	      page.locator("li:nth-child(4) > span > .p13n-sc-uncoverable-faceout > a").first().click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Dismiss")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Prime Video").setExact(true)).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Gift Cards")).click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open All Categories Menu")).click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Electronics")).click();
	      
	   // Stop tracing and export it into a zip archive.
		    context.tracing().stop(new Tracing.StopOptions()
		      .setPath(Paths.get("trace.zip")));
	    }
	 
	  }
}
