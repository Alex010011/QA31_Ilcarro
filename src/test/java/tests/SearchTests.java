package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends TestBase{

    @Test
    public void searchPeriodCurrentMonth(){

        app.search().fillSearchFormCurrentMonth("Tel Aviv, Israel","1/28/2022","1/30/2022");
        app.getUserHelper().submitForm();

        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }
}
