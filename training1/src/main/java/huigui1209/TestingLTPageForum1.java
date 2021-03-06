package huigui1209;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestingLTPageForum1 {
	@FindBy(xpath="//table[@id='threadlisttableid']/tbody[contains(@id,'normalthread_')]")
	public List<WebElement> threads;
	public void clickTopic(int index) {
		threads.get(index-1).findElement(By.xpath("tr/th/a[3]")).click();
		
	}
	
	public TestingLTPageForum1(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

}
