package teamCity.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SimplestTest{

    @Test
    public void runTest(){

        Logger logger = Logger.getLogger("Main Logger");

        logger.info("--- Start Simplest Test ---");

        final String variable = "System Properties";
        final String result = System.getProperty("result");  
        
        
//         final String variable = "Environment";
//         final String result = System.getenv("result");
        
        logger.info(String.format("%s variable 'result' = '%s'", variable, result));

        logger.info(String.format("Check is %s variable 'result' = 'Pass'", variable));

        Assert.assertEquals(result, "Pass", "You didn't choose Pass for Simplest Test :(");

        logger.info("--- Finish Simplest Test ---");

    }

}
