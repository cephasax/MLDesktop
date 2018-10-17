package br.ufrn.imd.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import br.ufrn.imd.domain.Diabets;

public class DiabetsParser {
	
	public static List<Diabets> csvToDiabetsData(String filePath) throws IOException{
		
		//Create the CSVFormat object
		CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
		CSVParser parser = new CSVParser(new FileReader(filePath), format);
			
		List<Diabets> diabetsData = new ArrayList<Diabets>();
		for(CSVRecord record : parser){
			Diabets diabets = new Diabets();
			
			diabets.setPreg(Double.valueOf(record.get("preg")));
			diabets.setPlas(Double.valueOf(record.get("plas")));
			diabets.setPres(Double.valueOf(record.get("pres")));
			diabets.setSkin(Double.valueOf(record.get("skin")));
			diabets.setInsu(Double.valueOf(record.get("insu")));
			diabets.setMass(Double.valueOf(record.get("mass")));
			diabets.setPedi(Double.valueOf(record.get("pedi")));
			diabets.setAge(Double.valueOf(record.get("age")));
			diabets.setDiabetsClass("?");
			diabetsData.add(diabets);

		}
		//close the parser
		parser.close();
			
		return diabetsData;
	}

}
