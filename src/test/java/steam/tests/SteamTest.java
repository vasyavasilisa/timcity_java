package steam.tests;

import steam.menu.SteamGenreFormMenu;
import steam.menu.SteamMainFormMenu;
import steam.forms.*;
import steam.model.Game;
import webdriver.BaseTest;


public class SteamTest extends BaseTest {

    @Override
    public void runTest(){
        logStep(1);
        SteamMainForm steamMainForm = new SteamMainForm();
        steamMainForm.changeLanguageIfNeeded();
        logStep(2);
        steamMainForm.menu.clickItem(SteamMainFormMenu.MainFormMenuItem.GAMES, SteamMainFormMenu.MainFormSubMenuItem.ACTION);
        logStep(3);
        SteamGenreListForm genrePage = new SteamGenreListForm();
        genrePage.menu.clickItem(SteamGenreFormMenu.SteamGenreFormMenuItem.TOP_SELLERS);
        logStep(4);
        Game selectedGame = genrePage.clickMaxDiscountAndReturnGame();
        logStep(5);
        SteamCheckAgeForm checkAge = new SteamCheckAgeForm();
        checkAge.chooseAgeIfExist();
        logStep(6);
        SteamGameDescriptionForm descriptionPage = new SteamGameDescriptionForm();
        descriptionPage.assertPriceAndDiscountCorrect(selectedGame);
        logStep(7);
        descriptionPage.clickOnInstall();
        logStep(8);
        SteamInstallForm installPage = new SteamInstallForm();
        installPage.downloadFile();
        logStep(9);
        installPage.assertFileFullDownload();
    }
}
