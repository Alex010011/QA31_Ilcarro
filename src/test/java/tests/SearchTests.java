package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.time.LocalDate;


public class SearchTests extends TestBase{

    @Test
    public void searchPeriodCurrentMonth(){

        app.search().fillSearchFormCurrentMonth("Tel Aviv, Israel","1/31/2022","1/31/2022");
        app.getUserHelper().submitForm();



        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }

    @Test
    public void searchPeriodCurrentFromTodayForWeek(){

        String today= String.valueOf(LocalDate.now());

        String plusWeek = String.valueOf(LocalDate.now().plusDays(7));


        app.search().fillSearchFormNowPlusWeek("Tel Aviv, Israel",today,plusWeek);
        app.getUserHelper().submitForm();

        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }

    @AfterMethod
            public void backToStart(){

        app.search().pause(5000);
       app.search().click(By.cssSelector("[href='/search']"));

    }

}
