
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.*;

import java.io.FileReader;
import java.util.Properties;

/**
 * Created by Naved on 05-Mar-21.
 */
public class testBase {
    WebDriver driver;
    Properties prop;
    ExtentReports reports;
    loginPage loginPage;
    homePage homePage;
    helperMethod helperMethod = new helperMethod();
    categoryMobilePage categoryMobilePage;
    productListPage productListPage;
    cartPage cartPage;
    orderPage orderPage;

    public testBase() {
    }

    public testBase(WebDriver driver) {
        this.driver = driver;
    }

    public Properties loadProperties() throws Exception{
        FileReader reader=new FileReader("./src/Utilities/general.properties");
        Properties p=new Properties();
        p.load(reader);
        return p;
    }
    public ExtentReports extentReport(){
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("./src/test/Reports/ExtentReportResults.html");
        ExtentReports reports = new ExtentReports();
        reports.attachReporter(reporter);
        return reports;
    }
    @BeforeSuite
    public void beforesuit()throws Exception{


        this.prop=loadProperties();
        switch (prop.getProperty("browser")) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver",
                        prop.getProperty("chromepath"));
                break;
                default:
                    System.out.println("Please enter browser=chrome in properties file");
        }
         driver = new ChromeDriver();
         this.reports = extentReport();
        loginPage= PageFactory.initElements(driver, loginPage.class);
        homePage=PageFactory.initElements(driver,homePage.class);
        categoryMobilePage = PageFactory.initElements(driver,categoryMobilePage.class);
        productListPage = PageFactory.initElements(driver,productListPage.class);
        cartPage=PageFactory.initElements(driver,cartPage.class);
        orderPage =PageFactory.initElements(driver,orderPage.class);
    }

    @BeforeTest
    public void beforeTest(){
        driver.get("https://www.flipkart.com/");
    }

    @AfterSuite
    public void afterSuite(){
        driver.quit();
    }

}
