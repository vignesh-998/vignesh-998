package org.base;

import java.awt.AWTException;
import java.awt.Robot;                             
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver driver;
private static int keycode;

 public static WebDriver chromeBrowser() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	return driver;
	}
 public static WebDriver browserLaunch(String browsername) {
	if(browsername.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	else if(browsername.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	else if(browsername.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	return driver;
}
// public static WebDriver browsername(String browsername) {
//	switch(browsername) {
//	
//	case "chrome":
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		break;
//	case "edge":
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
//		break;
//	case "firefox":
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
//		break;
//		default:
//      System.out.println("Invalid Browser");
//	}
//	return driver;
//}
 public static void urlLaunch(String url) {
	 driver.get(url);
     driver.manage().window().maximize();     
}
 public static void implicitWait(int sec) {
	driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
}
 public static String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
}
public static String title() {
		String title = driver.getTitle();
		return title;
}
 //webElement methods
 public static void sendKeys(WebElement e,String value) {
	e.sendKeys(value);
}
 public static String getText(WebElement e) {
	String text = e.getText();
	return text;
}
 public static String getAttribute(WebElement e) {
	String attribute = e.getAttribute("value");
	return attribute;
}
 public static void click(WebElement e) {
		e.click();
}	
 public static boolean isDisplayed(WebElement e) {
	return e.isDisplayed();
}
 public static boolean isEnabled(WebElement e) {
	return e.isEnabled();
}
 public static boolean isSelected(WebElement e) {
	return e.isSelected();
}
 //Actions --- class methods
 public static void movetoelement(WebElement target) {
	Actions a = new Actions(driver);
	a.moveToElement(target).perform();
}
 public static void draganddrop(WebElement source,WebElement destination) {
	 Actions a = new Actions(driver);
	 a.dragAndDrop(source, destination).perform();
}
 public static void contextclick(WebElement target) {
	 Actions a = new Actions(driver);
	 a.contextClick(target).perform();
	 a.contextClick().perform();
}
 public static void doubleclick(WebElement target) {
	 Actions a = new Actions(driver);
	 a.doubleClick(target).perform();
	 a.doubleClick().perform();
}
 public static void clickandhold(WebElement target) {
	 Actions a = new Actions(driver);
	 a.clickAndHold(target).perform();
	 a.clickAndHold().perform();
}
 public static void release(WebElement target) {
	 Actions a = new Actions(driver);
	 a.release(target).perform();
     a.release().perform();
}
 //Robot class method
 public static int keypress() throws AWTException {
	Robot r = new Robot();
	r.keyPress(keycode);
	return keycode;
}
 public static int keyRelease() throws AWTException {
		Robot r = new Robot();
		r.keyRelease(keycode);
		return keycode;
	}
 //Alert ---class method
 public static String simpleAlert() {
	Alert sa = driver.switchTo().alert();
	sa.accept();
	return sa.getText();
}
 public static String confirmAlert() {
	Alert ca = driver.switchTo().alert();
    ca.accept();
    ca.dismiss();
    return ca.getText();
}
 public static String promptAlert(String value) {
	 Alert pa = driver.switchTo().alert();
	 pa.accept();
	 pa.dismiss();
	 pa.sendKeys(value);
	 return pa.getText();
}
 //Navigation commands
 public static void to(String url) {
	driver.navigate().to(url);
}
 public static void back() {
	driver.navigate().back();
}
 public static void forward() {
	driver.navigate().forward();
}
 public static void refresh() {
	driver.navigate().refresh();
}
 public static void quit() {
	driver.quit();	
}
 //Drop down methods
 public static void selectByIndex(WebElement element,int index) {
	Select s = new Select(element);
	s.selectByIndex(index);
}
 public static void selectByValue(WebElement element,String Value) {
	 Select s = new Select(element);
	 s.selectByValue(Value);
}
 public static void selectByVisibleText(WebElement element,String Value) {
	 Select s = new Select(element);
	 s.selectByVisibleText(Value);
}
 public static List<WebElement> getOptions(WebElement element) {
	 Select s = new Select(element);
	 List<WebElement> options = s.getOptions();
	 return options;
}
 public static List<WebElement> getAllSelectedOptions(WebElement element) {
	 Select s = new Select(element);
	 List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
	 return allSelectedOptions;
}
 public static WebElement getFirstSelectedOptions(WebElement element) {
	 Select s = new Select(element);
	 WebElement firstSelectedOption = s.getFirstSelectedOption();
	 return firstSelectedOption;
}
 public static boolean isMultiple(WebElement element) {
	 Select s = new Select(element);
	 boolean multiple = s.isMultiple();
	 return multiple;
}
 public static void deselectByIndex(WebElement element,int index) {
		Select s = new Select(element);
		s.deselectByIndex(index);
}
 public static void deselectByValue(WebElement element,String Value) {
	 Select s = new Select(element);
	 s.deselectByValue(Value);
}
 public static void deselectByVisibleText(WebElement element,String Value) {
	 Select s = new Select(element);
	 s.deselectByVisibleText(Value);
}
 public static void deselectAll(WebElement element) {
	 Select s = new Select(element);
	 s.deselectAll();
}
 //Screenshot
 public static void takescreenshot(String filename) throws IOException {
	TakesScreenshot tk = (TakesScreenshot)driver;
	File src = tk.getScreenshotAs(OutputType.FILE);
	File des = new File("/MavenProject/src/test/resources"+filename+".png");
	FileUtils.copyFile(src, des);
}
 //Frame
 public static void switchintoframe(int index) {
	driver.switchTo().frame(index);
}
 public static void defaultContent() {
	driver.switchTo().defaultContent();
}
 public static void parentFrame() {
	driver.switchTo().parentFrame();
}
 //Window handling
 public static void windowUrl(String url) {
	driver.switchTo().window(url);
}
 public static void windowTitle(String title) {
	driver.switchTo().window(title);
}
 public static String windowId() {
	return driver.getWindowHandle();
}
 public static Set<String> allWindowId() {
	return driver.getWindowHandles();
}
 public static String readExcel(String excelname,String sheet,int rowno,int cellno) throws IOException {
   File f = new File("/MavenProject/src/test/resources"+excelname+".xlsx");
   FileInputStream fi = new FileInputStream(f);			
   Workbook w = new XSSFWorkbook(fi);			
   Sheet sh = w.getSheet(sheet);		
   Row row = sh.getRow(rowno);		
   Cell cell = row.getCell(cellno);
   int cellType = cell.getCellType();
   String value = null;   
   if(cellType==1) {
	   value = cell.getStringCellValue();
  	 }
   else {                  
  	 if(DateUtil.isCellDateFormatted(cell)) { 
  		 Date d = cell.getDateCellValue();
  		 SimpleDateFormat sd = new SimpleDateFormat();
         value = sd.format(d);
  		 }
  	 else {
  		 double nv = cell.getNumericCellValue();
  		 long l = (long)nv;
  		 value = String.valueOf(l);
  		  }
   }
return value;
 }

 public static void writeExcel(String excelname1,String sheetname,int rowno, int cellno, String cellvalue) throws IOException {
	 File f = new File("/MavenProject/src/test/resources"+excelname1+".xlsx");
	 Workbook w = new XSSFWorkbook();
	 Sheet sh = w.createSheet(sheetname);
	sh.createRow(rowno);
	sh.getRow(rowno).createCell(cellno).setCellValue(cellvalue);
	 Row r = sh.createRow(rowno); 
	 Cell c = r.createCell(cellno);
	 c.setCellValue(cellvalue);
	 FileOutputStream fo = new FileOutputStream(f); 
	 w.write(fo);	 
}
 
public static void excelOverWrite(String excelname,String sheetname,int rowno,int cellno,String cellvalue) throws IOException {
	 File f = new File("/MavenProject/src/test/resources"+excelname+".xlsx");
	 FileInputStream fi = new FileInputStream(f);
	 
	 Workbook w = new XSSFWorkbook(fi);
		Sheet sh = w.getSheet(sheetname);
		  
		Row r = sh.getRow(rowno);
		Cell c = r.getCell(cellno);
		if(c.getStringCellValue().equals(cellvalue)) {
			Cell c1 = r.createCell(0);
			c1.setCellValue(cellvalue);
		}
		
		FileOutputStream fo = new FileOutputStream(f);
		w.write(fo);
}

 public static void close() {
	driver.close();

}
}