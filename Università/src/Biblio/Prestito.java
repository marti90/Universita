package Biblio;

import java.util.Date;

public class Prestito {
	
	private String titolo="";
	private String autore="";
	private String nome="";
	private String cognome="";
	private Date dataPrestito=null;
	private Date dataRestituzione=null;
	
	public Prestito(){
		
	}
	
	public Prestito(String titolo, String autore, String nome, String cognome, Date dataPrestito, Date dataRestituzione) {
		
		this.titolo = titolo;
		this.autore = autore;
		this.nome = nome;
		this.cognome = cognome;
		this.dataPrestito = dataPrestito;
		this.dataRestituzione = dataRestituzione;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataPrestito() {
		return dataPrestito;
	}

	public void setDataPrestito(Date dataPrestito) {
		this.dataPrestito = dataPrestito;
	}

	public Date getDataRestituzione() {
		return dataRestituzione;
	}

	public void setDataRestituzione(Date dataRestituzione) {
		this.dataRestituzione = dataRestituzione;
	}

}
