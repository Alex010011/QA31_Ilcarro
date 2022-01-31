package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.text.ParseException;

public class HelperSearch extends HelperBase{


    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void fillSearchFormCurrentMonth(String city, String dateFrom, String dateTo) {

        fillInputCity(city);
        selectPeriodCurrentMonth(dateFrom,dateTo);
    }

    private void fillInputCity(String city) {
        type(By.id("city"),city);
        click(By.cssSelector(".pac-item"));
        pause(500);
    }

    private void selectPeriodCurrentMonth(String dateFrom, String dateTo) {

        click(By.id("dates"));

        String[]dataF = dateFrom.split("/");
        String[]dataT = dateTo.split("/");

        String locator = "//div[text()=' "+dataF[1]+" ']";

        String loc = String.format("//div[text()=' %s ']",dataF[1]);


        click(By.xpath(locator));

        String locator2="//div[text()=' "+dataT[1]+" ']";
        click(By.xpath(locator2));
        pause(5000);

    }

    public boolean isListOfCarsAppeared(){
        return isElementPresent(By.cssSelector(".search-results"));
    }


    public void fillSearchFormNowPlusWeek(String city, String dateFrom, String dateTo) {

        fillInputCity(city);
        selectPeriodNowPlusWeek(dateFrom,dateTo);

    }

    private void selectPeriodNowPlusWeek(String dateFrom, String dateTo) {

        click(By.id("dates"));

        String[] dataF = dateFrom.split("-");
        String[] dataT = dateTo.split("-");

        int dayF = Integer.parseInt(dataF[2]);
        if(dayF<10) dayF %=10;
        int dayT = Integer.parseInt(dataT[2]);
        if(dayT<10) dayT %=10;

        int monthF = Integer.parseInt(dataF[1]);
        if(monthF<10) monthF %=10;
        int monthT = Integer.parseInt(dataT[1]);
        if(monthT<10) monthT %=10;


        String locator = "//div[text()=' " + dayF + " ']";
        click(By.xpath(locator));
        pause(1000);
        //String loc = String.format("//div[text()=' %s ']",dataF[2]);

        String locator2 = "//div[text()=' " + dayT + " ']";


        if (monthT - monthF > 0) {
            for (int i = 0; i < monthT - monthF; i++) {
                click(By.xpath("//*[@aria-label='Next month']"));
            }
        }
//            WebElement secDay = wd.findElement(By.xpath(locator2));
//            Rectangle rect = secDay.getRect();
//
//            Actions actions = new Actions(wd);
//            actions.moveToElement(secDay).release().build().perform();
//
//            int y = rect.getHeight();
//            actions.moveByOffset(0, y).click().release().build().perform();

            click(By.xpath(locator2));
            pause(5000);
        }

    }


