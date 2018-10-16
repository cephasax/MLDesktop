package br.ufrn.imd.domain;

public class Diabets {

	private double preg;
	private double plas;
	private double pres;
	private double skin;
	private double insu;
	private double mass;
	private double pedi;
	private double age;

	private String diabetsClass;

	public Diabets() {
		this.diabetsClass = new String(DiabetsClasses.NULL.getInfo());
	}

	public double getPreg() {
		return preg;
	}

	public void setPreg(double preg) {
		this.preg = preg;
	}

	public double getPlas() {
		return plas;
	}

	public void setPlas(double plas) {
		this.plas = plas;
	}

	public double getPres() {
		return pres;
	}

	public void setPres(double pres) {
		this.pres = pres;
	}

	public double getSkin() {
		return skin;
	}

	public void setSkin(double skin) {
		this.skin = skin;
	}

	public double getInsu() {
		return insu;
	}

	public void setInsu(double insu) {
		this.insu = insu;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public double getPedi() {
		return pedi;
	}

	public void setPedi(double pedi) {
		this.pedi = pedi;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public String getDiabetsClass() {
		return diabetsClass;
	}

	public void setDiabetsClass(String diabetsClass) {
		this.diabetsClass = diabetsClass;
	}

}
