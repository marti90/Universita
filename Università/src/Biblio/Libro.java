package Biblio;

public class Libro implements ValidaDati{
	
	private String titolo="";
	private String autore="";
	private int copieTotali=0;
	private int copieDisponibili=0;
	
	public Libro(){
		
	}
	
	public Libro(String titolo, String autore) {
		super();
		this.titolo = titolo;
		this.autore = autore;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public int getCopieTotali() {
		return copieTotali;
	}

	public void setCopieTotali(int copieTotali) {
		this.copieTotali = copieTotali;
	}

	public int getCopieDisponibili() {
		return copieDisponibili;
	}

	public void setCopieDisponibili(int copieDisponibili) {
		this.copieDisponibili = copieDisponibili;
	}
	
	public String toString(){
		return titolo+" "+autore;
	}
	
	@Override
	public boolean isValid() {
		boolean res=false;
		if((!titolo.isEmpty() && titolo!=null)&&(!autore.isEmpty() && autore!=null)){
			res=true;
		}
		return res;
	}

}
