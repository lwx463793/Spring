package training1;




import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;
//���ܲ��ԣ�������50 ���û���
public class PerformanceTest {
	@Test(invocationCount=50,threadPoolSize=50)
	public void push51Testing() {
		URL url = null;
		try {
			long start = System.currentTimeMillis();
			url = new URL("http://bbs.51testing.com");
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			http.setDoInput(true);
			int code = http.getResponseCode();
			InputStream is = http.getInputStream();
			long end = System.currentTimeMillis();
			System.out.println("code:"+code+", time: "+(end-start));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
