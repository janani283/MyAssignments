package salesforce;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateIndiExcel {

	//Step 1 For Integration: Convert the main method to Static String[][] 
		public static String[][] fetchData() throws IOException {
			
			// Step1 : Set up the excel file path/ workbook
			XSSFWorkbook wb = new XSSFWorkbook("./ExcelInputFiles/CreateIndi.xlsx");

			// Step2 : to get the sheet from the book.
			XSSFSheet sheet = wb.getSheetAt(0);

			XSSFRow row = sheet.getRow(0);

			// getLsatRowNum(); - excludes header.
			int rowCount = sheet.getLastRowNum();
			System.out.println("getLastRowNum " + rowCount);

			
			// count the cell/column value
					short lastCellCount = sheet.getRow(1).getLastCellNum();
					System.out.println("lastCellNum " + lastCellCount);
					
			//========================For Integration===========================================
					
			String[][] data = new String[rowCount][lastCellCount];
					
					
					
					// Step6: Print all the values from the sheet.
					// row value index starts from
					for (int i = 1; i <= rowCount; i++) {

						// cell values starts from 0.
						for (int j = 0; j < lastCellCount; j++) {

							String stringCellValues = sheet.getRow(i).getCell(j).getStringCellValue();
							System.out.println(stringCellValues);

							//Step 3: 
							data[i-1][j]=stringCellValues;
							
							
							// nullPointerException.
						}

					}
					wb.close();
					return data;

	
	
}
}