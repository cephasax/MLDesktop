package br.ufrn.imd.domain;

import weka.core.Instance;

public class DiabetsController {

	private MachineLearningModel mlm;

	public DiabetsController(MachineLearningModel mlm) {
		this.mlm = mlm;
	}

	public Diabets classifydiabets(Diabets d) {
		Diabets diabets = d;

		String classValue = new String(classifyDiabets(diabets));
		diabets.setDiabetsClass(classValue);

		return diabets;
	}

	private String classifyDiabets(Diabets diabets) {
		DiabetsUtils iu = new DiabetsUtils();

		Instance instance = iu.diabetsToWekaInstance(diabets);

		iu.getDataset().add(instance);

		double value = -1;
		try {
			value = mlm.getCls().classifyInstance(iu.getDataset().get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// get the diabetsClass value
		String prediction = null;
		prediction = new String(iu.getDataset().classAttribute().value((int) value));

		return prediction;

	}

}
