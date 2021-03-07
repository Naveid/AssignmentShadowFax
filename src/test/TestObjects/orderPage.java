import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Naved on 05-Mar-21.
 */
public class orderPage {
    String LabelwithXpath;
    @FindBy(xpath = "//input[@class='_2IX_2- _17N0em']")
    WebElement usernamelogin;
    @FindBy(xpath = "//span[.='CONTINUE']//ancestor::button")
    WebElement btnUsernameCont;
    @FindBy(xpath = "//input[@type='password']")
    WebElement pwdLogin;
    @FindBy(xpath = "//span[.='Login']//ancestor::button")
    WebElement btnLogin;
    @FindBy (xpath = "//span[contains(.,'email will be')]//input")
            WebElement inputOrderEmail;
    @FindBy (xpath = "//div[@class='zab8Yh']")
            List<WebElement> totalProductsInCart;
@FindBy( xpath = "//div[.='Net Banking']//ancestor::label")
WebElement RadioNetBankingbanking;
    @FindBy (xpath = "//button[.='CONTINUE']")
            WebElement btnContinueToPayment;
    @FindBy(xpath = "//div[.='Delivery Address']//ancestor::div[@class='rvsx1l']//button[.='Change']")
    WebElement btnChangeDeliverycontinue;
    @FindBy (xpath = "//div[.='Order Summary']//ancestor::div[@class='rvsx1l']//button[.='Change']")
            WebElement btnChangeOrdercontinue;

    @FindBy (xpath = "//select[@class='_1kwp-i']")
            WebElement SelectDropdown;
    @FindBy(xpath = "//button[contains(.,'PAY')]")
            WebElement btnPay;
    WebElement radiobypin;
    WebElement BtnDeliverHere;




    public void clickAddressRadio(WebDriver driver,String firstpin, String Secondpin) {

        this.LabelwithXpath = "(//span[starts-with(.,'"+firstpin+"')]|//span[starts-with(.,'"+Secondpin+"')])[1]//ancestor::label";
        this.radiobypin= driver.findElement(By.xpath(LabelwithXpath));
       // (//span[starts-with(.,'56')]|//span[starts-with(.,'22')])[1]//ancestor::label/input//following-sibling::div[@class='_1XFPmK']
        }
        public void ClickDeliverHere(WebDriver driver){
        String labelvalue= radiobypin.getAttribute("for");
        String XpathtoButton="//label[@for='"+labelvalue+"']//button[contains(.,'Deliver')]";
            this.BtnDeliverHere=driver.findElement(By.xpath(XpathtoButton));
        }



}
