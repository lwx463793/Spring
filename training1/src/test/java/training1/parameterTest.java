package training1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class parameterTest {	
	
	@DataProvider(name="auth")

public Object[][] getAuthData(){
	return new Object[][] {
		{"liumei","123456"},
		{"liuermei","098765"},
		{"huhhu","9466338"}
	};
	
}
//�������ķ�ʽ	
//��һ����xml����@Parameters({"username","password"})
//�ڶ����ڷ�������@Test(dataProvider="auth")
//��������������ʵ��
@Test(dataProvider="auth",dataProviderClass=DataProvideFactory.class)
public void testp(String u,String p) {
	System.out.println("username"+u+","+"password"+p);
	
}
}
