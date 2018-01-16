package steam.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.CommonFunctions;
import webdriver.PropertiesResourceManager;
import webdriver.elements.Link;
import webdriver.utils.rest.RequestMethod;
import webdriver.utils.rest.RestClient;


public class SteamInstallForm extends BaseForm {

    private static String DOWNLOAD_FILE_NAME = "\\SteamSetup.exe";
    private static final String DOWNLOAD_LINK_LOCATOR = "//div[@id='about_greeting_ctn']//*//a[@id='about_install_steam_link']";
    private Link lnkDownload;

    public SteamInstallForm() {

    }

    public void downloadFile() {
        lnkDownload = new Link(By.xpath((DOWNLOAD_LINK_LOCATOR)), "Download File");
        lnkDownload.click();
    }

    public void assertFileFullDownload() {
        String href = lnkDownload.getAttribute("href");
        PropertiesResourceManager propertiesResourceManager = getStageProperties();
        String downloadDir = propertiesResourceManager.getProperty("downloadDir");
        RestClient restClient = new RestClient(href, RequestMethod.GET, null);
        restClient.doRequest();
        long size = restClient.getContentLength();
        String downloadFileName = DOWNLOAD_FILE_NAME;
        String downloadFilePath = getRootDir() + downloadDir + downloadFileName;
        boolean isFileFullDownload = CommonFunctions.isFileFullDownloadToDirectory(downloadFilePath, size, Integer.valueOf(getBrowser().getTimeoutForCondition()));
        doAssert(isFileFullDownload, "File Was Download Completly", "File Was Not Download Completly");
    }
}
