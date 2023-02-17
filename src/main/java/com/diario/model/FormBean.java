package com.diario.model;

import java.io.File;

import javax.servlet.http.Part;

public class FormBean {
	private String data;
	private String attività;
	private String nome;
	private String cognome;
	private String presenti;
	private String mansione;
	private String azione;
	private String fase_azione;
	private String elaborazione;
	private String fase_elaborazione;
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getAttività() {
		return attività;
	}
	
	public void setAttività(String attività) {
		this.attività = attività;
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
	
	public String getMansione() {
		return mansione;
	}
	public void setMansione(String mansione) {
		this.mansione = mansione;
	}
	public String getAzione() {
		return azione;
	}
	public void setAzione(String azione) {
		this.azione = azione;
	}
	public String getElaborazione() {
		return elaborazione;
	}
	public void setElaborazione(String elaborazione) {
		this.elaborazione = elaborazione;
	}
	public String getPresenti() {
		return presenti;
	}
	public void setPresenti(String presenti) {
		this.presenti = presenti;
	}
	public String getFase_azione() {
		return fase_azione;
	}
	public void setFase_azione(String part1) {
		this.fase_azione = part1;
	}
	public String getFase_elaborazione() {
		return fase_elaborazione;
	}
	public void setFase_elaborazione(String part2) {
		this.fase_elaborazione = part2;
	}
	
	
	public static String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() -1);
			}
		}
		return "";
	}
}
