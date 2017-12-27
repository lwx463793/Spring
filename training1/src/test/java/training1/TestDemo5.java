package training1;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class TestDemo5 {
	@Test
	public void testfunc1() {
		//断言相等，1！=2时，执行失败，1=2时，执行成功
		assertEquals(1, 2);
	}
	@Test
	public void testfunc2() {
		
		assertEquals(1, 1);
	}

}
