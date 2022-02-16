import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameConcepts {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		var b=driver.findElement(By.xpath("//*[@class='demo-frame']"));
		driver.switchTo().frame(b);
		Actions MouseActions = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target= driver.findElement(By.id("droppable"));
		MouseActions.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[text()='Accept']")).click();
		
	}

}
