package CommonPage;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonFunction extends BasicPage {

	public commonFunction(WebDriver driver) {
		super(driver);
	}

	private long timeouts;

	// private int timeouts = 20;

	public void openUrl(String url) {
		driver.get(url);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	// driver.navigate().to("http://live.guru99.com/index.php/customer/account/");
	public void forwardToPage(String url) {
		driver.navigate().to(url);
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void click(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	// clickByJavaScript
	public void clickByJs(String locator) {
		WebElement account = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", account);
	}

	public String getText(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();

	}

	public void clear(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
	}

	public void input(String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}

//	Excercise2:
//  Select selectday = new Select(driver.findElement(By.xpath("//*[@id='day']")));
//	selectday.selectByVisibleText("14");
	public void selectCombobox(String locator, String value) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(value);
	}

//    String selectdate = selectday.getFirstSelectedOption().getText();
//    Assert.assertEquals("14", selectdate);
	public String getTextComboboxSelected(String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();
	}

	public String getAtribute(String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attribute);
	}

	public int getSizeList(String locator) {
		List<WebElement> list = driver.findElements(By.xpath(locator));
		return list.size();
	}

	public boolean isDisplayed(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isSelected(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isEnabled(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void inputAlert(String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

	public void switchWindowByTitle(String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindows : allWindows) {
			driver.switchTo().window(childWindows);
			String childTitle = driver.getTitle();
			if (childTitle.equals(title)) {
				break;
			}
		}
	}

	public String getWindow(WebDriver driver) {
		return driver.getWindowHandle();// lấy 1 window hiện tại
	}

//ex4
	public void switchToIframe(String locator) {
		WebElement iframeLookingfor = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(iframeLookingfor);
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

//	Excercise3 : WebElement hoverdanhmuc = driver.findElement(By.xpath("//li[@class='sbLi sbLix']//a[@href='#']"));
//	Actions action = new Actions(driver);
//	action.moveToElement(hoverdanhmuc).perform();

	public void hover(String locator) {
		WebElement hoverdanhmuc = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(hoverdanhmuc).perform();
	}

//	List<WebElement> listItems = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
//	Actions action = new Actions(driver);
//	action.clickAndHold(listItems.get(0)).clickAndHold(listItems.get(11)).click().perform();
//	action.release();

	public void clickAndHold(String locator, int itemFrom, int itemTarget) {
		List<WebElement> listItems = driver.findElements(By.xpath(locator));
		Actions action = new Actions(driver);
		action.clickAndHold(listItems.get(itemFrom)).clickAndHold(listItems.get(itemTarget)).click().perform();
		action.release();
	}

	// Ex3
	public void doubleClick(String locator) {
		WebElement btnDouble = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.doubleClick(btnDouble).perform();

	}

//Ex3
	public void rightClick(String locator) {
		WebElement rightBtn = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver).contextClick(rightBtn);
		action.build().perform();
	}

	public void dragAndDrop(String locatorFrom, String locatorTarget) {
		WebElement dragFrom = driver.findElement(By.xpath(locatorFrom));
		WebElement target = driver.findElement(By.xpath(locatorTarget));
		Actions action = new Actions(driver);
		Action dragAndDrop = action.clickAndHold(dragFrom).moveToElement(target).release(target).build();
		dragAndDrop.perform();
	}

	public void inputKeys(String locator, Keys key) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(key);
	}

	public void uploadBySendKeys(String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}

	public void uploadByRobot(String locator, String value) throws InterruptedException, Exception {
		StringSelection select = new StringSelection(value);
		WebElement btnBrowse = driver.findElement(By.xpath(locator));
		btnBrowse.click();
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		Robot robot = new Robot();
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void executeScriptBrowser(String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(javaScript);

	}

//	public Object executeScript(String locator) {
//
//	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}

	public void highlight(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style='border: 2px solid; border-color: red'", element);
	}

	public Object removeAttribute(String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
	}

	public void waitPresence(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}

	public void waitVisible(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

	public void waitAlertPresence(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.alertIsPresent());
	}

}