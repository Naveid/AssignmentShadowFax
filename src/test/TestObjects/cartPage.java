import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Naved on 05-Mar-21.
 */
public class cartPage {

    @FindBy(xpath = "//span[.='Place Order']//parent::button")
    WebElement btncartPlaceOrder;
}
