package com.bridgelabz.responseFetcher;

import java.util.ArrayList;
import com.bridgelabz.model.GaReportInputModel;
import com.bridgelabz.model.ResponseModel;
import com.bridgelabz.responseReader.ResponseReader;
import com.google.api.services.analyticsreporting.v4.AnalyticsReporting;
import com.google.api.services.analyticsreporting.v4.model.GetReportsResponse;

public class GaReportResponseFetcher {
	
	// creating object of InitializeAnalyticsReporting
	InitializeAnalyticsReporting initializeAnalyticsReportingObject = new InitializeAnalyticsReporting();
	
	// creating object of ResponseReader
	ResponseReader responseReaderObject= new ResponseReader();
	
/*-------------------------method to get the response model ArrayList------------------------------------*/
	
	 public ResponseModel getResponse(GaReportInputModel gaReportInputModel)
	 {
		 //creating object of ResponseModel
		 ResponseModel responseModelObject= new ResponseModel();
		 
				// calling initializeAnalyticsReporting method of InitializeAnalyticsReporting class to initialize all credential
				try
				{
				AnalyticsReporting service = initializeAnalyticsReportingObject.initializeAnalyticsReporting();
				
				// calling getReport method to get response
				GetReportsResponse response = initializeAnalyticsReportingObject.getReport(service,gaReportInputModel);
				
				// printing the response
				System.out.println(response);
				
				// assigning response into variable response JSON of GetReportsResponse type

				GetReportsResponse responsejson = response;
				
				// reading response and placing it to responseModelArrayList
				responseModelObject=responseReaderObject.responseReader(responsejson.toString());
				}
				catch(Exception e)
				{
					e.printStackTrace();
					
				}
			
	return responseModelObject;
	 }
}
