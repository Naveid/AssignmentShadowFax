import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import groovyjarjarantlr.ASdebug.ASDebugStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Naved on 05-Mar-21.
 */
public class check extends testBase{
    ExtentTest logger;

    @BeforeTest
    public void BtcheckNetbankingToCorpBank() throws  Exception{
        try {
                this.logger = reports.createTest("checkNetbankingToCorpBank");
                loginPage.closeLoginPOPUP.click();
                helperMethod.waitforClickable(driver, homePage.linkTextMobiles);
                homePage.linkTextMobiles.click();
                helperMethod.moveOverElementclick(driver, categoryMobilePage.LinkTextElectronics);
                helperMethod.waitforClickable(driver, categoryMobilePage.LinkBrandOppo);
                categoryMobilePage.LinkBrandOppo.click();
                helperMethod.moveOverElementclick(driver, categoryMobilePage.LinkOppoFindAllBelow10K);
                // helperMethod.moveOverElementclick(driver,productListPage.productOppoA3Purple16gb);
                //helperMethod.moveOverElementclick(driver, productListPage.productOppoA3Purple16gb);
                helperMethod.moveOverElementclick(driver, productListPage.productOppoA11ksilver32gb);
                ArrayList<String> windowSessions = helperMethod.getWindowhand(driver);
                driver.switchTo().window(helperMethod.getwindowbyIndex(1, windowSessions));
                helperMethod.moveOverElementclick(driver, productListPage.BtnaddToCart);
                logger.log(Status.INFO, "Adding product to Cart");
                helperMethod.waitforClickable(driver, cartPage.btncartPlaceOrder);
                driver.close();
                logger.log(Status.INFO, "Switching back to Parent Window");
                driver.switchTo().window(helperMethod.getwindowbyIndex(0, windowSessions));
                homePage.Flipkartlogo.click();
                helperMethod.waitforClickable(driver, homePage.linkTextMobiles);
                Assert.assertEquals(driver.getTitle(), "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
                logger.log(Status.INFO, "HomeScreen Loaded Sucessfully");
                helperMethod.waitforClickable(driver, homePage.FlipkartCart);
                homePage.FlipkartCart.click();
                Assert.assertTrue(driver.getCurrentUrl().contains("Cart"));
                logger.log(Status.INFO, "Cart Loaded Sucessfully");
                helperMethod.waitforClickable(driver, cartPage.btncartPlaceOrder);
                cartPage.btncartPlaceOrder.click();
                helperMethod.moveOverElementclick(driver, orderPage.usernamelogin);
                orderPage.usernamelogin.sendKeys(prop.getProperty("username"));
                orderPage.btnUsernameCont.click();
                helperMethod.moveOverElementclick(driver, orderPage.pwdLogin);
                orderPage.pwdLogin.sendKeys(prop.getProperty("password"));
                orderPage.btnLogin.click();
                logger.log(Status.INFO, "Login Sucessfull");
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                orderPage.clickAddressRadio(driver, prop.getProperty("FirstPin"), prop.getProperty("SecondPin"));
                helperMethod.waitforVisible(driver, orderPage.radiobypin);
                orderPage.radiobypin.click();
                orderPage.ClickDeliverHere(driver);
                //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //helperMethod.waitforClickable(driver,orderPage.radiobypin);
                Thread.sleep(2000);
                helperMethod.moveOverElementclick(driver, orderPage.BtnDeliverHere);
                helperMethod.ScrollPagetoBottom(driver);
                helperMethod.waitforClickable(driver,orderPage.btnChangeDeliverycontinue);
            }catch (AssertionError e){
                logger.log(Status.FAIL,"Test Assertion Failed");
                logger.log(Status.INFO,e);
                logger.addScreenCaptureFromPath(helperMethod.takeScreenShot(driver, "bankScreenshot"));
            }
        catch (Exception e){
            logger.log(Status.FAIL,"Test execution stopped");
            logger.log(Status.INFO,e);
            logger.addScreenCaptureFromPath(helperMethod.takeScreenShot(driver, "bankScreenshot"));
        }finally {
            reports.flush();
        }
    }

    @Test
    public void VerifyCartContent()throws Exception{
try{
        Assert.assertEquals(orderPage.inputOrderEmail.getAttribute("value"), prop.getProperty("username"), "email not matched");
        logger.log(Status.PASS, "UserName Verified");
        Assert.assertEquals(orderPage.totalProductsInCart.size(), 1, "more than one product added in Cart");
        logger.log(Status.PASS, "Number of product equals 1");
        orderPage.btnContinueToPayment.click();
        helperMethod.waitforClickable(driver, orderPage.btnChangeOrdercontinue);
        helperMethod.ScrollPagetoBottom(driver);
        helperMethod.moveOverElementclick(driver, orderPage.RadioNetBankingbanking);
        helperMethod.SelectfromDropdown(driver, orderPage.SelectDropdown, prop.getProperty("bankToBill"));
        orderPage.btnPay.click();
        logger.log(Status.INFO, "Pay button interacted ");
        Thread.sleep(10000);
    }catch (AssertionError e){
    logger.log(Status.FAIL,"Cart verification failed");
    logger.log(Status.INFO,e);
    logger.addScreenCaptureFromPath(helperMethod.takeScreenShot(driver, "error"));
}catch (Exception e){
    logger.log(Status.FAIL,"Test execution stopped");
    logger.log(Status.INFO,e);
    logger.addScreenCaptureFromPath(helperMethod.takeScreenShot(driver, "error"));
}finally {
    reports.flush();
}
    }


    @Test(dependsOnMethods = "VerifyCartContent")
    public void checkNetbankingToCorpBank() throws Exception {
        try {

                Assert.assertTrue(driver.getCurrentUrl().contains("unionbankonline.co.in"));
                logger.addScreenCaptureFromPath(helperMethod.takeScreenShot(driver, "bankScreenshot"));
                logger.log(Status.PASS, "test Passed with screenshot taken of bank screen");
            }catch (AssertionError e){
                logger.log(Status.FAIL,"Banking website not reached Assertion Failed");
                logger.log(Status.INFO,e);
                logger.addScreenCaptureFromPath(helperMethod.takeScreenShot(driver, "ErrorScreenshot"));
            } catch (Exception e){
            logger.log(Status.FAIL,"Test execution stopped exception triggered");
            logger.log(Status.INFO,e);
            logger.addScreenCaptureFromPath(helperMethod.takeScreenShot(driver, "ErrorScreenshot"));
        }finally {

            reports.flush();
        }
    }
}
