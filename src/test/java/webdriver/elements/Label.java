package webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.ArrayList;
import java.util.List;

public class Label extends BaseElement {

	public Label(final By locator, final String name) {
		super(locator, name);
	}

	public Label(String string, String name) {
		super(string, name);
	}

	public Label(By locatorStageA, By locatorStageB, String name) {
		super(locatorStageA, locatorStageB, name);
	}

	public Label(By locator) {
		super(locator);
	}

	public Label() { }

	protected String getElementType() {
		return getLoc("loc.label");
	}

	/**
	 * Getting UI elements By Similar XPath
	 *
	 * @param xpath xpath locator
	 * @return elements list
	 */
    public List<Label> getConvertedElements(String xpath) {
        List<WebElement> webElementList = getBrowser().getDriver().findElementsByXPath(xpath);
        List<Label> labelList = new ArrayList<>();
        for (WebElement webel : webElementList) {
            labelList.add(new Label(By.xpath(xpath + "[contains(text(),'" + webel.getText() + "')]")));
        }
        return labelList;
    }

}
