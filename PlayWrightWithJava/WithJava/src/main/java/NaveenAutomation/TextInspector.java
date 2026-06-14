package NaveenAutomation;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TextInspector {
	
	@Test
	  void test(Page page) {
	    page.locator("#nav-cover").click();
	    page.locator("#nav-cover").click();
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Waste & recycling").setExact(true)).click();
	    page.locator("div:nth-child(2) > span > .puis-card-container > .a-section.a-spacing-base > .s-product-image-container > .rush-component > .a-link-normal").click();
	    Page page1 = page.waitForPopup(() -> {
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Mumma's LIFE 15L Dustbin for")).click();
	    });
	    page1.navigate("https://www.amazon.in/dp/B0DZTJHCTV/ref=sspa_dk_detail_3?pd_rd_i=B0DZTJHCTV&pd_rd_w=Nn0zs&content-id=amzn1.sym.cebd979a-4e06-4bc9-ba7d-b9887a34ed18&pf_rd_p=cebd979a-4e06-4bc9-ba7d-b9887a34ed18&pf_rd_r=Z0KMYVA0W3YC5PG92SR8&pd_rd_wg=Jeeqi&pd_rd_r=302c2518-5f10-4c88-be09-3d8d290bbb70&aref=90BkUXp1jy&sp_csd=d2lkZ2V0TmFtZT1zcF9kZXRhaWxfdGhlbWF0aWM&th=1");
	    page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Amazon Basics Wall-Mounted")).click();
	    page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart").setExact(true)).click();
	    page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Proceed to Buy (1 item) Buy")).click();
	  }
	

}
