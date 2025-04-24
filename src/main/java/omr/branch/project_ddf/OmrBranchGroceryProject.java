package omr.branch.project_ddf;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OmrBranchGroceryProject extends BaseClass {
	
	public void U0101() throws InterruptedException, IOException {
		//WebDriver driver=new ChromeDriver();
		browserLaunch();
		//driver.manage().window().maximize();
		maximizeWindow();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		impliciWait();
		JavascriptExecutor js=(JavascriptExecutor) driver;

		enterApplnUrl("https://www.omrbranch.com/");
		WebElement txtEmail = findLocatorById("email");
		elementSendKeys(txtEmail, getCellData("Login Details",1,0));

		
		WebElement txtPassword = findLocatorById("pass");
		elementSendKeys(txtPassword, getCellData("Login Details",1,1));

		WebElement btnLogin = findLocatorByXPath("//button[@type='submit'][@value='login']");
		elementClick(btnLogin);
	
		
		
		WebElement txtSearch = findLocatorById("search");
		//js.executeScript("arguments[0].setAttribute('value','Nuts')", txtSearch);
		elementSendKeysJs(txtSearch,"Nuts");
		WebElement btnSearchIcon = findLocatorByXPath("//button[@data-testid='searchbtn']");
		clickByJs(btnSearchIcon);
		
		
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement searchResult = findLocatorByXPath("//div[@class='container']//following::h5[@class='sectionTitle font35 font-weight-bold color11']");
		//WebElement searchResult =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='container']//following::h5[@class='sectionTitle font35 font-weight-bold color11']")));
		String searchText = searchResult.getText();
		System.out.println(searchText);
		
		List<WebElement> productDetails = driver.findElements(By.xpath("//h5[@class='productName font18 color26 mb-1 fontsemibold text-center mt-3']"));
		int size = productDetails.size();
		List<WebElement> priceDetails = driver.findElements(By.xpath("//p[@class='price']"));
		for (int i = 0; i < size; i++) {
			
			String prodcutText = productDetails.get(i).getText();
			System.out.println(prodcutText);
			String priceText = priceDetails.get(i).getText();
			System.out.println(priceText);
		}
		
		WebElement btnAdd = findLocatorByXPath("//a[@class='hover1 font16 fontsemibold colorWhite bgTheme px-4 py-1 radius50 dyna_btn addBtn-17']");
		clickByJs(btnAdd);
		
		WebElement subAdd = findLocatorByXPath("//button[@id='cart-22']");
		js.executeScript("arguments[0].click();", subAdd);
		
		Thread.sleep(5000);
		WebElement goToGart = findLocatorByXPath("//a[@class='hover1']");
		js.executeScript("arguments[0].click();", goToGart);
		
		WebElement deliveryAddress = findLocatorByXPath("//div[@class='diffAddres addAddress d-flex justify-content-center align-items-center mb-md-0 mb-2']");
		clickByJs(deliveryAddress);
		
		WebElement ddnAddressType = findLocatorByXPath("//select[@id='address_type']");
		
		selectOptionByText(ddnAddressType, getCellData("Address Details", 1, 0));
		
		WebElement txtFirstName = findLocatorByXPath("//input[@name='first_name'][@placeholder='First name*']");
		elementSendKeys(txtFirstName, getCellData("Address Details",1,1));

		WebElement txtLastName = findLocatorByXPath("//input[@name='last_name'][@placeholder='Last name*']");
		elementSendKeys(txtLastName, getCellData("Address Details",1,2));

		WebElement txtContactNo = findLocatorByXPath("//input[@placeholder='Contact No*']");
		elementSendKeys(txtContactNo, getCellData("Address Details",1,3));

		WebElement txtHouseNo = findLocatorByXPath("//input[@placeholder='House No*']");
		elementSendKeys(txtHouseNo, getCellData("Address Details",1,4));

		WebElement txtAddress = findLocatorByXPath("//input[@placeholder='Address*']");
		elementSendKeys(txtAddress, getCellData("Address Details",1,5));
		
		WebElement ddnCountry =findLocatorByXPath("//select[@name='country']");
			
		selectOptionByText(ddnCountry, getCellData("Address Details", 1, 6));
		
		WebElement ddnSelectState = findLocatorByXPath("//select[@name='state']");
		selectOptionByText(ddnSelectState, getCellData("Address Details", 1, 7));

		WebElement ddnSelectCity = findLocatorByXPath("//select[@name='city']");
		selectOptionByText(ddnSelectCity, getCellData("Address Details", 1, 8));

		WebElement txtZipCode = findLocatorByXPath("//input[@name='zipcode']");
		elementSendKeys(txtZipCode, getCellData("Address Details",1,9));

		WebElement btnSave = findLocatorByXPath("//button[@type='submit'][@class='saveAddress font18 fontSemiBold colorWhite bgTheme radius50 borderNone px-5 py-2 hover1']");
		elementClick(btnSave);
		
		/*
		 * WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(60));
		 * wait1.until(ExpectedConditions.elementToBeSelected(ddnPaymentMethod));
		 */
		//WebElement payMethodForm = driver.findElement(By.xpath("//form[@id='form_validate']"));
		//js.executeScript("arguments[0].scrollIntoView(true);", payMethodForm);
		Thread.sleep(2000);
		WebElement ddnpaymentMethod = findLocatorByXPath("//select[@id='payment_type']");
	
		//js.executeScript("location.reload()");
		//WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(50));
		//wait5.until(ExpectedConditions.visibilityOf(ddnpaymentMethod));
	//	js.executeScript("arguments[0].scrollIntoView(true);", ddnpaymentMethod);
		selectOptionByText(ddnpaymentMethod, getCellData("Address Details",1, 10));
		
		Thread.sleep(2000);
		WebElement rdoVisa = findLocatorByXPath("//input[@id='visa_card']");
		/*
		 * try { visibilityOfElement(rdoVisa); }catch(TimeoutException e) {
		 * System.out.println("error in "+e.getMessage()); }
		 */
		clickByJs(rdoVisa);
		WebElement txtCardNumber = findLocatorByXPath("//input[@placeholder='Card Number']");
		elementSendKeys(txtCardNumber, getCellData("Address Details",1,11));


		
		WebElement ddnMonth = findLocatorByXPath("//select[@id='month']");
//		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(50));
//		wait6.until(ExpectedConditions.visibilityOf(ddnMonth));
		selectOptionByText(ddnMonth, getCellData("Address Details", 1, 12));



		WebElement ddnYear = findLocatorByXPath("//select[@id='year']");
		selectOptionByText(ddnYear, getCellData("Address Details", 1, 13));

		
		WebElement txtCvv = findLocatorByXPath("//input[@placeholder='CVV'][@name='cvv']");
		elementSendKeys(txtCvv, getCellData("Address Details", 1, 14));

		WebElement btnPlaceOrder = findLocatorByXPath("//button[@id='placeOrder']");
		elementClick(btnPlaceOrder);
		
			
		
		
		
		WebElement txtEmail1 = findLocatorById("email");

		elementSendKeys(txtEmail1, getCellData("Login Details",1,0));
		WebElement txtPassword1 = findLocatorById("pass");

		elementSendKeys(txtPassword1, getCellData("Login Details",1,1));
		WebElement btnLogin1 = findLocatorByXPath("//button[@type='submit'][@value='login']");

		elementClick(btnLogin1);
		
		
		WebElement btnBellIcon = findLocatorByXPath("//i[@class='fa fa-bell']");
		elementClick(btnBellIcon);
		
		
		
		WebElement orderPlacedMessage = findLocatorByXPath("(//div[@class='d-flex align-items-center notiHead justify-content-between'])[1]");
		String elementGetText = elementGetText(orderPlacedMessage);
		System.out.println(elementGetText);
		//System.out.println(ordermsg);
		
		/*
		 * WebElement
		 * orderedTime=findLocatorByXPath("(//p[@class='font16 color36 mb-2'])[1]");
		 * String time = orderedTime.getText(); System.out.println(time);
		 */
		WebElement orderNumber = findLocatorByXPath("(//p[@class='font18 color36 mb-0'])[1]");
		String elementGetText2 = elementGetText(orderNumber);
		System.out.println(elementGetText2);
		//createCellAndSetData("Address Details", 1, 15, elementGetText2);
		String[] split = elementGetText2.split(" ");
		
		String empty="";
		for (int i = 0; i < split.length; i++) {
			empty = split[11];
			
		}
		System.out.println(empty);
		createCellAndSetData("Address Details", 1, 15, empty);

		
		


	}
		
		
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
	
		OmrBranchGroceryProject project=new OmrBranchGroceryProject();
		project.U0101();
	}

}
