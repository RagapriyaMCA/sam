package BaseClass;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void browserLaunch(String value) {
		if (value.equalsIgnoreCase("chrome")) {
			ChromeOptions chrome = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chrome);
			driver.manage().window().maximize();
		} 
		else if (value.equalsIgnoreCase("firefox")) {
			FirefoxOptions firefox=new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver(firefox);
			driver.manage().window().maximize();

		}
	}
	public static void getUrl(String url) {
		driver.get(url);
	}
	public static void getTitle() {
		driver.getTitle();
	}
	public static void close() {
		driver.close();
	}
	public static void sendKey(WebElement element,String value) {
		element.sendKeys(value);
	}
	public static void quit() {
		driver.quit();
	}
	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}
	public static void navigateBack() {
		driver.navigate().back();
	}
	public static void navigateForward() {
		driver.navigate().forward();
	}
	public static void refresh() {
		driver.navigate().refresh();
	}
	public static void click(WebElement element) {
		element.click();
	}
	public static void clear(WebElement element) {
		element.clear();
	}
	public static boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
		
	}
	public static boolean isEnabled(WebElement element) {
		return element.isEnabled();
		
	}
	public static boolean isSelected(WebElement element) {
		return element.isSelected();
	}
	public static void getText(WebElement element) {
		element.getText();
	}
	public static void moveToElement(WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).build().perform();
	}
	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions ac = new Actions(driver);
		ac.dragAndDrop(source, target).build().perform();
	}
	public static void simpleAlert() {
		driver.switchTo().alert().accept();
	}
	public static void doubleClick(WebElement element) {
		Actions ac = new Actions(driver);
		ac.doubleClick(element).build().perform();
	}
	public static void switchtoIframe(String options, Object value) {
		if (options.equalsIgnoreCase("index")) {
			driver.switchTo().frame(Integer.parseInt((String) value));
		} else if (options.equalsIgnoreCase("name")) {
			driver.switchTo().frame((String) value);
		} else if (options.equalsIgnoreCase("element")) {
			driver.switchTo().frame((WebElement) value);
		}
	}
	public static void switchtoDefaultContent() {
		driver.switchTo().defaultContent();
	}
	public static void firstSelectedoption(WebElement element) {
		Select s = new Select(element);
		s.getFirstSelectedOption();
		
	}
	public static void allSelectedOption(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options=s.getAllSelectedOptions();
		for(WebElement option:options) {
			System.out.println(option);
		}
	}
	public static void confirmAlert(String alert) {
		if(alert.equalsIgnoreCase("confirmAlertAccept")){
			driver.switchTo().alert().accept();
		}else if(alert.equalsIgnoreCase("confirmAlertDismiss")){
			driver.switchTo().alert().dismiss();
		}
		}
	public static void screenShot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\HP\\New_workspace\\Interview\\practice\\ScreenShot\\" + name + ".png");
		FileHandler.copy(source, destination);
	}
	public static void dropDown(WebElement element,String value,String input) {
		Select s=new Select(element);
		if(value.equalsIgnoreCase("text")){
			s.selectByVisibleText(input);
		}else if(value.equalsIgnoreCase("value")){
			s.selectByValue(input);
		}else if(value.equalsIgnoreCase("index")) {
			int parseInt=Integer.parseInt(input);
			s.selectByIndex(parseInt);
		}
		
	}
	

}
