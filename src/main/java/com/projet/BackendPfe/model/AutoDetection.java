package com.projet.BackendPfe.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AutoDetection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String maladieDroite;
	private String maladieGauche;
	private int graviteDroite;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public AutoDetection( String maladieDroite, String maladieGauche, int graviteDroite, int graviteGauche) {
		super();
	
		this.maladieDroite = maladieDroite;
		this.maladieGauche = maladieGauche;
		this.graviteDroite = graviteDroite;
		this.graviteGauche = graviteGauche;
	}
	public AutoDetection() {
		super();
	}
	private int graviteGauche;
	public String getMaladieDroite() {
		return maladieDroite;
	}
	  @OneToMany(targetEntity=Consultation.class, mappedBy = "autoDetection",fetch=FetchType.LAZY)
			private List<Consultation>autoDetection=new ArrayList<Consultation>();
	public void setMaladieDroite(String maladieDroite) {
		this.maladieDroite = maladieDroite;
	}
	public String getMaladieGauche() {
		return maladieGauche;
	}
	public void setMaladieGauche(String maladieGauche) {
		this.maladieGauche = maladieGauche;
	}
	public int getGraviteDroite() {
		return graviteDroite;
	}
	public void setGraviteDroite(int graviteDroite) {
		this.graviteDroite = graviteDroite;
	}
	public int getGraviteGauche() {
		return graviteGauche;
	}
	public void setGraviteGauche(int graviteGauche) {
		this.graviteGauche = graviteGauche;
	}
}
