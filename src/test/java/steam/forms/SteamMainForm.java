package steam.forms;

import org.openqa.selenium.By;
import steam.menu.SteamMainFormMenu;
import webdriver.BaseForm;
import webdriver.PropertiesResourceManager;
import webdriver.elements.Link;


public class SteamMainForm extends BaseForm {

    public SteamMainFormMenu menu = new SteamMainFormMenu();
    private Link lnkLanguage;
    private Link lnkConcreteLanguage;
    private static final String MAIN_LOCATOR = "//div[@class='big_buttons home_page_content']//h2";
    private static final String TEXT_LOCATORS_PROPERTIES = "%s_text.properties";
    private static final String LANG_LOCATOR = "//*[@id='language_pulldown']";
    private static final String CONCRETE_LANG_LOCATOR = "//a[@href='?l=%s']";


    public SteamMainForm() {
        super(By.xpath(MAIN_LOCATOR), "Steam Main Form");
    }


    public void changeLanguageIfNeeded(){

        PropertiesResourceManager propertiesResourceManager = getStageProperties();
        String language = propertiesResourceManager.getProperty("language");
        lnkLanguage = new Link(By.xpath(LANG_LOCATOR), "Language");
        String lang = lnkLanguage.getText();
        propertiesResourceManager = new PropertiesResourceManager(String.format(TEXT_LOCATORS_PROPERTIES, language));
        setTextPropertiesManager(propertiesResourceManager);
        if ((language.equals("ru") && !lang.equals("язык")) || (language.equals("en") && !lang.equals("language"))) {
            String locator = new String(propertiesResourceManager.getProperty("languageItem"));
            locator = String.format(CONCRETE_LANG_LOCATOR, locator);
            lnkLanguage.click();
            lnkConcreteLanguage = new Link(By.xpath(locator), "LanguageType");
            lnkConcreteLanguage.click();
        }
    }
}

