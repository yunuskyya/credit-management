package com.yunusKaya.creditManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="credit")
public class Credit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="musteri_adi")
	private String musteriAdi;
	
	@Column(name="kredi_tutari")
	private double krediTutari;
	
	@Column(name="kredi_vadesi")
	private int krediVadesi;
	
	@Column(name="kredi_turu")
	
	private CreditType krediTuru;
	
	
	
	
    
}
