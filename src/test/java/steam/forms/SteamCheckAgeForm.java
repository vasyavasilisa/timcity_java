package steam.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.PropertiesResourceManager;
import webdriver.elements.Button;
import webdriver.elements.ComboBox;


public class SteamCheckAgeForm extends BaseForm {
    private static final String DATE_SELECT_LOCATOR = "//select[@name='%s']";
    private static final String ENTER_BUTTON_LOCATOR = "//span[contains(text(),'%s')]";
    private ComboBox cmbDayOfBirth = new ComboBox(By.xpath(String.format(DATE_SELECT_LOCATOR, Date.DAY.getValue())), "Day Of Birth Type ComboBox");

    public enum Date {
        DAY("ageDay"),
        MONTH("ageMonth"),
        YEAR("ageYear");

        private String value;

        Date(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    public void chooseAgeIfExist() {
        if (cmbDayOfBirth.isPresent()) {
            PropertiesResourceManager stageProperties = getStageProperties();
            cmbDayOfBirth.selectByValue(stageProperties.getProperty("birthDay"));
            ComboBox cmbMonthOfBirth = new ComboBox(By.xpath(String.format(DATE_SELECT_LOCATOR, Date.MONTH.getValue())), "Month Of Birth Type ComboBox");
            cmbMonthOfBirth.selectByValue(stageProperties.getProperty("birthMonth"));
            ComboBox cmbYearOfBirth = new ComboBox(By.xpath(String.format(DATE_SELECT_LOCATOR, Date.YEAR.getValue())), "Year Of Birth Type ComboBox");
            cmbYearOfBirth.selectByValue(stageProperties.getProperty("birthYear"));
            Button btnEnter = new Button(By.xpath(String.format(ENTER_BUTTON_LOCATOR, new String((getTextPropertiesManager().getProperty("enterButton"))))), "Age Enter");
            btnEnter.click();

        }
    }

}
