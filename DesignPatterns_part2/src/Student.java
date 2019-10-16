import java.io.LineNumberInputStream;
import java.util.ArrayList;


public class Student {
	private String nume;
	private ArrayList<Integer> note;
	private float medie;
	
	public Student(String nume) {
		this.nume = nume;
		note = new ArrayList();
	}

	public Student(String nume, ArrayList<Integer> note) {
		this.nume = nume;
		this.note = new ArrayList();
		for(Integer n: note)
			this.note.add(n);
	}

	public String getNume() {
		return nume;
	}
	
	public float getMedie() {
		return medie;
	}

	public void addNota(int nota) throws ExceptionFormatInput{
		if(nota<=0 || nota>10) 
			throw new ExceptionFormatInput("Valoarea introdusa nu reprezinta o nota.");
		note.add(nota);
	}
	
	public void addNota2(int nota) {
		if(nota>0 && nota<11)
			note.add(nota);
	}
	
	public int getNota(int i) throws ExceptionLipsaElement{
		if(i<0 || i>=note.size()) 
			throw new ExceptionLipsaElement("Nu exista nota la indexul precizat!");
		return note.get(i);
	}
	
	public ArrayList<Integer> getNote() {
		return note;
	}

	public int nrDisciplinePromovate(){
		int nrDiscipline = 0;
		for(Integer n: note)
			if(n >= 5)
				nrDiscipline++;
		
		return nrDiscipline;
	}
	
	public void medieAritmetica() throws ExceptionMedieNull{
		float m = 0;
		for(Integer n: note)
			if(n >= 5)
				m += n;
		if(m==0)
			throw new ExceptionMedieNull("Nu se poate calcula media!");
		else
			this.medie = m / this.nrDisciplinePromovate();
	}
	
	public int notaFrecventaMaxima() throws ExceptionNullValues{
		int nota = 0;
		int[] values = new int[10];
		for(int i=0;i<10;i++){
			values[i]=0;
		}
		if(note.size() == 0)
			throw new ExceptionNullValues("Lista nu contine note!");
		else{
			for (Integer integer : note) {
				values[integer-1]++;
			}
			int max = values[0];
			nota = 1;
			for(int i =1; i<=9; i++){
				if(values[i]>=max) 
					{
						max = values[i];
						nota = i+1;
					}
			}
			
		}
		return nota;
	}
	
	public int notaFrecventaMaxima1() throws ExceptionNullValues{
		int nota = 0;
		int[] values = new int[10];
		for(int i=0;i<10;i++){
			values[i]=0;
		}
		if(note.size() == 0)
			throw new ExceptionNullValues("Lista nu contine note!");
		else{
			for(int i=1;i<=10;i++)
				for (int n : note) {
					if(i==n) values[i-1]++;
				}
			
			int max = 0;
			for(int i=1 ; i<10 ; i++){
				if(values[max] <= values[i]) max = i;
			}
			
			nota = max+1;
		}
		return nota;
	}
	
	@Override
	public String toString() {
		String output = this.nume + " note: ";
		for(Integer n: note)
			output += n + " ";
		return output;
	}	
}