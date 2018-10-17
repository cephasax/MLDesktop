package br.ufrn.imd.domain;

import java.util.ArrayList;
import java.util.List;

//SOME S*** HERE, but I needed to solve problem fastly
public class DiabetsItem {

	private int id;
	private boolean option = false;
	private double preg;
	private double plas;
	private double pres;
	private double skin;
	private double insu;
	private double mass;
	private double pedi;
	private double age;
	private String diabetsClass;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isOption() {
		return option;
	}

	public void setOption(boolean option) {
		this.option = option;
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

	public static List<DiabetsItem> diabetsItensFromDiabetsList(ArrayList<Diabets> data) {
		ArrayList<DiabetsItem> dt = new ArrayList<DiabetsItem>();
		for (int i = 0; i < data.size(); i++) {
			DiabetsItem dItem = new DiabetsItem();
			dItem.setId(i);
			dItem.setOption(false);
			dItem.setPreg(data.get(i).getPreg());
			dItem.setPlas(data.get(i).getPlas());
			dItem.setPres(data.get(i).getPres());
			dItem.setSkin(data.get(i).getSkin());
			dItem.setInsu(data.get(i).getInsu());
			dItem.setMass(data.get(i).getMass());
			dItem.setPedi(data.get(i).getPedi());
			dItem.setAge(data.get(i).getAge());
			dItem.setDiabetsClass(data.get(i).getDiabetsClass());
			dt.add(dItem);
		}
		return dt;
	}

}
