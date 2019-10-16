import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TestAddNota {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//System.out.println("setUpBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//System.out.println("tearDownAfterClass");
	}

	@Before
	public void setUp() throws Exception {
		//System.out.println("setUp");
	}

	@After
	public void tearDown() throws Exception {
		//System.out.println("tearDown");
	}

	@Test
	public void testAddNotaRight1() {
		
		try {
			ArrayList<Integer> note = new ArrayList<>();
			int expected = 6;
			note.add(expected);
			Student student = new Student("Popescu Maria");
			student.addNota(expected);
			int actual = student.getNota(0);
			assertEquals("Right 1: Exista nota 6.", expected, actual);	
		} catch (ExceptionFormatInput | ExceptionLipsaElement e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	@Test
	public void testAddNotaRight2() {
		
		try {
			ArrayList<Integer> expected = new ArrayList<>();
			expected.add(10);
			expected.add(5);
			expected.add(7);
			Student student = new Student("Popescu Maria");
			student.addNota(10);
			student.addNota(5);
			student.addNota(7);
			ArrayList<Integer> actual = student.getNote();
			assertEquals("Right 2: Exista aceleasi notele introduse in lista.", expected, actual);	
		} catch (ExceptionFormatInput e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	@Test
	public void testAddNotaRight3() throws ExceptionLipsaElement {
		
		try {
			ArrayList<Integer> note = new ArrayList<>();
			int expected = 5;
			note.add(2);
			note.add(7);
			note.add(expected);
			note.add(10);
			note.add(expected);
			Student student = new Student("Popescu Maria");
			student.addNota(expected);
			student.addNota(2);
			student.addNota(expected);
			student.addNota(10);
			student.addNota(7);
			int actual = student.getNota(0);
			assertEquals("Right 3: Exista nota 1.", expected, actual);	
		} catch (ExceptionFormatInput e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	@Test
	public void testAddNotaException() {
			try{
				Student student = new Student("Popescu Maria");
				student.addNota(-9);
				assertTrue(false);
			}catch(ExceptionFormatInput e){
				System.out.println("Valoare negativa!");
				e.printStackTrace();
				assertTrue(true);
			}catch(Exception ex){
				ex.printStackTrace();
				assertTrue(false);
			}
	}
	
	@Test
	public void testAddNotaExtreme1() {
			try{
				Student student = new Student("Popescu Maria");
				int actual = 0;
				student.addNota(actual);
				assertTrue("Valoare introdusa!",false);	
			}catch(ExceptionFormatInput e){
				System.out.println("Valoare incorecta!");
				e.printStackTrace();
				assertTrue(true);
			}catch(Exception ex){
				ex.printStackTrace();
				assertTrue(false);
			}
	}
	
	@Test
	public void testAddNotaExtreme2() {
			try{
				Student student = new Student("Popescu Maria");
				int actual = 1;
				student.addNota(actual);
				assertTrue("Valoare introdusa!",true);	
			}catch(ExceptionFormatInput e){
				System.out.println("Valoare incorecta!");
				e.printStackTrace();
				assertTrue(false);
			}catch(Exception ex){
				ex.printStackTrace();
				assertTrue(false);
			}
	}
	
	@Test
	@Category(SlowTest.class)
	public void testAddNotaExtreme3() {
			try{
				Student student = new Student("Popescu Maria");
				int actual = 10;
				student.addNota(actual);
				assertTrue("Valoare introdusa!",true);	
			}catch(ExceptionFormatInput e){
				System.out.println("Valoare incorecta!");
				e.printStackTrace();
				assertTrue(false);
			}catch(Exception ex){
				ex.printStackTrace();
				assertTrue(false);
			}
	}
	
	@Test
	@Category(SlowTest.class)
	public void testAddNotaExtreme4() {
			try{
				Student student = new Student("Popescu Maria");
				int actual = 11;
				student.addNota(actual);
				assertTrue("Valoare introdusa!",false);	
			}catch(ExceptionFormatInput e){
				System.out.println("Valoare incorecta!");
				e.printStackTrace();
				assertTrue(true);
			}catch(Exception ex){
				ex.printStackTrace();
				assertTrue(false);
			}
	}
	
	@Test
	public void testAddNotaCrossCheck() {
		Student student1 = new Student("Popescu Maria");
		Student student2 = new Student("Marinescu Alex");
		ArrayList<Integer> expected = student1.getNote();
		ArrayList<Integer> actual = student2.getNote();
			try{
				student1.addNota(10);
				student2.addNota2(10);
			}catch(ExceptionFormatInput e){
				System.out.println("Valoare incorecta!");
				e.printStackTrace();
				assertTrue(false);
			}catch(Exception ex){
				ex.printStackTrace();
				assertTrue(false);
			}
			assertEquals("Valorile sunt egale!",expected, actual);
	}
	
	@Test
	public void testAddNotaPerformance() {
		Student student = new Student("Popescu Maria");
		
			try{
				long timp1 = System.currentTimeMillis();
				student.addNota(10);
				long timp2=System.currentTimeMillis();
				if((timp2 - timp1) > 5)
					assertTrue(false);
				else assertTrue(true);
			}catch(ExceptionFormatInput e){
				System.out.println("Valoare incorecta!");
				e.printStackTrace();
				assertTrue(false);
			}catch(Exception ex){
				ex.printStackTrace();
				assertTrue(false);
			}
			
	}
	
}
