package com.mkyong.form.model;

import java.util.Date;

public class Arac {
	
	Integer id;
	
	String santral;
	
	String aracPlakasi;
	
	String adSoyad;
	
	String tarih;
	
	String hareketSaati;
	
	Long baslangicKm;
	
	Long sonKm;
	
	String aracDurumu;
	
	public boolean isNew() {
		return (this.id == null);
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSantral() {
		return santral;
	}

	public void setSantral(String santral) {
		this.santral = santral;
	}

	public String getAracPlakasi() {
		return aracPlakasi;
	}

	public void setAracPlakasi(String aracPlakasi) {
		this.aracPlakasi = aracPlakasi;
	}

	public String getAdSoyad() {
		return adSoyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

	public String getHareketSaati() {
		return hareketSaati;
	}

	public void setHareketSaati(String hareketSaati) {
		this.hareketSaati = hareketSaati;
	}

	public Long getBaslangicKm() {
		return baslangicKm;
	}

	public void setBaslangicKm(Long baslangicKm) {
		this.baslangicKm = baslangicKm;
	}

	public Long getSonKm() {
		return sonKm;
	}

	public void setSonKm(Long sonKm) {
		this.sonKm = sonKm;
	}
	
	public String getAracDurumu() {
		return aracDurumu;
	}


	public void setAracDurumu(String aracDurumu) {
		this.aracDurumu = aracDurumu;
	}


	@Override
	public String toString() {
		return "Arac [id=" + id + ", santral=" + santral + ", aracPlakasi=" + aracPlakasi + ", adSoyad=" + adSoyad
				+ ", tarih=" + tarih + ", hareketSaati=" + hareketSaati + ", baslangicKm=" + baslangicKm + ", sonKm="
				+ sonKm + ", aracDurumu=" + aracDurumu + "]";
	}


	

}
