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
public class Login {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\webDriver\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("http://220.160.52.164:9085");

        driver.findElement(By.id("loginname")).sendKeys("内坑镇上方村");
        driver.findElement(By.id("loginpwd")).sendKeys("nk123456");

        //点击按扭
        System.out.println("请输入验证码");
        Scanner sc=new Scanner(System.in);
        String code=sc.nextLine();
        driver.findElement(By.id("checkCode")).sendKeys(code);
        driver.findElement(By.id("login")).click();

        driver.findElement(By.xpath("//span[text()=\"房屋登记\"]")).click();
        driver.findElement(By.xpath("//span[text()=\"登记管理\"]")).click();
        //点击frame
        driver.findElement(By.xpath("//*[@id=\"mainFrameBody\"]/div/div[2]/ul/li[2]/span")).click();
        //定位frame，辣鸡玩意找了我2个小时的bug
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"mainFrameBody\"]/div/div[2]/div/div[2]/iframe")));

        //TODO
        System.out.println("请输入关键字");
        String key=sc.nextLine();
        String TrueKey = Constant.keyValue+key+Constant.prefix;

        driver.findElement(By.xpath("//*[@id=\"keywords\"]")).sendKeys(TrueKey);
        driver.findElement(By.xpath("//*[@id=\"infoform\"]/div/input[5]")).click();

        //回到默认frame再重新回去
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[@id=\"mainFrameBody\"]/div/div[2]/ul/li[2]/span")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"mainFrameBody\"]/div/div[2]/div/div[2]/iframe")));
        //layui牛皮

        //进入编辑，默认第一个
        driver.findElement(By.xpath("//*[@id=\"grid\"]/tbody/tr[1]/td[2]/div/a")).click();

        //需要加入
        System.out.print("姓名:");
        String name=sc.nextLine();
        System.out.print("电话:");
        String tel=sc.nextLine();
        System.out.print("年份:");
        String year=sc.nextLine();
        System.out.print("地上:");
        String upLand=sc.nextLine();
        System.out.print("面积:");
        String squre = sc.nextLine();
        System.out.print("是否改造（改造请按a）（其他按键未改造）:");
        String check = sc.nextLine();
        System.out.print("排查人:");
        String paiName = sc.nextLine();
        System.out.print("排查日期:");
        String paiTime = sc.nextLine();
        //开始默认处理
        //房屋类别
        driver.findElement(By.xpath("//*[@id=\"fwlb\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"fwlb\"]/option[3]")).click();
        //土地类型
        driver.findElement(By.xpath("//*[@id=\"ydxz\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ydxz\"]/option[3]")).click();

        //姓名
        driver.findElement(By.xpath("//*[@id=\"hzxm\"]")).sendKeys(name);
        //电话
        driver.findElement(By.xpath("//*[@id=\"hzdh\"]")).sendKeys(ValidUtils.vaild(tel));

        //建成年份
        driver.findElement(By.xpath("//*[@id=\"jznf\"]")).click();
        driver.findElement(By.xpath(YearSwitch.yearIndexChanger(year))).click();

        //地上
        driver.findElement(By.xpath("//*[@id=\"dscs\"]")).sendKeys(upLand);
        driver.findElement(By.xpath("//*[@id=\"dxcs\"]")).sendKeys("0");

        //建筑面积
        driver.findElement(By.xpath("//*[@id=\"jzmj\"]")).sendKeys(squre);
        driver.findElement(By.xpath("//*[@id=\"jclx\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"jclx\"]/option[5]")).click();
        driver.findElement(By.xpath("//*[@id=\"jclxms\"]")).sendKeys("无");
        //设计情况
        driver.findElement(By.xpath("//*[@id=\"sjqk\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"sjqk\"]/option[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"ywsgct\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ywsgct\"]/option[3]")).click();

        //改造情况，逻辑分支
        if(check=="a") {
            driver.findElement(By.xpath("//*[@id=\"gzqk\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"gzqk\"]/option[3]")).click();
            driver.findElement(By.xpath("//*[@id=\"gzsjStr1\"]")).click();
            //默认2015
            driver.findElement(By.xpath("//*[@id=\"gzsjStr1\"]/option[23]")).click();
            driver.findElement(By.xpath("//*[@id=\"pcgznr1\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"pcgznr1\"]/option[2]")).click();
        }
        else {
            driver.findElement(By.xpath("//*[@id=\"gzqk\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"gzqk\"]/option[2]")).click();

        }
        //用途
        driver.findElement(By.xpath("//*[@id=\"syyt\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"syyt\"]/option[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"jglx\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"jglx\"]/option[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"pcjl\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"pcjl\"]/option[2]")).click();

        driver.findElement(By.xpath("//*[@id=\"djry\"]")).sendKeys(paiName);
        driver.findElement(By.xpath("//*[@id=\"pcsj\"]")).sendKeys(paiTime);
        driver.findElement(By.xpath("//*[@id=\"pcdw\"]")).sendKeys(Constant.PaiUnit);
        driver.findElement(By.xpath("//*[@id=\"pcdwlxdh\"]")).sendKeys(Constant.PaiTel);

        WebElement webElement = driver.findElement(By.cssSelector("body"));
        webElement.click(); // 有的时候必须点击一下，下拉才能生效（有的网站是这样，原因未找到）
        webElement.sendKeys(Keys.END);
        //传送文件,测试文件
        driver.findElement(By.xpath("//*[@id=\"rt_rt_1dh70l2ja1s8qs6d1bi46ht1sgp7\"]/label")).sendKeys("C:\\Users\\ASUS\\Desktop\\work_dektop_pic\\微信图片_20190801214331 - 副本.jpg");


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

