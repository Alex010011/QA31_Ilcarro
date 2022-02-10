package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.time.LocalDate;


public class SearchTests extends TestBase{

    @Test
    public void searchPeriodCurrentMonth(){

        app.search().fillSearchFormCurrentMonth("Tel Aviv, Israel","2/15/2022","2/28/2022");
        app.getUserHelper().submitForm();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }

    @Test
    public void searchPeriodCurrentFromTodayForWeek(){

        String today= String.valueOf(LocalDate.now());

        String plusWeek = String.valueOf(LocalDate.now().plusDays(7));


        app.search().fillSearchFormNowPlusWeek("Haifa, Israel",today,plusWeek);
        app.getUserHelper().submitForm();

        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }

    @Test
    public void  typePeriodInPast(){
        app.search().fillSearchFormInPast("Haifa, Israel","1/31/2022","1/31/2022");

        Assert.assertTrue(app.search().isDateInPast());
        Assert.assertTrue(app.search().isYallaButtonInactive());

        //Yalla not clickable
        //error message displayed

    }

//    @Test
//    public void searchPeriodByButtons(){
//
//        app.search().fullSearchFormByButtons("Tel Aviv, Israel","03/30/2022","06/25/2022");
//        app.getUserHelper().submitForm();
//    }

    @Test
    public void searchPeriodAnyData(){

        app.search().fillSearchFormInFuture("Tel Aviv, Israel","03/30/2022","06/25/2022");
        app.search().pause(7000);

        app.getUserHelper().submitForm();
        Assert.assertTrue(app.search().isListOfCarsAppeared());

    }

    @AfterMethod
            public void backToStart(){

        app.search().pause(5000);
       app.search().click(By.cssSelector("[href='/search']"));

    }

}
