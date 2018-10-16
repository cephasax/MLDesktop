package br.ufrn.imd.tutorial;



import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import weka.classifiers.Classifier;
import weka.core.SerializationHelper;

/**
 * @author cephas
 *
 */
@Component
public class MachineLearningModel {

	private Classifier cls;
	private String modelName;
		
	@PostConstruct
	public void loadModel() {
		//choose and load model
		this.modelName = new String("C:\\Users\\Cephas\\EclipseWork\\learnWork\\TutorialML\\src\\main\\resources\\diabets_modelo.model");
		try {
			this.cls = (Classifier) SerializationHelper.read(modelName);
			
		} catch (Exception e) {
			System.out.println("Nao foi possivel carregar o modelo - motivo: \n");
			e.printStackTrace();
		}		
	}

	public Classifier getCls() {
		return cls;
	}

	public void setCls(Classifier cls) {
		this.cls = cls;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

}
