package com.ko.web.entity;

public class VocabDto {

	
	private String id;
	private String vocabName;
	
	
	public VocabDto() {
		
	}


	public VocabDto(String id, String vocabName) {
		super();
		this.id = id;
		this.vocabName = vocabName;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getVocabName() {
		return vocabName;
	}


	public void setVocabName(String vocabName) {
		this.vocabName = vocabName;
	}


	
	
}