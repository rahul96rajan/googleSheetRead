package com.practise.googleSheetRead.action;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class GetValFromSpreadSheet {

	public static void main(String args[]) throws IOException, GeneralSecurityException {
		// The ID of the spreadsheet to retrieve data from.
		String spreadsheetId = "1nC21g4xjD0O5lN7dgBcRZ4f4aZK_j3QDXWnyx797v6o"; // TODO: Update placeholder value.

		// The A1 notation of the values to retrieve.
		String range = "TestSheet"; // TODO: Update placeholder value.

		// How values should be represented in the output.
		// The default render option is ValueRenderOption.FORMATTED_VALUE.
		
		/*String valueRenderOption = ""; // TODO: Update placeholder value.
*/
		// How dates, times, and durations should be represented in the output.
		// This is ignored if value_render_option is
		// FORMATTED_VALUE.
		// The default dateTime render option is [DateTimeRenderOption.SERIAL_NUMBER].
/*		String dateTimeRenderOption = ""; // TODO: Update placeholder value.

*/		Sheets sheetsService = createSheetsService();
		Sheets.Spreadsheets.Values.Get request = sheetsService.spreadsheets().values().get(spreadsheetId, range);
		
		/*request.setValueRenderOption(valueRenderOption);
		request.setDateTimeRenderOption(dateTimeRenderOption);*/

		ValueRange response = request.execute();

		// TODO: Change code below to process the `response` object:
		System.out.println(response);
	}

	public static Sheets createSheetsService() throws IOException, GeneralSecurityException {
		HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

		// TODO: Change placeholder below to generate authentication credentials. See
		// https://developers.google.com/sheets/quickstart/java#step_3_set_up_the_sample
		//
		// Authorize using one of the following scopes:
		// "https://www.googleapis.com/auth/drive"
		// "https://www.googleapis.com/auth/drive.file"
		// "https://www.googleapis.com/auth/drive.readonly"
		// "https://www.googleapis.com/auth/spreadsheets"
		// "https://www.googleapis.com/auth/spreadsheets.readonly"
		GoogleCredential credential = new GoogleCredential();
		

		return new Sheets.Builder(httpTransport, jsonFactory, credential).setApplicationName("Google-SheetsSample/0.1")
				.build();
	}
}
