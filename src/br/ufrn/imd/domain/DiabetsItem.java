package br.ufrn.imd.domain;

import java.util.ArrayList;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

//SOME S*** HERE, but I needed to solve problem fastly
public class DiabetsItem {

	private SimpleDoubleProperty preg;
	private SimpleDoubleProperty plas;
	private SimpleDoubleProperty pres;
	private SimpleDoubleProperty skin;
	private SimpleDoubleProperty insu;
	private SimpleDoubleProperty mass;
	private SimpleDoubleProperty pedi;
	private SimpleDoubleProperty age;
	private SimpleStringProperty diabetsClass;

	public DiabetsItem() {
		this.preg = new SimpleDoubleProperty();
		this.plas = new SimpleDoubleProperty();
		this.pres = new SimpleDoubleProperty();
		this.skin = new SimpleDoubleProperty();
		this.insu = new SimpleDoubleProperty();
		this.mass = new SimpleDoubleProperty();
		this.pedi = new SimpleDoubleProperty();
		this.age = new SimpleDoubleProperty();
		this.diabetsClass = new SimpleStringProperty("?");
	}

	public Double getPreg() {
		return preg.get();
	}

	public void setPreg(double preg) {
		this.preg.set(preg);
	}

	public Double getPlas() {
		return plas.get();
	}

	public void setPlas(double plas) {
		this.plas.set(plas);
	}

	public Double getPres() {
		return pres.get();
	}

	public void setPres(double pres) {
		this.pres.set(pres);
	}

	public Double getSkin() {
		return skin.get();
	}

	public void setSkin(double skin) {
		this.skin.set(skin);
	}

	public Double getInsu() {
		return insu.get();
	}

	public void setInsu(double insu) {
		this.insu.set(insu);
	}

	public Double getMass() {
		return mass.get();
	}

	public void setMass(double mass) {
		this.mass.set(mass);
	}

	public Double getPedi() {
		return pedi.get();
	}

	public void setPedi(double pedi) {
		this.pedi.set(pedi);
	}

	public Double getAge() {
		return age.get();
	}

	public void setAge(double age) {
		this.age.set(age);
	}

	public String getDiabetsClass() {
		return diabetsClass.get();
	}

	public void setDiabetsClass(String diabetsClass) {
		this.diabetsClass.set(diabetsClass);
	}

	public static ArrayList<DiabetsItem> diabetsItensFromDiabetsList(ArrayList<Diabets> data) {
		ArrayList<DiabetsItem> dt = new ArrayList<DiabetsItem>();
		for (int i = 0; i < data.size(); i++) {
			DiabetsItem dItem = new DiabetsItem();
			dItem.preg.setValue(data.get(i).getPreg());
			dItem.plas.setValue(data.get(i).getPlas());
			dItem.pres.setValue(data.get(i).getPres());
			dItem.skin.setValue(data.get(i).getSkin());
			dItem.insu.setValue(data.get(i).getInsu());
			dItem.mass.setValue(data.get(i).getMass());
			dItem.pedi.setValue(data.get(i).getPedi());
			dItem.age.setValue(data.get(i).getAge());
			dItem.diabetsClass.setValue(data.get(i).getDiabetsClass());
			dt.add(dItem);
		}
		return dt;
	}

}
