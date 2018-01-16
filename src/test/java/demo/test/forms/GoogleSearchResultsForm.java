package demo.test.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;

/**
 * Created on 02.05.2017.
 */
public class GoogleSearchResultsForm extends BaseForm {

    private static final String MAIN_LOCATOR = "//div[@id='rcnt']";

    private final Label lblWidgetHeader = new Label(By.xpath("//div[@id='rhs_block']//div[@role='heading']/div"), "Widget Header Label");

    public GoogleSearchResultsForm(){
        super(By.xpath(MAIN_LOCATOR), "Google Search Results Form");
    }

    public void assertWidgetHeaderText(String text){
        assertEquals("Incorrect widget header text", text, lblWidgetHeader.getText());
    }
}
