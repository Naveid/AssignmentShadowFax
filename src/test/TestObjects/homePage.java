import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;

import javax.swing.*;
import java.util.WeakHashMap;

/**
 * Created by Naved on 05-Mar-21.
 */
public class homePage {

    @FindBy(xpath = "//div[@class='_331-kn _2tvxW']//div[.='Mobiles']/a")
    WebElement linkTextMobiles;
    @FindBy(xpath = "//img[@title='Flipkart']//parent::a")
    WebElement Flipkartlogo;
    @FindBy(xpath = "//span[.='Cart']//ancestor::a")
    WebElement FlipkartCart;



    }


