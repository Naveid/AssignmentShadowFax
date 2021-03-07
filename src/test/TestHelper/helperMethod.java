import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Naved on 05-Mar-21.
 */
public class helperMethod {

    public void waitforClickable(WebDriver driver, WebElement webElement){
        WebDriverWait webDriverWait = new WebDriverWait(driver,30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));

    }
    public void waitforVisible(WebDriver driver, WebElement webElement){
        WebDriverWait webDriverWait = new WebDriverWait(driver,30);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));

    }
    public void moveOverElementclick(WebDriver driver,WebElement webElement) {
        Actions actions = new Actions(driver);
        waitforClickable(driver, webElement);
        actions.moveToElement(webElement).click().perform();
    }
 public ArrayList<String> getWindowhand(WebDriver driver){
     Set<String> browserwindow =driver.getWindowHandles();
     Iterator iter = browserwindow.iterator();
     ArrayList<String> arrayList = new ArrayList<>();
     while(iter.hasNext()){
         arrayList.add(iter.next().toString());
     }
     return arrayList;
 }
 public String getwindowbyIndex(int counter,ArrayList<String> windowHandles){
     return windowHandles.get(counter);
 }

 public void SelectfromDropdown(WebDriver driver,WebElement element,String text){
     Select select = new Select(element);
     select.selectByValue(text);
//     List<WebElement> selectDrop = select.getOptions();
//     for(WebElement k: selectDrop){
//         if (k.getText().equals(text)) {
//
//         }

 }

 public void ScrollPagetoBottom(WebDriver driver){
     JavascriptExecutor jse6 = (JavascriptExecutor) driver;
           jse6.executeScript("window.scrollTo(0, document.body.scrollHeight)");


 }

    public static String takeScreenShot(WebDriver driver,String screenShotName) throws IOException {

        //create a string variable which will be unique always
        String df = new SimpleDateFormat("yyyyMMddhhss").format(new Date());

        //create object variable of TakeScreenshot class
        TakesScreenshot ts = (TakesScreenshot)driver;

        //create File object variable which holds the screen shot reference
        File source = ts.getScreenshotAs(OutputType.FILE);

        //store the screen shot path in path variable. Here we are storing the screenshots under screenshots folder
        String path = System.getProperty("user.dir") + "/test-output/screenshots/" + screenShotName + df + ".png";

        //create another File object variable which points(refer) to the above stored path variable
        File destination = new File(path);

        //use FileUtils class method to save the screen shot at desired path
        FileUtils.copyFile(source, destination);

        //return the path where the screen shot is saved
        return path;




    }
}
