package com.practise.googleSheetRead.action.tests;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.practise.googleSheetRead.utils.GoogleSheetsUtil;

public class TestGoogleSheet {

	@DataProvider(name = "GoogleSheetData")
	public Object[] GoogleSheetData() throws Exception {

		List<List<Object>> values = GoogleSheetsUtil.gettingSpreadsheetResponse();
		int total_rows = values.size();
		Object[] Data = new Object[total_rows];

		if (values == null || values.isEmpty()) {
			System.out.println("No data found.");
		} else {
			System.out.println("ArticleId");
			for (int i = 0; i < total_rows; i++) {
				Data[i] = values.get(i).get(0);
			}

		}

		return Data;
	}

	@Test(dataProvider = "GoogleSheetData")
	public void gettingGoogleSheetData(String num) {
		System.out.println(num);
	}

}
