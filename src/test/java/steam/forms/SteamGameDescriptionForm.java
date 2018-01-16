package steam.forms;


import org.openqa.selenium.By;
import steam.model.Game;
import webdriver.BaseForm;
import webdriver.elements.Label;
import webdriver.elements.Link;


public class SteamGameDescriptionForm extends BaseForm {
    private Link lnkInstall;
    private Label lblDiscount;
    private Label lblPrice;
    private static final String INSTALL_BUTTON_LOCATOR = "//a[@class='header_installsteam_btn_content']";
    private static final String DISCOUNT_LOCATOR = "//div[@class='discount_pct']";
    private static final String FINAL_PRICE_LOCATOR = "//div[@class='discount_final_price']";


    public SteamGameDescriptionForm() {

    }

    public void assertPriceAndDiscountCorrect(Game game) {
        lblDiscount = new Label(By.xpath(DISCOUNT_LOCATOR), "Discount Value On Game Description Form");
        lblPrice = new Label(By.xpath(FINAL_PRICE_LOCATOR), "Final Price Value On Game Description Form");
        Game gameToCompare = new Game(lblDiscount.getText(), lblPrice.getText().split(" ")[0]);
        assertEquals("Discount and Price values are not correct", game, gameToCompare);
    }

    public void clickOnInstall() {
        lnkInstall = new Link(By.xpath(INSTALL_BUTTON_LOCATOR), "Install Steam");
        lnkInstall.click();
    }
}
