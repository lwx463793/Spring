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
//传参数的方式	
//第一种在xml里面@Parameters({"username","password"})
//第二种在方法里面@Test(dataProvider="auth")
//第三种在类里面实现
@Test(dataProvider="auth",dataProviderClass=DataProvideFactory.class)
public void testp(String u,String p) {
	System.out.println("username"+u+","+"password"+p);
	
}
}
