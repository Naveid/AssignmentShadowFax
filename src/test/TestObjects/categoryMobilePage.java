import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Naved on 05-Mar-21.
 */
public class categoryMobilePage {

    @FindBy(xpath = "//div[@class='_1kidPb']/span[.='Electronics']" )
    WebElement LinkTextElectronics;
    @FindBy(xpath = "//a[@title='OPPO']")
    WebElement LinkBrandOppo;
    @FindBy(xpath = "//h2[.='Oppo Mobiles under ₹10K']//ancestor::div[@class='Nyt1vx']//span[.='VIEW ALL']")
    WebElement LinkOppoFindAllBelow10K;
}
