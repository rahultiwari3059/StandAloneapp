package com.bridgelabz.Csvfilecreator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;

import com.bridgelabz.model.AllElementModels;
import com.bridgelabz.model.GaReportInputModel;
import com.bridgelabz.model.SecretFileModel;

public class AllElementCSvFileCreator {

	static String csvFilePath;

	public AllElementCSvFileCreator(SecretFileModel secretFileModelObject) {
		csvFilePath = secretFileModelObject.getCsvFilePath();
	}

	public AllElementCSvFileCreator() {
		// TODO Auto-generated constructor stub
	}
	// method to create appOpen CSv creator
	public void allElementCSvFileCreator(ArrayList<AllElementModels> allElementModelArrayListObject,
			GaReportInputModel gaReportInputModel) {
		// creating HashSet object to add android id
		HashSet<String> androidIdAllElement = new HashSet<String>();
		try {

			boolean b = false;
			File file1 = new File(csvFilePath + "allElement.csv");
			if (!file1.exists()) {
				b = true;
			}
			FileWriter fw1 = new FileWriter(file1.getAbsoluteFile(), true);
			BufferedWriter bw1 = new BufferedWriter(fw1);
			if (b) {
				file1.createNewFile();

				bw1.append("gaid^gadiscription^AndroidId^Date^");
				bw1.newLine();
			}


			for (int i = 0; i < allElementModelArrayListObject.size(); i++) {
				
				bw1.append(gaReportInputModel.getmGaID());
				bw1.append("^");

				bw1.append(gaReportInputModel.getmGaDiscription());
				bw1.append("^");

				bw1.append(allElementModelArrayListObject.get(i).getmAndroidId());
				androidIdAllElement.add(allElementModelArrayListObject.get(i).getmAndroidId());
				bw1.append("^");

				bw1.append(allElementModelArrayListObject.get(i).getmDate());
				bw1.append("^");

				bw1.newLine();

			}
			//System.out.println(androidIdAllElement.size());
			bw1.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
