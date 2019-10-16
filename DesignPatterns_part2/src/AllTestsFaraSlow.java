import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({ TestAddNota.class, TestGetNota.class, TestMedieAritmetica.class,
		TestNotaFrecventaMaxima.class })
@ExcludeCategory(SlowTest.class)
public class AllTestsFaraSlow {

}
