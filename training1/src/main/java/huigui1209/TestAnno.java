package huigui1209;

public class TestAnno implements ITestAnno{
    @Override
	@RunTime(count=10)
public void sayHi() {
	System.out.println("Hi");
}
}
