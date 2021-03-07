import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Naved on 05-Mar-21.
 */
public class productListPage {

    @FindBy(xpath = "//div[@class='_1AtVbE col-12-12']//div[.='OPPO A3s (Purple, 16 GB)']")
    WebElement productOppoA3Purple16gb;
    @FindBy(xpath = "//div[@class='_1AtVbE col-12-12']//div[.='OPPO A11K (Flowing Silver, 32 GB)']")
    WebElement productOppoA11ksilver32gb;
    @FindBy(xpath = "//button[text()='ADD TO CART']")
    WebElement BtnaddToCart;
}
