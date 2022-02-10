package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.DateFormatter;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        click(By.cssSelector(".search-card"));

    }

    private void selectPeriodCurrentMonth(String dateFrom, String dateTo) {

        click(By.id("dates"));

        String[]dataF = dateFrom.split("/");
        String[]dataT = dateTo.split("/");

        String locator = "//div[text()=' "+dataF[1]+" ']";

        String loc = String.format("//div[text()=' %s ']",dataF[1]);


        click(By.xpath(loc));

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

    public void fillSearchFormInFuture(String city, String from, String to) {

        fillInputCity(city);
        selectAnyData(from, to);
    }

    private void selectAnyData(String dateFrom, String dateTo){

        LocalDate from = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate to = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate now = LocalDate.now();
        click(By.id("dates"));

        int monthDiff = from.getYear() -now.getYear()
                ==0 ? from.getMonthValue()-now.getMonthValue() : 12- now.getMonthValue()+from.getMonthValue();

        clickNextMonth(monthDiff);

        String dateLocator = String.format("//div[text()=' %s ']", from.getDayOfMonth());
        click(By.xpath(dateLocator));

        monthDiff=to.getYear()-from.getYear()
                ==0? to.getMonthValue()-from.getMonthValue():12-from.getMonthValue()+to.getMonthValue();
        clickNextMonth(monthDiff);

        dateLocator = String.format("//div[text()=' %s ']", to.getDayOfMonth());

        click(By.xpath(dateLocator));

    }

    private void clickNextMonth(int count) {
        for (int i = 0; i < count; i++) {
            click(By.xpath("//*[@aria-label='Next month']"));

        }
    }

    public void fillSearchFormInPast(String city, String from, String to) {

        fillInputCity(city);
        typePeriodInPast(from,to);
        //click();

    }

    private void typePeriodInPast(String from, String to) {
        type(By.id("dates"), from+" - "+to);
        click(By.cssSelector(".cdk-overlay-container"));
    }

    public boolean isDateInPast(){

        WebElement el = wd.findElement(By.cssSelector(".error .ng-star-inserted"));
        String text = el.getText();
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.textToBePresentInElement(el,text));

        System.out.println(text);
        return text.contains("pick date before today");

    }

    public boolean isYallaButtonInactive() {

        return !wd.findElement(By.cssSelector("[type='submit']")).isEnabled();


    }
//    public void fullSearchFormByButtons(String city, String dateFrom, String dateTo) {
//
//        LocalDate from = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//        LocalDate to = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//        LocalDate now = LocalDate.now();
//        click(By.id("dates"));
//
//        click(By.cssSelector(".mat-calendar-arrow"));
//        String yearLocator = String.format("//div[text()=' %s ']", from.getYear());
//        click(By.xpath(yearLocator));
//
//        dateLocator = String.format("//div[text()=' %s ']", to.getDayOfMonth());
//
//        click(By.xpath(dateLocator));
//
//
//    }
}


