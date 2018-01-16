package demo.test.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.TextBox;

/**
 * Created on 02.05.2017.
 */
public class GoogleMainForm extends BaseForm {

    private static final String MAIN_LOCATOR = "//*[@id='hplogo']";

    private final TextBox txbSearchField = new TextBox(By.xpath("//form//input[@type='text']"), "Search Field");

    public GoogleMainForm(){
        super(By.xpath(MAIN_LOCATOR), "Google Main Form");
    }

    public void performSearch(String searchString){
        txbSearchField.setText(searchString);
    }
}
