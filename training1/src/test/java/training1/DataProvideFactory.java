package training1;

import org.testng.annotations.DataProvider;
//��������ʵ�ֲ��������ṩ
public class DataProvideFactory {
	@DataProvider(name="auth")
	public static  Object[][] getAuthData(){
		return new Object[][] {
			{"liumei","123456"},
			{"liuermei","098765"},
			{"huhhu","9466338"}
		};
}
}