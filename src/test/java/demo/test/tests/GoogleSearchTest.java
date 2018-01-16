package demo.test.tests;

import demo.test.forms.GoogleMainForm;
import demo.test.forms.GoogleSearchResultsForm;
import webdriver.BaseTest;

/**
 * Created on 02.05.2017.
 */
public class GoogleSearchTest extends BaseTest {

    private final String searchString = "A1QA";

    @Override
    public void runTest(){

        logger.step(1);
        GoogleMainForm googleMainForm = new GoogleMainForm();
        googleMainForm.performSearch(searchString);

        logger.step(2);
        GoogleSearchResultsForm googleSearchResultsForm = new GoogleSearchResultsForm();
        googleSearchResultsForm.assertWidgetHeaderText(searchString);
    }
}
