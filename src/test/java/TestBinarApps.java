
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class TestBinarApps {

    @Test
    public void FillingOutTheForm()
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://binarapps.com/");
        WebDriverWait wait = new WebDriverWait(driver, 5);

        openFormStep(driver);

        fillFormSteps(driver, wait);

        takeScreenShot(driver,"src/test/resources/test.png" );

        driver.quit();


    }

    private void fillFormSteps(WebDriver driver, WebDriverWait wait) {
        WebElement name = driver.findElement(By.id("dynamic_form_properties_193_475"));
        name.sendKeys("Noemi");
        WebElement surname = driver.findElement(By.id("dynamic_form_properties_193_476"));
        surname.sendKeys("Krysiak - Wolanska");
        WebElement email = driver.findElement(By.id("dynamic_form_properties_193_477"));
        email.sendKeys("noemi.krysiak@gmail.com");

        //It's not working yet
       /* String path = "C:\\Users\\noemi\\Pulpit\\cv\\PL_Noemi Krysiak-Wolanska_Cv_T";
        WebElement  uploadFileInput = driver.findElement(By.xpath("//*[@id=\"dynamic_form_properties_193\"]/div[4]/div[2]"));
        uploadFileInput.click();
        uploadFileInput.sendKeys(path);*/

        WebElement salary = driver.findElement(By.id("dynamic_form_properties_193_479"));
        salary.sendKeys("1500 zl");


        WebElement selectizeDropdownContent = driver.findElement(By.xpath("//*[@id=\"dynamic_form_properties_193\"]/div[6]/div[2]/div[1]"));
        selectizeDropdownContent.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement  contract = driver.findElement(By.xpath("//*[@id=\"dynamic_form_properties_193\"]/div[6]/div[2]/div[2]/div/div[2]"));
        contract.click();

        WebElement terminationOfTheContract = driver.findElement(By.id("dynamic_form_properties_193_481"));
        terminationOfTheContract.sendKeys("do 19.08.2021 mam umowe o prace a obecnie jestem na urlopi maierzynskim");

        WebElement student = driver.findElement(By.id("dynamic_form_properties_193_482"));
        student.sendKeys("nie");

        WebElement additionalQuestion = driver.findElement(By.id("dynamic_form_properties_194_474"));
        additionalQuestion.sendKeys("Facebook");

        WebElement mark1 = driver.findElement(By.xpath("//*[@id=\"dynamic_form_provisions\"]/div[1]/div/label/div"));
        mark1.click();
        WebElement mark2 = driver.findElement(By.xpath("//*[@id=\"dynamic_form_provisions\"]/div[2]/div/label/div/div"));
        mark2.click();
    }

    private void openFormStep(WebDriver driver) {
        WebElement careers = driver.findElement(By.id("menu-item-22"));
        careers.click();

        WebElement ourJobOffers = driver.findElement(By.xpath("//*[@id=\"carrers\"]/div/div/div[2]/a/div/div"));
        ourJobOffers.click();

        WebElement juniorSoftwareTester = driver.findElement(By.cssSelector("#our_offers > div > div:nth-child(4) > div:nth-child(3) > div"));
        juniorSoftwareTester.click();

        WebElement applyNow = driver.findElement(By.xpath("//*[@id=\"content_page\"]/main/aside/section[1]/a"));
        applyNow.click();
    }

    private void takeScreenShot(WebDriver driver, String fileWithPath){
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
