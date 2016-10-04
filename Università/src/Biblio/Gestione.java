package Biblio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Gestione {
	
	public int registraLibro(String titolo, String autore, int copieDaRegistrare, Biblioteca b){

		Libro l= cercaLibro(titolo,autore,b);
		
		if(l==null){
			l= new Libro(titolo,autore);
			b.getLibri().add(l);
			l.setCopieTotali(copieDaRegistrare);
			l.setCopieDisponibili(copieDaRegistrare);
		} else {
			l.setCopieTotali(l.getCopieTotali()+copieDaRegistrare);
			l.setCopieDisponibili(l.getCopieDisponibili()+copieDaRegistrare);
		}
		
		return l.getCopieTotali();
	}
	
	public boolean registraUtente(String nome, String cognome, Biblioteca b){
		
		Utente u= cercaUtente(nome,cognome,b);

		if(u==null){
			
			u= new Utente(nome,cognome);
			b.getUtenti().add(u);
			
			return true;
		} else 
			return false;	
	}
	
	public boolean prestaLibro(String titolo, String autore, String nome, String cognome, Biblioteca b){
		
		Libro l= cercaLibro(titolo,autore,b);
		Utente u= cercaUtente(nome,cognome,b);
		
		if(l!= null && u!= null){
			if(u.getLibriInPrestito().size()<3){
				
				if(l.getCopieDisponibili()==0){
					System.out.println("Attenzione libro attualmente non disponibile");
				} else {
					u.getLibriInPrestito().add(l);
					Date d=new Date();
					Prestito p=new Prestito(titolo,autore,nome,cognome,d,null);
					b.getPrestiti().add(p);
					
				}
				
				l.setCopieDisponibili(l.getCopieTotali()-1);
				
				return true;
			} else{
				System.out.println("Superato il limite massimo di libri presi in prestito!");
				return false;
			}	
			
		} else 
			return false;

	}
	
	public boolean restituzioneLibro(String titolo, String autore, String nome, String cognome, String dataPrestito, Biblioteca b){
		
		Libro l= cercaLibro(titolo,autore,b);
		Utente u= cercaUtente(nome,cognome,b);
		Prestito p= cercaPrestito(titolo,autore,nome,cognome,dataPrestito,b);
		
		if(l!=null && u!=null && p!=null){
			u.getLibriInPrestito().remove(l);
			Date d= new Date();
			p.setDataRestituzione(d);
			
			return true;
		}
		else
			return false;
		
	}
	
	public Libro cercaLibro(String titolo,String autore, Biblioteca b){
        Libro l= null;
		
		for(Libro libro :b.getLibri()){
			if((libro.getTitolo().equals(titolo))&&(libro.getAutore().equals(autore))){
		        l=libro;
			
			}
		}
		return l;
	}
	
	public Utente cercaUtente(String nome, String cognome,Biblioteca b){
		Utente u= null;
		
		for(Utente utente : b.getUtenti()){
			if((utente.getNome().equals(nome))&&(utente.getCognome().equals(cognome))){
				u= utente;
			}
		}
		return u;
	}
	
    private Prestito cercaPrestito(String titolo, String autore, String nome, String cognome, String dataPrestito, Biblioteca b){
		
		Prestito p=null;
		for(Prestito prestito: b.getPrestiti()){
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String reportDate = df.format(prestito.getDataPrestito());
			if(prestito.getTitolo().equals(titolo) && prestito.getAutore().equals(autore) && 
					prestito.getNome().equals(nome) && prestito.getCognome().equals(cognome)&&
					reportDate.equals(dataPrestito)){
				
				p=prestito;
			}
		}
		return p;
	}

}
