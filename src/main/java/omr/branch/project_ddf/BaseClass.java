package omr.branch.project_ddf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	WebDriver driver;
	Select select;
	JavascriptExecutor js;
	Alert alert;
	Actions action;
	TakesScreenshot ts;
	

	//30 31 doubt 35

	public void createCellAndSetData(String sheetName, int rownum, int cellnum, String data) throws IOException {
		File file = new File("C:\\Users\\janani\\eclipse-workspace\\GroceryProject_SeleniumProject01\\Excel\\OmrDetails.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);

	}

	public void updateCellData(String sheetName, int rownum, int cellnum, String oldData, String newData)
			throws IOException {

		File file = new File("C:\\Users\\janani\\eclipse-workspace\\GroceryProject_SeleniumProject01\\Excel\\OmrDetails.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();

		if (value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
	}

	public String getCellData(String sheetName, int rownum, int cellnum) throws IOException {
		String res = null;

		File file = new File("C:\\Users\\janani\\eclipse-workspace\\GroceryProject_SeleniumProject01\\Excel\\OmrDetails.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType type = cell.getCellType();
		switch (type) {
		case STRING:
			res = cell.getStringCellValue();

			break;
		case NUMERIC:

			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
				res = dateFormat.format(dateCellValue);
			} else {

				double numericCellValue = cell.getNumericCellValue();
				long round = Math.round(numericCellValue);
				if (round == numericCellValue) {
					res = String.valueOf(round);

				} else {
					res = String.valueOf(numericCellValue);

				}
			}
			break;

		default:
			break;
		}
		return res;
	}
	//1
	public void browserLaunch() {
		driver = new ChromeDriver();
	}
	//2
	public void LaunchFireFox() {
		driver = new FirefoxDriver();

	}
	//3
	public void LaunchEdge() {
		driver = new EdgeDriver();

	}
	//5

	public void enterApplnUrl(String url) {
		driver.get(url);
	}
	//6
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	//7
	
	public void elementSendKeys(WebElement element, String data) {
		visibilityOfElement(element);

		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.sendKeys(data);
		}
	}
	
	
	
	//8
	public void elementClick(WebElement element) {
		visibilityOfElement(element);

		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.click();
		}
	}
	//9
	public void ClickOk() {
		 alert = driver.switchTo().alert();
		alert.accept();
	}
	//10
	public void ClickDismiss() {
		 alert = driver.switchTo().alert();
		alert.dismiss();
	}
	//prompt
	
	public void promptAlert(String text) {
		alert = driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();

	}
	
	//11
	public String elementGetText(WebElement element) {
		visibilityOfElement(element);
		String text = null;
		if (elementIsDisplayed(element)) {
			text = element.getText();
		}
		return text;
	}
	//12
	// 99%--->value is fixed
			public String elementGetAttributeValue(WebElement element) {
				visibilityOfElement(element);
				String domProperty = null;
				if (elementIsDisplayed(element)) {
					domProperty = element.getDomProperty("value");
				}
				return domProperty;
			}

			// %--->?
			public String elementGetAttributeValue(WebElement element, String attributeName) {
				visibilityOfElement(element);
				String domProperty = null;

				if (elementIsDisplayed(element)) {
					domProperty = element.getDomProperty(attributeName);
				}
				return domProperty;
			}
			//13
			public void closeWindow() {
				driver.close();
			}
			//14
	public String getApplnTitle() {
		String title = driver.getTitle();
		return title;
	}
	//15
	public String getApplnUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	//16
	public void selectOptionByText(WebElement element, String text) {
		visibilityOfElement(element);
		select = new Select(element);
		select.selectByVisibleText(text);
	}


	
	//17
	public void selectOptionByIndex(WebElement element, int index) {
		visibilityOfElement(element);
		select = new Select(element);
		select.selectByIndex(index);

	}
	//18
	public void selectOptionByValue(WebElement element, String text) {
		visibilityOfElement(element);
		select = new Select(element);
		select.selectByValue(text);
	}
	//19
	public void elementSendKeysJs(WebElement element, String data) {

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}
	//20

	public void switchToChildWindow() {
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();

		for (String eachWindowId : windowHandles) {
			if (!eachWindowId.equals(windowHandle)) {
				driver.switchTo().window(eachWindowId);
			}

		}
	}
	//21
	public void frameByIndex(int num) {
		driver.switchTo().frame(num);
	}
	//22
	public void frameByname(String name) {
		driver.switchTo().frame(name);
	}
	//23

	public void clickByJs(WebElement element) {

		 js=(JavascriptExecutor)driver;

		js.executeScript("arguments[0].click();", element);}
	
	
	//24
	public void frameByWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}
	//25
	public WebElement findLocatorById(String attributeValue) {

		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}
	//26
	public WebElement findLocatorByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}
	//27

	public WebElement findLocatorByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}
	//28
	public WebElement findLocatorByXPath(String exp) {
		WebElement element = driver.findElement(By.xpath(exp));
		return element;
	}
	//29
	public List<String> getAllOptionsText(WebElement element) {
		select = new Select(element);
		List<WebElement> options = select.getOptions();

		List<String> allOptionsText = new ArrayList<String>();

		for (WebElement webElement : options) {
			String text = webElement.getText();
			allOptionsText.add(text);

		}
		return allOptionsText;
	}
	
	
	//31 doubt
	public WebElement firstSelectedOption(WebElement element) {
		 select=new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		return firstSelectedOption;
		
	}
	
	//32
	public boolean isMultiSelect(WebElement element) {
		 select=new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
		
	}
	//33
	
	public void impliciWait(int secs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}

	public void impliciWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
	}
	
	//34
	public void visibilityOfElement(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void clickableOfElement(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(90));
		driverWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//35
	/*
	 * public void fluentWait(int secs1,int secs2,WebElement element) {
	 * visibilityOfElement(element); FluentWait<WebDriver> wait = new
	 * FluentWait<WebDriver>(driver) .withTimeout(Duration.ofSeconds(20))
	 * .pollingEvery(Duration.ofSeconds(2)) .ignoring(NoSuchElementException.class);
	 * wait.until(ExpectedConditions.visibilityOf(element));
	 */

	//36
	
	public boolean elementIsDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}
	//37

	public boolean elementIsEnabled(WebElement element) {
		boolean displayed = element.isEnabled();
		return displayed;
	}
	//38
	public boolean elementIsSelected(WebElement element) {
		boolean displayed = element.isSelected();
		return displayed;
	}
	//39

	public void deSelectOptopnByIndex(WebElement element, int no) {
		 select=new Select(element);
		select.deselectByIndex(no);
	}
	//40
	
	
	
	public void deSelectOptopnByText(WebElement element, String text) {
		select=new Select(element);
		select.deselectByVisibleText(text);
	}
	//41
	public void deSelectOptopnByValue(WebElement element, String name) {
		 select=new Select(element);
		select.deselectByValue(name);
	}
	
	//42
	public void deSelectAll(WebElement element) {
		 select=new Select(element);
		select.deselectAll();
	}
	//43
	
	public void elementCLearTextBox(WebElement element) {
		visibilityOfElement(element);
		element.clear();
	}
	
	//44
	public void ts(File file) throws IOException {
		 ts=(TakesScreenshot) driver;
		File screen=ts.getScreenshotAs(OutputType.FILE);
		File f=new File("a.png");
		FileHandler.copy(screen, f);
			
		}
	//45
		public void particularFieldTs(File file,WebElement element) throws IOException {
			 ts=(TakesScreenshot) driver;
			File screen=element.getScreenshotAs(OutputType.FILE);
			File f=new File("a.png");
			FileHandler.copy(screen, f);
				
			}
	public void quitWindow() {
		driver.quit();
	}
	//46
	public void mouseOverSingleOptions(WebElement element) {
		 action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	//47
	public void dragAndDrop(WebElement src,WebElement dest) {
		action=new Actions(driver);
		action.dragAndDrop(src, dest).perform();
	}
	//48
	public void rightClick(WebElement element) {
		 action=new Actions(driver);
		action.contextClick(element).perform();
		

	}
	//49
	public void doubleClick(WebElement element) {
		 action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	//50
	public void elementSendKeysEnter(WebElement element, String data) {
		visibilityOfElement(element);
		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.sendKeys(data, Keys.ENTER);
		}
	}
	//51
	public void navigationForward() {
		driver.navigate().forward();
	}
	
	public void navigationBackward() {
		driver.navigate().back();
	}
	
	public void navigationRefresh() {
		driver.navigate().refresh();
	}
	
	public void navigateTo(String url) {
		driver.navigate().to(url);
	}
	//52
		
	public void scrollUp(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	//52.1
	
}
