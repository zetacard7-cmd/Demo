package LearnPlayWright.WithJava;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class AutomationUsingCodeGen {
	  public static void main(String[] args) throws Exception {
		    try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      BrowserContext context = browser.newContext();
		      Page page = context.newPage();
		      page.navigate("https://testingbaba.com/old/index.html");
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("×")).click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Practice")).click();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("elements")).click();
		      page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("check box")).click();
		      page.locator("#tab_2 iframe").contentFrame().getByRole(AriaRole.CHECKBOX, new FrameLocator.GetByRoleOptions().setName("Mobile:")).check();
		      
		      Thread.sleep(50000);
		    }
	
	  }
}
