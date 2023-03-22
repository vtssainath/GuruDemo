package testcase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.ExcelFileUtil;

public class demoLogin {

	public static WebDriver driver;
	
	public static void main(String[] args) throws Throwable
	{	
		String inputpath ="c:\\Users\\tejas\\eclipse-workspace\\guru99Demo\\FileInput\\guru99.xlsx";
		String datasheet = "Demo";
		//FileInputStream fi = new FileInputStream(inputpath);
		//Workbook wb = new XSSFWorkbook(fi);
		//Workbook wb = new WorkbookFactory().create(fi);
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(xl.getCellData(datasheet, 0, 1));
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(xl.getCellData(datasheet, 1, 1));
		driver.findElement(By.name("password")).sendKeys(xl.getCellData(datasheet, 2, 1));
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Log out']")).click();

	}

}
