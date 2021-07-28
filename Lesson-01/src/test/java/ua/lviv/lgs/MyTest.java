package ua.lviv.lgs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class MyTest {
	
	private MyTest mytest;
	
	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("FAILED -> "+ description.getMethodName());
		};
		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("SUCCED -> "+ description.getMethodName());
		};
	};
	
	@Before
	public void beforeTest() {
		mytest = new MyTest();
	}
	
	@After
	public void afterTest() {
		mytest = null;
	}
	
	@Test
	public void SeanceTest() {
		Time o = new Time(21,50);
		Time real = Seance.add(new Time(1,20) , new Time(20,30));
		Time expected = o;
		int expectedhour = expected.hour;
		int expectedmin = expected.min;
		int realhour = real.hour;
		int realmin = real.min;
		Assert.assertEquals(expectedmin, realmin);
		Assert.assertEquals(expectedhour, realhour);
		
	}
}
