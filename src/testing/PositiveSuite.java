package testing;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@IncludeCategory(PositiveTestsCategory.class)
@Suite.SuiteClasses({
	PirateArrayListTest.class,
	CurrencyTest.class,
	ServletTest.class,
	PirateTest.class})
public class PositiveSuite {

}
