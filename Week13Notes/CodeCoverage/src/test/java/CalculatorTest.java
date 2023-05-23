import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
	
	static Calculator calc;
	
	@BeforeClass //this runs only once, when the class is instantiated
	public static void createCalculator() {
		calc = new Calculator("Super Calc");
	}
	
	@Test
	public void noArgsConstructor() {
		Calculator noArgsCalc = new Calculator();
		assertTrue(noArgsCalc.getName() == null);
	}

	@Test
	public void additionOverflow() {
		assertEquals(Integer.MAX_VALUE, calc.add(Integer.MAX_VALUE, 1));
	}
	
	@Test
	public void regularAddition() {
		assertEquals(5, calc.add(2, 3));
	}
	
	@Test
	public void subtractionUnderflow() {
		assertEquals(Integer.MIN_VALUE, calc.subtract(Integer.MIN_VALUE, 1));
	}
	
	@AfterClass
	public static void destroyCalculator() {
		calc = null;
	}
}
