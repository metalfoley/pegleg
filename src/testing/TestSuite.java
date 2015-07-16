package testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import controller.PirateEditTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	PirateArrayListTest.class,
	CurrencyTest.class,
	ServletTest.class,
	DbConnTest.class,
	WebServiceTest.class,
	PirateEditTest.class,
	PirateTest.class})
public class TestSuite {

}
