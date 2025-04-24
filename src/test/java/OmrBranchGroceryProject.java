import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OmrBranchGroceryProject {
	
	public void U0101() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));

		driver.get("https://www.omrbranch.com/");
		WebElement txtEmail = driver.findElement(By.id("email"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','jananirj1794@gmail.com')", txtEmail);
		
		WebElement txtPassword = driver.findElement(By.id("pass"));
		js.executeScript("arguments[0].setAttribute('value','Jansakaar94@')", txtPassword);

		WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit'][@value='login']"));
		js.executeScript("arguments[0].click()", btnLogin);
		WebElement welcomeUserName = driver.findElement(By.xpath("//a[@data-testid='username']"));
		String userName = welcomeUserName.getText();
		System.out.println(userName);
		
		
		WebElement txtSearch = driver.findElement(By.id("search"));
		js.executeScript("arguments[0].setAttribute('value','Nuts')", txtSearch);
		
		WebElement btnSearchIcon = driver.findElement(By.xpath("//button[@data-testid='searchbtn']"));
		js.executeScript("arguments[0].click()", btnSearchIcon);
		
		
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement searchResult = driver.findElement(By.xpath("//div[@class='container']//following::h5[@class='sectionTitle font35 font-weight-bold color11']"));
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
		
		WebElement btnAdd = driver.findElement(By.xpath("//a[@class='hover1 font16 fontsemibold colorWhite bgTheme px-4 py-1 radius50 dyna_btn addBtn-17']"));
		js.executeScript("arguments[0].click();", btnAdd);
		
		WebElement subAdd = driver.findElement(By.xpath("//button[@id='cart-22']"));
		js.executeScript("arguments[0].click();", subAdd);
		
		Thread.sleep(5000);
		WebElement goToGart = driver.findElement(By.xpath("//a[@class='hover1']"));
		js.executeScript("arguments[0].click();", goToGart);
		
		WebElement deliveryAddress = driver.findElement(By.xpath("//div[@class='diffAddres addAddress d-flex justify-content-center align-items-center mb-md-0 mb-2']"));
		js.executeScript("arguments[0].click();", deliveryAddress);
		
		WebElement ddnAddressType = driver.findElement(By.xpath("//select[@id='address_type']"));
		
		Select select=new Select(ddnAddressType);
		select.selectByIndex(3);
		
		WebElement txtFirstName = driver.findElement(By.xpath("//input[@name='first_name'][@placeholder='First name*']"));
		js.executeScript("arguments[0].setAttribute('value','Janani')", txtFirstName);

		WebElement txtLastName = driver.findElement(By.xpath("//input[@name='last_name'][@placeholder='Last name*']"));
		js.executeScript("arguments[0].setAttribute('value','Sakthi')", txtLastName);

		WebElement txtContactNo = driver.findElement(By.xpath("//input[@placeholder='Contact No*']"));
		js.executeScript("arguments[0].setAttribute('value','9159353234')", txtContactNo);

		
		WebElement txtHouseNo = driver.findElement(By.xpath("//input[@placeholder='House No*']"));
		js.executeScript("arguments[0].setAttribute('value','B-104 Kg Fortune')", txtHouseNo);

		WebElement txtAddress = driver.findElement(By.xpath("//input[@placeholder='Address*']"));
		js.executeScript("arguments[0].setAttribute('value','Nookapalyam Road,Perumbakkam')", txtAddress);
		Thread.sleep(6000);
		WebElement ddnCountry = driver.findElement(By.xpath("//select[@name='country']"));
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(80));
		/*
		 * Wait<WebDriver> w=new FluentWait<>(driver)
		 * .withTimeout(Duration.ofSeconds(90)) .pollingEvery(Duration.ofSeconds(5))
		 * .ignoring(Throwable.class);
		 * w.until(ExpectedConditions.elementToBeSelected(ddnCountry));
		 */
		//wait.until(ExpectedConditions.elementToBeSelected(ddnCountry));
		
		
		Select selectddnCountry=new Select(ddnCountry);
		Thread.sleep(1000);

		selectddnCountry.selectByIndex(1);
		
		WebElement ddnSelectState = driver.findElement(By.xpath("//select[@name='state']"));
		Select selectddnSelectState=new Select(ddnSelectState);
		selectddnSelectState.selectByValue("35");
		WebElement ddnSelectCity = driver.findElement(By.xpath("//select[@name='city']"));
		Select selectddnSelectCity=new Select(ddnSelectCity);
		selectddnSelectCity.selectByValue("4215");
		WebElement txtZipCode = driver.findElement(By.xpath("//input[@name='zipcode']"));
		js.executeScript("arguments[0].setAttribute('value','600100')", txtZipCode);

		WebElement btnSave = driver.findElement(By.xpath("//button[@type='submit'][@class='saveAddress font18 fontSemiBold colorWhite bgTheme radius50 borderNone px-5 py-2 hover1']"));
		js.executeScript("arguments[0].click();", btnSave);
		
		/*
		 * WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(60));
		 * wait1.until(ExpectedConditions.elementToBeSelected(ddnPaymentMethod));
		 */
		//WebElement payMethodForm = driver.findElement(By.xpath("//form[@id='form_validate']"));
		//js.executeScript("arguments[0].scrollIntoView(true);", payMethodForm);
		Thread.sleep(6000);
		WebElement ddnpaymentMethod = driver.findElement(By.xpath("//select[@id='payment_type']"));
		Select selectPaymentMethod=new Select(ddnpaymentMethod);
		//js.executeScript("location.reload()");
		//WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(50));
		//wait5.until(ExpectedConditions.visibilityOf(ddnpaymentMethod));
		js.executeScript("arguments[0].scrollIntoView(true);", ddnpaymentMethod);

		selectPaymentMethod.selectByValue("debit_card");
		
		Thread.sleep(4000);
		
		WebElement rdoVisa = driver.findElement(By.xpath("//input[@id='visa_card']"));
		js.executeScript("arguments[0].click();",rdoVisa);

		WebElement txtCardNumber = driver.findElement(By.xpath("//input[@placeholder='Card Number']"));
		js.executeScript("arguments[0].setAttribute('value','5555555555552222')", txtCardNumber);

		
		WebElement ddnMonth = driver.findElement(By.xpath("//select[@id='month']"));
//		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(50));
//		wait6.until(ExpectedConditions.visibilityOf(ddnMonth));
		Select selectddnMonth=new Select(ddnMonth);



		selectddnMonth.selectByValue("February");
		WebElement ddnYear = driver.findElement(By.xpath("//select[@id='year']"));
		Select selectddnYear=new Select(ddnYear);
		selectddnYear.selectByValue("2028");
		WebElement txtCvv = driver.findElement(By.xpath("//input[@placeholder='CVV']"));
		js.executeScript("arguments[0].setAttribute('value','1994')", txtCvv);

		WebElement btnPlaceOrder = driver.findElement(By.xpath("//button[@id='placeOrder']"));
		js.executeScript("arguments[0].click();", btnPlaceOrder);
		
		
		WebElement txtEmail1 = driver.findElement(By.id("email"));
		js.executeScript("arguments[0].setAttribute('value','jananirj1794@gmail.com')", txtEmail1);
		
		WebElement txtPassword1 = driver.findElement(By.id("pass"));
		js.executeScript("arguments[0].setAttribute('value','Jansakaar94@')", txtPassword1);

		WebElement btnLogin1 = driver.findElement(By.xpath("//button[@type='submit'][@value='login']"));
		js.executeScript("arguments[0].click()", btnLogin1);
		
		
		WebElement btnBellIcon = driver.findElement(By.xpath("//i[@class='fa fa-bell']"));
		js.executeScript("arguments[0].click()", btnBellIcon);
		
		
		
		WebElement orderPlacedMessage = driver.findElement(By.xpath("(//div[@class='d-flex align-items-center notiHead justify-content-between'])[1]"));
		String ordermsg = orderPlacedMessage.getText();
		System.out.println(ordermsg);
		
		WebElement orderedTime=driver.findElement(By.xpath("(//p[@class='font16 color36 mb-2'])[1]"));
		String time = orderedTime.getText();
		System.out.println(time);
		
		WebElement orderNumber = driver.findElement(By.xpath("(//p[@class='font18 color36 mb-0'])[1]"));
		String oderNo = orderNumber.getText();
		System.out.println(oderNo);
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
	
		OmrBranchGroceryProject project=new OmrBranchGroceryProject();
		project.U0101();
	}

}
