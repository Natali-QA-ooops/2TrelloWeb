package TestsTrello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
    WebDriver wd;

    @BeforeMethod
    public void preCond(){
        wd=new ChromeDriver();
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
    }

    @Test
    public void testLogin(){
        WebElement signup = wd.findElement(By.cssSelector("[href='/login']"));
        signup.click();
        WebElement email=wd.findElement(By.cssSelector("#user"));
        type(email, "natali.zaitseva2021@gmail.com");
        WebElement login=wd.findElement(By.cssSelector("[id='login']"));
        login.click();
        WebElement pass = wd.findElement(By.cssSelector("#password"));
        type(pass, "natali.zaitseva2021@gmail.com");
        WebElement submit = wd.findElement(By.cssSelector("#login-submit"));
        submit.click();
    }



    @Test

    public void loginTest1(){
        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("#user"), "natali.zaitseva2021@gmail.com");
        click(By.cssSelector("#login"));
        click(By.cssSelector(".dlMUdg"));//нажимает на глаз пароля
        type(By.cssSelector("#password"), "Tt12345&");
        click(By.cssSelector("#login-submit"));
    }

    public boolean isLogged(){
        return wd.findElements(By.cssSelector("._2ft40Nx3NZII2i")).size()>0;
    }

    public void logout(){
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
        click(By.cssSelector("[id='logout-submit']"));
    }


    public void loginTest(){
        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("#user"), "natali.zaitseva2021@gmail.com");
        click(By.cssSelector("#login"));
        type(By.cssSelector("#password"), "Tt12345&");
        click(By.cssSelector("#login-submit"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    private void type(WebElement email, String myEmail) {
        email.click();
        email.clear();
        email.sendKeys(myEmail);
    }

    @AfterMethod
    public void postCond(){
        wd.close();
        wd.quit();
    }

}
