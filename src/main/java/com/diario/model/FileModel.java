package com.diario.model;

public class FileModel {
	private String name;
	private String type;
	private byte[] data;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] pdfData) {
		this.data = pdfData;
	}
	
}
