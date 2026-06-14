package LearnPlayWright.WithJava;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestingBabaHandlingAlert {
	public static void main(String[] args) {

		Playwright playwright = Playwright.create();

		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);

		Browser browser = playwright.chromium().launch(lp);

		BrowserContext bc_1 = browser.newContext();

		Page page = bc_1.newPage();
		page.navigate("https://testingbaba.com/old/index.html");
		System.out.println(page.title());
		page.locator("'×'").click();
		page.locator("'Practice'").click();
		Locator button = page.locator("button[data-target=\"#alerts\"]");
		System.out.println(button.isVisible());
		System.out.println(button.innerText());
		button.click();
		page.locator("a[href=\"#tab_12\"]").click();
//		page.onDialog(dialog -> {
//		    System.out.println("Alert Message: " + dialog.message());
//		    dialog.accept();
//		});
		//page.onDialog(dialog -> System.out.println(dialog.message()));

		//page.locator("button[onclick=\"myalert()\"]").click();
		page.onDialog(dialog -> dialog.dismiss());

		Locator clickMe = page.locator("button[onclick=\"myconfirm()\"]");
		clickMe.click();
		System.out.println(clickMe.textContent());



	}

}
