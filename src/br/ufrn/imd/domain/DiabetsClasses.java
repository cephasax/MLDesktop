package br.ufrn.imd.domain;

public enum DiabetsClasses {

	//it's only a fake for put
    NULL("tested_negative");

    private String info;

    DiabetsClasses(String info){
        this.info = info;
    }

    public String getInfo(){
        return this.info;
    }

}
