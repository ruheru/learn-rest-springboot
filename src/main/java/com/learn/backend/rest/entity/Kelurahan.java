package com.learn.backend.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity @Table(name="kelurahan")
public class Kelurahan {
	
	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	
	@NotNull @NotEmpty
	private String kode;
	
	@NotNull @NotEmpty
	private String nama;
	
	@NotNull @NotEmpty
	private String kodepos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKode() {
		return kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getKodepos() {
		return kodepos;
	}

	public void setKodepos(String kodepos) {
		this.kodepos = kodepos;
	}
	
	
}
