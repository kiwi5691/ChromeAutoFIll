import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Constant;
import utils.ValidUtils;
import utils.YearSwitch;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @auther kiwi
 * @Date 2019/8/1 16:05
 */
@SuppressWarnings("ALL")
public class RequestMain {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\webDriver\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("http://220.160.52.164:9085");


        driver.findElement(By.id("loginname")).sendKeys("内坑镇上方村");
        driver.findElement(By.id("loginpwd")).sendKeys("nk123456");

        driver.navigate().refresh();
        //点击按扭
        System.out.println("请输入验证码");
        Scanner sc=new Scanner(System.in);
        String code=sc.nextLine();
        driver.findElement(By.id("checkCode")).sendKeys(code);
        driver.findElement(By.id("login")).click();

        driver.get("http://220.160.52.164:9085");

        try {
            /**
             * WebDriver自带了一个智能等待的方法。
             dr.manage().timeouts().implicitlyWait(arg0, arg1）；
             Arg0：等待的时间长度，int 类型 ；
             Arg1：等待时间的单位 TimeUnit.SECONDS 一般用秒作为单位。
             */
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * dr.quit()和dr.close()都可以退出浏览器,简单的说一下两者的区别：第一个close，
         * 如果打开了多个页面是关不干净的，它只关闭当前的一个页面。第二个quit，
         * 是退出了所有Webdriver所有的窗口，退的非常干净，所以推荐使用quit最为一个case退出的方法。
         */
        //  driver.quit();//退出浏览器
    }
}

