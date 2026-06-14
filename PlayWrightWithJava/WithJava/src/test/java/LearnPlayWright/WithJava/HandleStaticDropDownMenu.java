package LearnPlayWright.WithJava;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class HandleStaticDropDownMenu {
		public static void main(String[] args) throws Exception {
			
			Playwright playwright = Playwright.create();
			LaunchOptions lp = new LaunchOptions();
			lp.setChannel("chrome");
			lp.setHeadless(false);
			
			Browser browser = playwright.chromium().launch(lp);
			BrowserContext bc = browser.newContext();
			Page page = bc.newPage();
			
			//page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
			page.navigate("https://demoqa.com/select-menu");
			page.setDefaultTimeout(60000);
			//page.locator("#dropdown-class-example").selectOption("Option3");
			//page.selectOption("#dropdown-class-example", "Option3");
			Locator loc = page.locator("#dropdown-class-example");
			loc.selectOption(new SelectOption().setIndex(1));
			
			page.locator("#checkBoxOption1").click();
			page.locator("#checkBoxOption2").click();
			page.locator("#checkBoxOption3").click();
			
			page.locator("input[value=\"radio2\"]").click();
			Thread.sleep(1000);
			page.locator("input[value=\"radio1\"]").click();
			Thread.sleep(1000);
			page.locator("input[value=\"radio3\"]").click();
			
			page.evaluate("window.scrollBy(0,500)");
			
			Locator allData = page.locator("div[class=\"tableFixHead\"]>table>tbody>tr");
			
			List<String> list = allData.allTextContents();
			
			for(int i = 0 ; i < list.size() ; i++) {
				System.out.println(list.get(i));
			}
			
			
			
			page.evaluate("window.scrollBy(0,200)");

			System.out.println("--------------");
			page.locator("#mousehover").hover();
			page.locator("'Reload'").hover();
			System.out.println(page.locator("'Reload'").innerText());
			System.out.println(page.locator("'Reload'").textContent());
			
			FrameLocator frame = page.frameLocator("#courses-iframe");
			frame.locator("a[class=\"new-navbar-highlighter\"]").last().click();
			
		}

}
