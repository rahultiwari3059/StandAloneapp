package com.bridgelabz.Csvfilecreator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;

import com.bridgelabz.model.AppOpenModel;
import com.bridgelabz.model.GaReportInputModel;
import com.bridgelabz.model.SecretFileModel;

public class AppOpenCsvCreator {
	static String csvFilePath;

	// argument constructor to get the CSvfile path where we have to create csv
	// file
	public AppOpenCsvCreator(SecretFileModel secretFileModelObject) {
		csvFilePath = secretFileModelObject.getCsvFilePath();

	}

	// default constructor
	public AppOpenCsvCreator() {
		// TODO Auto-generated constructor stub
	}

	// method to create appOpen CSv creator
	public void appOpenCsvCreator(ArrayList<AppOpenModel> appOpenModelArrayListObject,
			GaReportInputModel gaReportInputModel) {
		// creating HashSet object to add android id
		HashSet<String> androidIdAppOpen = new HashSet<String>();
		try {

			boolean b = false;
			File file1 = new File(csvFilePath + "appOpen.csv");
			if (!file1.exists()) {
				b = true;
			}
			FileWriter fw1 = new FileWriter(file1.getAbsoluteFile(), true);
			BufferedWriter bw1 = new BufferedWriter(fw1);
			if (b) {
				file1.createNewFile();

				bw1.append("gaid^gadiscription^AndroidId^Eventcategory^Date^");
				bw1.newLine();
			}

			for (int i = 0; i < appOpenModelArrayListObject.size(); i++) {

				bw1.append(gaReportInputModel.getmGaID());
				bw1.append("^");

				bw1.append(gaReportInputModel.getmGaDiscription());
				bw1.append("^");

				bw1.append(appOpenModelArrayListObject.get(i).getmAndroidId());
				androidIdAppOpen.add(appOpenModelArrayListObject.get(i).getmAndroidId());
				bw1.append("^");

				bw1.append(appOpenModelArrayListObject.get(i).getmEventcategory());
				bw1.append("^");

				bw1.append(appOpenModelArrayListObject.get(i).getmDate());
				bw1.append("^");

				bw1.newLine();

			}
			
			bw1.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
