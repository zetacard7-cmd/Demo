package LearnPlayWright.WithJava;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Yahoo2 {
		public static void main(String[] args) {
			Playwright playwright = Playwright.create();
			LaunchOptions lp = new LaunchOptions();	
			lp.setChannel("chrome");
			lp.setHeadless(false);
			
			Browser browser = playwright.chromium().launch(lp);
			BrowserContext bc = browser.newContext();
			Page page = bc.newPage();
			page.setDefaultTimeout(60000);
			
			page.navigate("https://www.amazon.com/");
			page.locator("#twotabsearchtextbox").first().fill("Mobile");

			//page.locator("#twotabsearchtextbox").hover();
			
			Locator loc = page.locator(".left-pane-results-container>div");
			loc.first().waitFor();
			
			for(int i = 0 ; i < loc.count() ; i++) {
				
				String text = loc.nth(i).innerText();
				System.out.println(text);
			}
			
			System.out.println("---------------------");

		
			BrowserContext bc1 = browser.newContext();
			Page page2 = bc1.newPage();
			
			page2.navigate("https://rahulshettyacademy.com/AutomationPractice/");
			
			Locator locc = page2.locator(".tableFixHead >table>thead+tbody>tr");
			
			for(int i = 0 ; i < locc.count() ; i++) {
				
				System.out.println(locc.nth(i).innerText());
			}
			page.locator("div[id=\"sac-suggestion-row-4\"]").click();
			System.out.println("---------------------");
			ArrayList<Integer> list = new ArrayList<>();
			Locator loc2 = page2.locator(".tableFixHead>table>thead+tbody>tr>td+td+td+td");
			
			for(int i = 0 ; i < loc2.count() ; i++) {
				
				System.out.println(loc2.nth(i).innerText());
				String nos = loc2.nth(i).innerText();
				
				int no = Integer.parseInt(nos);
				list.add(no);
			}
			int sum = 0 ;
			for(int k = 0 ;  k < list.size() ; k++) {
				sum = sum + list.get(k);
			}
			System.out.println(sum);
		}
//.tableFixHead>table>tbody>tr>td:nth-child(4)
//.tableFixHead td:nth-child(4)
}
