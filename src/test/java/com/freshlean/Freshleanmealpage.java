package com.freshlean;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Freshleanmealpage extends Baseclass {

	public Freshleanmealpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//a[@data-cy='meal-select-btn'])[1]")
	WebElement selectbtn;

	@FindBy(xpath = "(//button[@class='py-1 rounded-sm min-w-full uppercase font-[14px] bg-preheader btn--primary'])[1]")
	WebElement addbtn;

	@FindBy(xpath = "//button[@data-cy='breakfasts']")
	WebElement breakfastbtn;

	@FindBy(xpath = "//button[@data-cy='add']")
	WebElement addbreakfastbtn;

	@FindBy(xpath = "//a[@data-cy='plan-link']")
	WebElement viewplans;

	@FindBy(xpath = "(//button[text()='Confirm Meal Selections'])[1]")
	WebElement confirmbtn;

	public WebElement getConfirmbtn() {
		return confirmbtn;
	}

	public void setConfirmbtn(WebElement confirmbtn) {
		this.confirmbtn = confirmbtn;
	}

	public WebElement getViewplans() {
		return viewplans;
	}

	public void setViewplans(WebElement viewplans) {
		this.viewplans = viewplans;
	}

	public WebElement getSelectbtn() {
		return selectbtn;
	}

	public void setSelectbtn(WebElement selectbtn) {
		this.selectbtn = selectbtn;
	}

	public WebElement getAddbtn() {
		return addbtn;
	}

	public void setAddbtn(WebElement addbtn) {
		this.addbtn = addbtn;
	}

	public WebElement getBreakfastbtn() {
		return breakfastbtn;
	}

	public void setBreakfastbtn(WebElement breakfastbtn) {
		this.breakfastbtn = breakfastbtn;
	}

	public WebElement getAddbreakfastbtn() {
		return addbreakfastbtn;
	}

	public void setAddbreakfastbtn(WebElement addbreakfastbtn) {
		this.addbreakfastbtn = addbreakfastbtn;
	}

	public void loopentree() throws InterruptedException {
		for (int i = 0; i < 9; i++) {
			driver.findElement(By.xpath("//button[@data-cy='increment']")).click();

			Thread.sleep(1000);

		}

	}

	public void loopbreakfast() throws InterruptedException {
		for (int i = 0; i < 4; i++) {
			driver.findElement(By.xpath("(//button[@data-cy='increment'])[2]")).click();
			Thread.sleep(1000);

		}

	}

//	public void viewplans() {
//		WebElement view = driver.findElement(By.xpath("//a[@data-cy='plan-link']"));
//		JavascriptExecutor plans = (JavascriptExecutor) driver;
//		plans.executeScript("arguments[0].click()", view);
//
//	}

	public void Freshleanmealselection() throws InterruptedException {
		Freshleanmealpage freshleanselectmeal = new Freshleanmealpage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-cy='plan-link']")));
		WebElement viewplans = driver.findElement(By.xpath("//a[@data-cy='plan-link']"));
		viewplans.click();
		try {
			driver.findElement(By.xpath("(//a[text()='Select Meals'])[1]")).click();

		} catch (Exception e) {
			driver.findElement(By.xpath("(//a[text()='Select Meals'])[2]")).click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		freshleanselectmeal.getAddbtn().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		freshleanselectmeal.loopentree();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		freshleanselectmeal.getBreakfastbtn().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		freshleanselectmeal.getAddbreakfastbtn().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		freshleanselectmeal.loopbreakfast();
//		freshleanselectmeal.getConfirmbtn().click();
//		WebElement result = driver.findElement(By.xpath("//p[@data-cy='success']"));
//		String results = result.getText();
//		System.out.println("Result is : " + results);

	}

}
