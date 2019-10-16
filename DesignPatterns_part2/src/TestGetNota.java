import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TestGetNota {

	static Student student;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		student = new Student("Neagu Corina");
		student.addNota(5);
		student.addNota(8);
		student.addNota(10);
		student.addNota(7);
		student.addNota(7);
		student.addNota(7);
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
	public void testGetNotaRight1() {
		int expected  = 5;
		int actual = 0;
		try {
			actual = student.getNota(0);
		} catch (ExceptionLipsaElement e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Valoarea este aceeasi.", expected, actual);
	}

	@Test
	public void testGetNotaRight2() {
		int expected  = 10;
		int actual = 0;
		try {
			actual = student.getNota(2);
		} catch (ExceptionLipsaElement e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Valoarea este aceeasi.", expected, actual);
	}
	
	@Test
	public void testGetNotaRight3() {
		int expected  = 7;
		int actual = 0;
		try {
			actual = student.getNota(4);
		} catch (ExceptionLipsaElement e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Valoarea este aceeasi.", expected, actual);
	}
	
	@Test
	public void testGetNotaException() {
		try{
			int nota = student.getNota(7);
			assertTrue(false);
		}catch(ExceptionLipsaElement e){
			e.printStackTrace();
			assertTrue(true);
		}catch(Exception ex){
			ex.printStackTrace();
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetNotaExtreme1() {
		try{
			int nota = student.getNota(-1);
			assertTrue(false);
		}catch(ExceptionLipsaElement e){
			System.out.println("Nu exista valoare la indexul precizat.");
			e.printStackTrace();
			assertTrue(true);
		}catch(Exception ex){
			ex.printStackTrace();
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetNotaExtreme2() {
		try{
			int nota = student.getNota(0);
			assertTrue(true);
		}catch(ExceptionLipsaElement e){
			e.printStackTrace();
			assertTrue(false);
		}catch(Exception ex){
			ex.printStackTrace();
			assertTrue(false);
		}
	}
	
	@Test
	@Category(SlowTest.class)
	public void testGetNotaExtreme3() {
		try{
			int nota = student.getNota(student.getNote().size()-1);
			assertTrue(true);
		}catch(ExceptionLipsaElement e){
			e.printStackTrace();
			assertTrue(false);
		}catch(Exception ex){
			ex.printStackTrace();
			assertTrue(false);
		}
	}
	
	@Test
	@Category(SlowTest.class)
	public void testGetNotaExtreme4() {
		try{
			int nota = student.getNota(student.getNote().size());
			assertTrue(false);
		}catch(ExceptionLipsaElement e){
			e.printStackTrace();
			assertTrue(true);
		}catch(Exception ex){
			ex.printStackTrace();
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetNotaPerformance1() {
		try{
			
			long timp1 = System.currentTimeMillis();
			int nota = student.getNota(2);
		    long timp2 = System.currentTimeMillis();
		    if((timp2-timp1) < 2)
		    	assertTrue(true);
		    else assertTrue(false);
		}catch(ExceptionLipsaElement e){
			e.printStackTrace();
			assertTrue(true);
		}catch(Exception ex){
			ex.printStackTrace();
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetNotaPerformance2() {
		try{
			student.addNota(5);
			student.addNota(8);
			student.addNota(10);
			student.addNota(7);
			student.addNota(7);
			student.addNota(7);
			
			long timp1 = System.currentTimeMillis();
			int nota = student.getNota(10);
		    long timp2 = System.currentTimeMillis();
		    if((timp2-timp1) < 4)
		    	assertTrue(true);
		    else assertTrue(false);
		}catch(ExceptionLipsaElement e){
			e.printStackTrace();
			assertTrue(true);
		}catch(Exception ex){
			ex.printStackTrace();
			assertTrue(false);
		}
	}
	
	
}
