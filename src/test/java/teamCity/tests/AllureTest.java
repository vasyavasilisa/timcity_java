package teamCity.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

import javax.script.ScriptException;


public class AllureTest {

    private Logger logger = Logger.getLogger("Main Logger");
    private String variable;
    private String result;

    @Test
    @Title("Проверка переданного аргумента")
    public void runTest() throws InterruptedException, ScriptException {
        logger.info("--- Start Simplest Test ---");
        Step_1();
        Step_2();
        logger.info("--- Finish Simplest Test ---");
    }

    @Step("Получение аргумента")
    private void Step_1() {
        variable = "Environment";
        result = System.getenv("result");
        logger.info(String.format("%s variable 'result' = '%s'", variable, result));
    }

    @Step("Проверка аргумента")
    private void Step_2() {
        logger.info(String.format("Check is %s variable 'result' = 'Pass'", variable));
        Assert.assertEquals(result, "Pass", "You didn't choose Pass for Simplest Test :(");
    }

}
