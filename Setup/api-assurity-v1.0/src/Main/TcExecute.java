package Main;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TcExecute {

	String TCFilepath = "C:\\Users\\bgopani\\workspace\\api-assurity-v1.0\\src\\TestcaseSheet\\TestCaseSheetV1.0.xlsx";
	String TCTagname = "TestCycle1";

	@BeforeMethod
	public void beforeMethod() throws Exception {
		System.out.println("TestCase sheet name is " + TCTagname);
	}

	@Test
	public void test() throws Exception {
		TCExecuteLogic.execute(TCFilepath, TCTagname);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("We have added test results in Test Case sheet");
	}
}
