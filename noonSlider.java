import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class noonSlider {
static WebDriver driver;

public  static void printData(List<WebElement> productlocator, WebElement slider,WebDriver driver) {
	
	while(slider.isDisplayed()) {
			 
		productlocator.stream().map(s->s.getText()).sorted().forEach(s->System.out.println(s));
        slider.click();
	}	 
	
	}

public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "c:\\work\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://www.noon.com/uae-en/");
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//driver.manage().window().maximize();
JavascriptExecutor js = ( JavascriptExecutor) driver;
js.executeScript("window.scrollBy(0,500)" );
 

List<WebElement> productList1 ; 
List<WebElement> productList2;
List<WebElement> productList3;
 


 productList1 = driver.findElements(By.xpath("//div[@class='x16otr-0 esSWAj']/div[1]//div[@class='e3js0d-11 liZdac']"));
System.out.println(productList1.size()+ " products in list 1");
WebElement list1Button = driver.findElement(By.xpath("//div[@class='x16otr-0 esSWAj']/div[1]//div[@class='sc-GTWni GkeGT']/div[2]"));
 
printData(productList1,list1Button,driver);
  
Thread.sleep(1000);
js.executeScript("window.scrollBy(0,1500)" );
 
  productList2= driver.findElements(By.xpath("//div[@class='sc-1pz9vus-1 iGMThe']/div[5]/div[1]/div[2]//div[@class='sc-GTWni GkeGT']//div[@class='e3js0d-7 jULUCI']"));
  WebElement list2Button = driver.findElement(By.xpath("//div[@class='sc-1pz9vus-1 iGMThe']/div[5]/div[1]/div[2]//div[@class='sc-GTWni GkeGT']/div[2]"));
System.out.println(productList2.size()+" products in  list 2");
 
printData(productList2,list2Button,driver);
	Thread.sleep(1000);
	js.executeScript("window.scrollBy(0,500)" );

  productList3= driver.findElements(By.xpath("//div[@class='sc-1pz9vus-1 iGMThe']/div[5]/div[1]/div[3]//div[@class='sc-GTWni GkeGT']//div[@class='e3js0d-7 jULUCI']"));
WebElement list3Button =driver.findElement(By.xpath("//div[@class='sc-1pz9vus-1 iGMThe']/div[5]/div[1]/div[3]//div[@class='sc-GTWni GkeGT']/div[2]"));
  System.out.println(productList3.size()+" products in list 3");
 
  printData(productList3,list3Button,driver);

driver.close();
}

}
