package huigui1209;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestLTPageIndex{
	@FindBy(linkText="[�������������·]")
	public WebElement forum_1_link;
//����һ�����������ڹ������У�����һ��ҳ�湤��	
public TestLTPageIndex(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
}

}
//�����Զ�������������ʱ�򣬽����е�ҳ�涼����д��һ�������࣬ÿ��ҳ�������Ԫ�ض���Ӧд��ÿ��ҳ�������ظ���Ԫ��д��һ�����࣬���ظ����ֵ�Ԫ�أ�
//���ü̳еķ�����ʵ������ĳ��ҳ��ʱ��ֻ��Ҫnewһ�£��Ϳ���ֱ��ʹ�ã������Ԫ�ر�¶������