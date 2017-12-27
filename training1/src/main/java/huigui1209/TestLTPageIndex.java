package huigui1209;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestLTPageIndex{
	@FindBy(linkText="[软件测试新手上路]")
	public WebElement forum_1_link;
//创建一个构造器，在构造器中，创建一个页面工厂	
public TestLTPageIndex(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
}

}
//在做自动化测试用例的时候，将所有的页面都可以写成一个个的类，每个页面里面的元素都相应写在每个页面的类里，重复的元素写成一个父类，有重复部分的元素，
//在用继承的方法，实际想用某个页面时，只需要new一下，就可以直接使用，不会把元素暴露出来。