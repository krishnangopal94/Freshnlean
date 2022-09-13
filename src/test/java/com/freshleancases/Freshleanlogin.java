package com.freshleancases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import com.freshlean.Baseclass;
import com.freshlean.Freshleanmealpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Freshleanlogin {

	public static WebDriver driver;

	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setAcceptInsecureCerts(true);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--allow-running-insecure-content");
		options.merge(caps);
		driver = new ChromeDriver(options);
		driver.get("https://dashboard-tychons.herokuapp.com/");
		WebElement popup = driver
				.findElement(By.xpath("//button[@class='needsclick klaviyo-close-form kl-private-reset-css-Xuajs1']"));
		popup.click();
        WebElement name = driver.findElement(By.xpath("(//input[@name='email'])[1]"));
		name.sendKeys("reneedebevoise63992828@tychons.com");
		WebElement password = driver.findElement(By.xpath("(//input[@name='password'])[1]"));
		password.sendKeys("Tychons@123");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement login = driver.findElement(By.xpath("//button[text()='LOGIN']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", login);


	}

}
