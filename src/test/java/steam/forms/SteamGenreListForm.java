package steam.forms;


import org.openqa.selenium.By;
import steam.menu.SteamGenreFormMenu;
import steam.model.Game;
import webdriver.BaseForm;
import webdriver.CommonFunctions;
import webdriver.elements.Label;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SteamGenreListForm extends BaseForm {
    public SteamGenreFormMenu menu = new SteamGenreFormMenu();
    private Label lblDiscount;
    private Label lblPrice;
    private static final String DISCOUNT_LOCATOR = "//*[@id='tab_TopSellers_content']//a//div[@class='discount_pct']";
    private static final String PRICE_LABEL_LOCATOR = "//*[@id='tab_TopSellers_content']//a/div[@class='discount_block tab_item_discount']/div[@class='discount_prices']/div[@class='discount_final_price']";
//    private static final String AGE_GENRE = "//div[@class = 'tab_content_ctn sub']/div[@id = 'tab_TopSellers_content']//a[6]/div[@class='tab_item_cap']/img[@class='tab_item_cap_img']";

    public SteamGenreListForm() {
        super(By.xpath(String.format("//h2[contains(text(),'%s')]", getTextPropertiesManager().getProperty("genrePageTitle"))), "Action");
    }

    public Game clickMaxDiscountAndReturnGame() {
        Label tmpLabel = new Label();
        List<Label> llblDiscount = tmpLabel.getConvertedElements(DISCOUNT_LOCATOR);
        List<Label> llblPrice = tmpLabel.getConvertedElements(PRICE_LABEL_LOCATOR);
        List<Integer> ldiscounts = new ArrayList<>();
        for (Label element : llblDiscount) {
            ldiscounts.add(Integer.valueOf(CommonFunctions.regexGetMatch(element.getText(), "[0-9]+")));
        }
//        assertEquals(ldiscounts.toString(), 1, 2);
        Object maxItem = Collections.max(ldiscounts);
        Integer maxItemIndex = ldiscounts.indexOf(maxItem);
        lblDiscount = tmpLabel.findElementByInd(llblDiscount, maxItemIndex);
//        lblDiscount = new Label(By.xpath(AGE_GENRE));
        lblPrice = tmpLabel.findElementByInd(llblPrice, maxItemIndex);
        Game game = new Game(lblDiscount.getText(), CommonFunctions.regexGetMatch(lblPrice.getText(), "\\W[0-9]{1,2}\\.[0-9]{2}"));
        lblDiscount.click();
        return game;

    }
}
