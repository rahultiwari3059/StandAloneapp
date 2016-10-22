package com.bridgelabz.Csvfilecreator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;

import com.bridgelabz.model.AppReOpenModel;
import com.bridgelabz.model.GaReportInputModel;
import com.bridgelabz.model.SecretFileModel;

public class AppReOpenCsvCreator {
	static String csvFilePath;

	public AppReOpenCsvCreator(SecretFileModel secretFileModelObject) {
		csvFilePath=secretFileModelObject.getCsvFilePath();
	}

	public AppReOpenCsvCreator() {
		// TODO Auto-generated constructor stub
	}

	public void appReOpenCsvCreator(ArrayList<AppReOpenModel> appReOpenModelArrayListObject,
			GaReportInputModel gaReportInputModel) {
		
		// creating HashSet object to add android id
				HashSet<String> androidIdReAppOpen = new HashSet<String>();
		try {

			boolean b = false;
			File file1 = new File(csvFilePath+"appReopen.csv");
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
			for (int i = 0; i < appReOpenModelArrayListObject.size(); i++) {
				 
					bw1.append(gaReportInputModel.getmGaID());
					bw1.append("^");

					bw1.append(gaReportInputModel.getmGaDiscription());
					bw1.append("^");

					bw1.append(appReOpenModelArrayListObject.get(i).getmAndroidId());
					//adding into androidIdReAppOpen AppReOpen
					androidIdReAppOpen.add(appReOpenModelArrayListObject.get(i).getmAndroidId());
					bw1.append("^");

					bw1.append(appReOpenModelArrayListObject.get(i).getmEventcategory());
					bw1.append("^");

					bw1.append(appReOpenModelArrayListObject.get(i).getmDate());
					bw1.append("^");

					bw1.newLine();
			
			}
			bw1.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
