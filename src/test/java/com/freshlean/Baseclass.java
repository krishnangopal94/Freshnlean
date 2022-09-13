package com.freshlean;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import java.io.IOException;

import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;
	public static Select select;

	// 1.launch chrome
	public static void browserchrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	// 2.load url
	public static void loadurl(String url) {
		driver.get(url);

	}

	// 3.maximize the window
	public static void winmax() {
		driver.manage().window().maximize();

	}

	// 4.print title
	public static void printtitle() {
		System.out.println(driver.getTitle());

	}

	// 5.print currenturl
	public static void currenturl() {
		System.out.println(driver.getCurrentUrl());
	}

	// 6.send keys
	public static void fill(WebElement elem, String value) {
		elem.sendKeys(value);
	}

	// 7.click method
	public static void buttnclick(WebElement elem) {
		elem.click();
	}

	// 8.close the tab
	public static void closechrome() {
		driver.close();
	}

	// 9.quit the browser
	public static void quitechrome() {
		driver.quit();
	}

	public static Actions a;

	// 11 Move to Element in Actions
	public static void moveElementTo(WebElement ele) {
		a = new Actions(driver);
		a.moveToElement(ele).perform();
	}

	// 13 Key Down Actions
	public static void keyKickDown(WebElement eleTarget, CharSequence key) {
		a = new Actions(driver);
		a.keyUp(eleTarget, key).perform();
	}

	// 14 Key Up Actions
	public static void keyKickUp(WebElement eleTarget, CharSequence key) {
		a = new Actions(driver);
		a.keyDown(eleTarget, key).perform();
	}

	// 15 Click Actions
	public static void actionsClick() {
		a = new Actions(driver);
		a.click().perform();
	}

	// 16 Send Keys In Actions
	public static void actionsSend(WebElement target, CharSequence keys) {
		a = new Actions(driver);
		a.sendKeys(target, keys).perform();
	}

	// 17 DoubleClick Actions
	public static void doubleLeftClick(WebElement target) {
		a = new Actions(driver);
		a.doubleClick(target).perform();
	}

	// 18 Context Click Actions
	public static void rightClick(WebElement target) {
		a = new Actions(driver);
		a.contextClick(target).perform();
	}

	// 19 Alert Simple Alert Accept
	public static void alertOK() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	// 20 Alert Confirm Alert Reject
	public static void alertCancel() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	// 21 Alert Prompt Alert SendKeys
	public static void alertFill(String SendKeys) {
		Alert a = driver.switchTo().alert();
		System.out.println(a.getText());
		a.sendKeys(SendKeys);
	}

	// 22 ScreenShot
	public static void screenshot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dsc = new File("C:filepath" + name + ".png");
		FileUtils.copyFile(src, dsc);
	}

	// 23 java Script pass Value
	public static void jsFill(String SendKeys, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + SendKeys + "')", ele);

	}

	// 24 jsclick
	public static void jsClick(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele);
	}

	// 25 jsScroll Top
	public static void jsScrollTop(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
	}

	// 26 jsScroll Bottom
	public static void jsScrollFoot(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", ele);
	}

	// 27 Enter Key Using Robot class
	public static Robot r;

	public static void roboEnter() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	// up using robot class
	public static void roboup() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}

	// 28 Down Using Robot class
	public static void roboDown() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	// 29 Copy using Robot class
	public static void roboCopy() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);

		r.keyRelease(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}

	// 30 Paste Using Robot Class
	public static void roboPaste() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);

		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}

	// 31 Tab Using Robot class
	public static void roboTap() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}

	// 32 Cut Using Robot Class
	public static void roboCut() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);

		r.keyRelease(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}

	// 34.to find date and time
	public static void date() {
		Date d = new Date();
		System.out.println(d);

	}

	// 35 single DropDown Visible
	public static void VisibleText(WebElement ele, String value) {
		select = new Select(ele);
		select.selectByVisibleText(value);

	}

	// 35 single DropDown value

	public static void selectValue(WebElement ele, String value) {
		select = new Select(ele);
		select.selectByValue(value);

	}

	// 35 single dropdown Index
	public static void Index(WebElement ele, int index) {
		select = new Select(ele);
		select.selectByIndex(index);
	}

}
