import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMedieAritmetica {

	static Student student;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMedieAritmeticaRight1() throws Exception{
		student = new Student("Neagu Corina");
		student.addNota(5);
		student.addNota(4);
		student.addNota(10);
		student.addNota(7);
		student.addNota(2);
		student.addNota(7);
		float expected = 7.25f;
		student.medieAritmetica();
		float actual = student.getMedie();
		assertEquals("Mediile sunt egale.", expected, actual, 0.001);
	}

	@Test
	public void testMedieAritmeticaRight2() throws Exception{
		student = new Student("Neagu Corina");
		student.addNota(8);
		float expected = 8;
		student.medieAritmetica();
		float actual = student.getMedie();
		assertEquals("Mediile sunt egale.", expected, actual, 0.0001);
	}
	
	@Test
	public void testMedieAritmeticaRight3() throws Exception{
		student = new Student("Neagu Corina");
		student.addNota(4);
		student.addNota(6);
		float expected = 6;
		student.medieAritmetica();
		float actual = student.getMedie();
		assertEquals("Mediile sunt egale.", expected, actual, 0.0001);
	}
	
	@Test
	public void testMedieAritmeticaException() throws ExceptionMedieNull{
		student = new Student("Neagu Corina");
		float expected = 0;
		float actual = 0;
		try {
			student.addNota(4);
			student.addNota(2);
			student.medieAritmetica();
			assertTrue(false);
			actual = student.getMedie();
		} catch (ExceptionMedieNull e) {
			System.out.println("Media nu se poate calcula deoarece nu exista note care sa respecte conditia!");
			e.printStackTrace();
			assertTrue(true);
		} catch (Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
		assertEquals("Mediile sunt egale.", expected, actual, 0.0001);
	}
	
	@Test
	public void testMedieAritmeticaExtreme1() throws ExceptionMedieNull{
		student = new Student("Neagu Corina");
		float expected = 0;
		float actual = 0;
		try {
			student.addNota(4);
			student.medieAritmetica();
			assertTrue(false);
			actual = student.getMedie();
		} catch (ExceptionMedieNull e) {
			System.out.println("Nu se poate calcula media - extreme1!");
			e.printStackTrace();
			assertTrue(true);
		} catch (Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	
		assertEquals("Mediile sunt egale.", expected, actual, 0.0001);
	}
	
	@Test
	public void testMedieAritmeticaExtreme2() throws ExceptionMedieNull{
		student = new Student("Neagu Corina");
		float expected = 5;
		float actual = 0;
		try {
			student.addNota(5);
			student.medieAritmetica();
			actual = student.getMedie();
		} catch (ExceptionMedieNull e) {
			System.out.println("Nu se poate calcula media - extreme2!");
			e.printStackTrace();
			assertTrue(false);
		} catch (Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
		assertEquals("Mediile nu sunt egale.", expected, actual, 0.0001);
	}
	
	@Test
	public void testMedieAritmeticaPerformance1() throws ExceptionMedieNull{
		student = new Student("Neagu Corina");
		try {
			student.addNota(5);
			student.addNota(2);
			student.addNota(6);
			student.addNota(10);
			student.medieAritmetica();
			long timp1 = System.currentTimeMillis();
			student.addNota(9);
			student.addNota(8);
			student.addNota(7);
			student.addNota(6);
			student.medieAritmetica();
			long timp2 = System.currentTimeMillis();
			if((timp2 - timp1) > 0.2)
				assertTrue(false);
			else 
				assertTrue(true);
		} catch (ExceptionMedieNull e) {
			e.printStackTrace();
			assertTrue(false);
		} catch (Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	@Test
	public void testMedieAritmeticaPerformance2() throws ExceptionMedieNull{
		student = new Student("Neagu Corina");
		try {
			student.addNota(5);
			student.addNota(2);
			student.addNota(6);
			student.addNota(10);
			student.medieAritmetica();
			long timp1 = System.currentTimeMillis();
			student.addNota(2);
			student.addNota(3);
			student.addNota(1);
			student.addNota(2);
			student.medieAritmetica();
			long timp2 = System.currentTimeMillis();
			if((timp2 - timp1) > 0.01)
				assertTrue(false);
			else 
				assertTrue(true);
		} catch (ExceptionMedieNull e) {
			e.printStackTrace();
			assertTrue(false);
		} catch (Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
