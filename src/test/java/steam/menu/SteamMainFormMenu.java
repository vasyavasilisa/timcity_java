package steam.menu;


import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.CommonFunctions;
import webdriver.elements.MenuItem;


public class SteamMainFormMenu extends BaseForm {


    private static final String MAIN_MENU_LOCATOR = "//*[@id='genre_tab']/span/a[contains(text(),'%s')][contains(@href,'http')]";
    private static final String SUB_MENU_LOCATOR = "//a[@class='popup_menu_item' and contains(text(),'%s')]";


    public enum MainFormMenuItem {
        YOURSTORE("Your Store"),
        GAMES("Game"),
        SOFTWARE("Software"),
        HARDWARE("Hardware"),
        VIDEOS("Videos"),
        NEWS("News");


        private String value;

        MainFormMenuItem(String value) {
            this.value = value;
        }

        public String toString() {
            switch (this) {
                case YOURSTORE:
                    return getTextPropertiesManager().getProperty("mainMenuStore");
                case GAMES:
                    return getTextPropertiesManager().getProperty("mainMenuGames");
                case SOFTWARE:
                    return getTextPropertiesManager().getProperty("mainMenuSoftware");
                case HARDWARE:
                    return getTextPropertiesManager().getProperty("mainMenuHardware");
                case VIDEOS:
                    return getTextPropertiesManager().getProperty("mainMenuVideos");
                case NEWS:
                    return getTextPropertiesManager().getProperty("mainMenuNews");
            }
            return null;
        }

    }

    public enum MainFormSubMenuItem {
        ACTION("Action");

        private String value;

        MainFormSubMenuItem(String value) {
            this.value = value;
        }

        public String toString() {
            switch (this) {
                case ACTION:
                    return getTextPropertiesManager().getProperty("mainMenuGamesAction");
            }
            return null;
        }

    }

    public void clickItem(MainFormMenuItem item, MainFormSubMenuItem subItem) {
        new MenuItem(By.xpath(String.format(MAIN_MENU_LOCATOR, item.toString())), CommonFunctions.getValuesForEnum(MainFormMenuItem.values())).moveMouseToElement();
        new MenuItem(By.xpath(String.format(SUB_MENU_LOCATOR, subItem.toString())), CommonFunctions.getValuesForEnum(MainFormSubMenuItem.values())).click();
    }

}




