package testing;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@IncludeCategory(NegativeTestsCategory.class)
@Suite.SuiteClasses({
	PirateArrayListTest.class,
	ServletTest.class,
	CurrencyTest.class,
	WebServiceTest.class,
	PirateTest.class})
public class NegativeSuite {

}