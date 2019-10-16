import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TestNotaFrecventaMaxima {
	
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
	public void testNotaFrecventaMaximaRight1()  {
		student = new Student("Manolescu Paul");
		int expected = 0;
		int actual = 0;
		try {
			student.addNota(2);
			student.addNota(5);
			student.addNota(7);
			student.addNota(6);
			student.addNota(6);
			student.addNota(8);
			expected = 6;
			actual = student.notaFrecventaMaxima();
		} catch (ExceptionNullValues e) {
			e.printStackTrace();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		assertEquals("Nu este corecta nota cu frecventa maxima!", expected, actual);
	}

	@Test
	public void testNotaFrecventaMaximaRight2()  {
		student = new Student("Manolescu Paul");
		int expected = 0;
		int actual = 0;
		try {
			student.addNota(10);
			student.addNota(5);
			student.addNota(7);
			student.addNota(6);
			student.addNota(9);
			student.addNota(8);
			expected = 10;
			actual = student.notaFrecventaMaxima();
		} catch (ExceptionNullValues e) {
			e.printStackTrace();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		assertEquals("Nu este corecta nota cu frecventa maxima!", expected, actual);
	}
	
	@Test
	public void testNotaFrecventaMaximaRight3()  {
		student = new Student("Manolescu Paul");
		int expected = 0;
		int actual = 0;
		try {
			student.addNota(3);
			student.addNota(1);
			student.addNota(3);
			student.addNota(4);
			student.addNota(9);
			student.addNota(3);
			expected = 3;
			actual = student.notaFrecventaMaxima();
		} catch (ExceptionNullValues e) {
			e.printStackTrace();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		assertEquals("Nu este corecta nota cu frecventa maxima!", expected, actual);
	}
	
	@Test
	public void testNotaFrecventaCrossCheck1()  {
		student = new Student("Manolescu Paul");
		int expected = 0;
		int actual = 0;
		try {
			student.addNota(3);
			student.addNota(1);
			student.addNota(3);
			student.addNota(4);
			student.addNota(9);
			student.addNota(3);
			expected = student.notaFrecventaMaxima();
			actual = student.notaFrecventaMaxima1();
		} catch (ExceptionNullValues e) {
			e.printStackTrace();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		assertEquals("Nu este corecta nota cu frecventa maxima!", expected, actual);
	}
	
	@Test
	@Category(SlowTest.class)
	public void testNotaFrecventaCrossCheck2()  {
		student = new Student("Manolescu Paul");
		int expected = 0;
		int actual = 0;
		try {
			student.addNota(2);
			student.addNota(5);
			student.addNota(7);
			student.addNota(6);
			student.addNota(6);
			student.addNota(8);
			expected = student.notaFrecventaMaxima();
			actual = student.notaFrecventaMaxima1();
		} catch (ExceptionNullValues e) {
			e.printStackTrace();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		assertEquals("Nu este corecta nota cu frecventa maxima!", expected, actual);
	}
	
	@Test
	@Category(SlowTest.class)
	public void testNotaFrecventaCrossCheck3()  {
		student = new Student("Manolescu Paul");
		int expected = 0;
		int actual = 0;
		try {
			student.addNota(10);
			student.addNota(5);
			student.addNota(7);
			student.addNota(6);
			student.addNota(9);
			student.addNota(8);
			expected = student.notaFrecventaMaxima();
			actual = student.notaFrecventaMaxima1();
		} catch (ExceptionNullValues e) {
			e.printStackTrace();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		assertEquals("Nu este corecta nota cu frecventa maxima!", expected, actual);
	}
	
	@Test
	public void testNotaFrecventaInverse()  {
		student = new Student("Manolescu Paul");
		int expected = 0;
		int actual = 0;
		try {
			student.addNota(2);
			student.addNota(5);
			student.addNota(7);
			student.addNota(6);
			student.addNota(6);
			student.addNota(8);
			expected = 6;
			actual = student.notaFrecventaMaxima();
			
		} catch (ExceptionNullValues e) {
			e.printStackTrace();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		
		for(int i=1 ; i<=10;i++){
			if(i!=expected){
				if(i!=actual){
					assertTrue(true);
				}else{
					assertTrue(false);
				}
			} else{
				assertTrue(true);
			}
		}
	}
	
	@Test
	public void testNotaFrecventaException()  {
		student = new Student("Manolescu Paul");
		int expected = 0;
		int actual = 0;
		try {
			actual = student.notaFrecventaMaxima();
			assertTrue(false);
		} catch (ExceptionNullValues e) {
			System.out.println("Lista nu contine nicio nota!");
			e.printStackTrace();
			assertTrue(true);
		} catch (Exception ex){
			ex.printStackTrace();
			assertTrue(false);
		}
		assertEquals("Nu este corecta nota cu frecventa maxima!", expected, actual);
	}
	
	@Test
	public void testNotaFrecventaPerformance()  {
		student = new Student("Manolescu Paul");
		int expected = 0;
		int actual = 0;
		try {
			student.addNota(2);
			student.addNota(5);
			student.addNota(7);
			student.addNota(6);
			student.addNota(6);
			student.addNota(8);
			expected = student.notaFrecventaMaxima();
			long timp1 = System.currentTimeMillis();
			student.addNota(9);
			student.addNota(9);
			student.addNota(9);
			actual = student.notaFrecventaMaxima();
			long timp2 = System.currentTimeMillis();
			if((timp2-timp1)>0.1){
				assertTrue(false);
			}
			else{
				assertTrue(true);
			}
		} catch (ExceptionNullValues e) {
			e.printStackTrace();
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
}
