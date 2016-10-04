import Biblio.*;
import Università.*;


public class EsMain {

	public static void main(String[] args) {
		
		Segreteria s= new Segreteria();
		Università u= new Università("Politecnico");
		
		Studente s1= s.registraStudente("Martina", "Debernardi", u);
		Studente s2= s.registraStudente("Luca", "Umoretto", u);
		Studente s3= s.registraStudente("Irene", "Aimone", u);
		
		
		for(Studente stud: u.getStudenti()){
			System.out.println(stud);
		}
		
		Docente d1= s.registraDocente("Rita", "Lauritano","RTLRT90kahsdkuYWE", u);
		Docente d2= s.registraDocente("Giulia", "Sciroccale","BKUWE15SEFKJ", u);
		
		System.out.println();
				
		for(Docente doc: u.getDocenti()){
			System.out.println(doc);
		}
		
		System.out.println();
		
		Corso c1= s.registraCorso("Ingegneria del Software", 120, u);
		Corso c2= s.registraCorso("Logistica", 200, u);
		Corso c3= s.registraCorso("Inglese", 80, u);
		
		for(Corso c: u.getCorsi()){
			System.out.println(c);
		}
		
		System.out.println();
		
		s.aggiungiStudenteACorso(s1, c1, u);
		s.aggiungiStudenteACorso(s2, c1, u);
		s.aggiungiStudenteACorso(s1, c2, u);
		s.aggiungiStudenteACorso(s3, c2, u);
		s.aggiungiStudenteACorso(s1, c3, u);
		
		for(Studente stud: c1.getStudentiDelCorso()){
			System.out.println(stud);
		}
		
		System.out.println();
		
		for(Studente stud: c2.getStudentiDelCorso()){
			System.out.println(stud);
		}
		
		s.aggiungiDocenteACorso(d1, c1, u);
		s.aggiungiDocenteACorso(d2, c1, u);
		
        System.out.println();
		
		for(Docente d: c1.getDocentiDelCorso()){
			System.out.println(d);
		}
		
		Biblioteca b= new Biblioteca("Centrale Politecnico");
		u.setB(b);
		Gestione g = new Gestione();
		
		g.registraLibro("Cent'anni di solitudine", "Garcia Marquez", 2, b);
		g.registraLibro("Delitto e castigo", "Fedor Dostoevskij", 4, b);
		g.registraLibro("Anna Karenina", "Lev Tolstoj", 1, b);
		g.registraLibro("Il maestro e Margherita", "Michail Bulgakov", 3, b);
		g.registraLibro("Il vecchio e il mare", "Hernest Hemingway", 2, b);
		g.registraLibro("Il processo", "Franz Kafka", 3, b);
		g.registraLibro("L'insostenibile leggerezza dell'essere", "Milan Kundera", 1, b);
		
		System.out.println(g.registraLibro("L'insostenibile leggerezza dell'essere", "Milan Kundera", 2, b));
		System.out.println(g.registraLibro("Delitto e castigo", "Fedor Dostoevskij", 2, b));
		System.out.println(g.registraLibro("Il maestro e Margherita", "Michail Bulgakov", 6, b));
		
		for(Libro l:b.getLibri()){
			System.out.println(l.getTitolo()+" "+l.getAutore());
		}
		
		g.registraUtente("Martina", "Debernardi", b);
		g.registraUtente("Luca", "Umoretto", b);
		g.registraUtente("Irene", "Aimone", b);
		g.registraUtente("Rita", "Lauritano", b);
		g.registraUtente("Giulia", "Sciroccale", b);
		
		System.out.println();
				
		for(Utente utente:b.getUtenti()){
			System.out.println(utente.getNome()+" "+utente.getCognome());
		}
		
		System.out.println();
		
		g.prestaLibro("Delitto e castigo", "Fedor Dostoevskij","Martina", "Debernardi", b);
		g.prestaLibro("Anna Karenina", "Lev Tolstoj","Martina", "Debernardi", b);
		g.prestaLibro("Il maestro e Margherita", "Michail Bulgakov","Martina", "Debernardi", b);
		g.prestaLibro("Il processo", "Franz Kafka","Martina", "Debernardi", b);
		g.prestaLibro("Anna Karenina", "Lev Tolstoj","Luca", "Umoretto", b);
		g.prestaLibro("L'insostenibile leggerezza dell'essere", "Milan Kundera","Luca", "Umoretto", b);
		
		System.out.println();
		
		g.restituzioneLibro("Delitto e castigo", "Fedor Dostoevskij","Martina", "Debernardi", "26/09/2016", b);
		
		for(Prestito p:b.getPrestiti()){
			System.out.println(p.getTitolo()+" "+p.getAutore()+" "+p.getNome()+" "+p.getCognome()+" "+p.getDataPrestito()+" "+p.getDataRestituzione());
		}
		
	}

}
