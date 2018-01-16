package steam.menu;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.CommonFunctions;
import webdriver.elements.MenuItem;


public class SteamGenreFormMenu extends BaseForm {

    private static final String MAIN_MENU_LOCATOR = "//div[contains(text(),'%s')]";


    public enum SteamGenreFormMenuItem {
        POPULAR("Your Store"),
        TOP_SELLERS("Game"),
        SPECIALS("Software"),
        NEW("Hardware");

        private String value;

        SteamGenreFormMenuItem(String value) {
            this.value = value;
        }

        public String toString() {
            switch (this) {
                case POPULAR:
                    return getTextPropertiesManager().getProperty("genrePageMenuPopular");
                case TOP_SELLERS:
                    return getTextPropertiesManager().getProperty("genrePageMenuTopSellers");
                case SPECIALS:
                    return getTextPropertiesManager().getProperty("genrePageMenuSpecials");
                case NEW:
                    return getTextPropertiesManager().getProperty("genrePageMenuNewReleases");
            }
            return null;

        }

    }

    public SteamGenreFormMenu() {
    }

    public void clickItem(SteamGenreFormMenu.SteamGenreFormMenuItem item){
        String fullLocator = String.format(MAIN_MENU_LOCATOR,item.toString());
        new MenuItem(By.xpath(fullLocator), CommonFunctions.getValuesForEnum(SteamGenreFormMenuItem.values())).click();
    }
}
