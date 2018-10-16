package br.ufrn.imd.tutorial;

import java.util.ArrayList;
import java.util.List;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

/**
 * 
 * @author Cephas
 *
 * @see this class works like an interface between iris objects in Java and Weka instance needed
 * by classification method. it is a bit more than a parser but it function is restricted to build and
 * allow the classification with Weka ".model" file loaded.
 *
 */

public class DiabetsUtils {

	private Instances dataset;
	private ArrayList<Attribute> attributes;

	public DiabetsUtils() {
			createInstances();
		}

	private void createInstances() {
		this.dataset = new Instances("dataset", createAttributesToDiabets(), 0);
		this.dataset.setClassIndex(this.dataset.numAttributes() - 1);
		;
	}

	private ArrayList<Attribute> createAttributesToDiabets() {

		this.attributes = new ArrayList<Attribute>();

		attributes.add(new Attribute("preg"));
		attributes.add(new Attribute("plas"));
		attributes.add(new Attribute("pres"));
		attributes.add(new Attribute("skin"));
		attributes.add(new Attribute("insu"));
		attributes.add(new Attribute("mass"));
		attributes.add(new Attribute("pedi"));
		attributes.add(new Attribute("age"));

		// Create Class Attribute
		attributes.add(new Attribute("diabetsClass", createValuesForClass()));

		return attributes;
	}

	private List<String> createValuesForClass() {

		List<String> classValues = new ArrayList<String>();
		
		classValues.add(new String("tested_negative"));
		classValues.add(new String("tested_positive"));
		return classValues;
	}

	public Instance diabetsToWekaInstance(Diabets diabets) {

		double[] values = new double[dataset.numAttributes()];

		values[0] = diabets.getPreg();
		values[1] = diabets.getPlas();
		values[2] = diabets.getPres();
		values[3] = diabets.getSkin();
        values[4] = diabets.getInsu();
        values[5] = diabets.getMass();
        values[6] = diabets.getPedi();
        values[7] = diabets.getAge();

		values[8] = dataset.attribute(8).indexOfValue(diabets.getDiabetsClass());

		Instance instance = new DenseInstance(1, values);

		return instance;
	}

	public Instances getDataset() {
		return dataset;
	}

	public void setDataset(Instances dataset) {
		this.dataset = dataset;
	}

}
