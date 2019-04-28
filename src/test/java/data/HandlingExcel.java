package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class HandlingExcel {
	static FileInputStream excel_workbook_holder = null;

	static FileInputStream targeted_excel_for_test ;
	String file_Path = System.getProperty("user.dir") + "\\src\\test\\java\\data\\TestData.xlsx";

	public FileInputStream Open_excel_sheet() {

		File the_excel_file = new File(file_Path);
		try {
			targeted_excel_for_test = new FileInputStream(the_excel_file);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}	
		return targeted_excel_for_test;

	}

//	@DataProvider(name= "excelData")
	public Object[][] getExcelData() throws IOException{
		Open_excel_sheet();
		XSSFWorkbook test_work_book = new XSSFWorkbook(targeted_excel_for_test);
		XSSFSheet test_sheet = test_work_book.getSheetAt(0);
		int TotalNumberofRow = (test_sheet.getLastRowNum());
		int TotalNumberOfColumn = 9;
		String[][] arrayExcelData =  new String[TotalNumberofRow -1][TotalNumberOfColumn];
		for (int rows = 1; rows < TotalNumberofRow; rows++) {
			for (int column = 0; column < TotalNumberOfColumn ; column++) {
 
				XSSFRow row = test_sheet.getRow(rows);				
				arrayExcelData[rows - 1][column] = row.getCell(column).toString();
//				System.out.println(arrayExcelData[rows][column]);
				

			}

		}
//		test_work_book.close();
		System.out.println(arrayExcelData);
		
		return arrayExcelData;
		

	}

	public void write_data_into_excel(int row_count, String row_location, String enter_gender, String enter_first_name, String enter_last_name	, String enter_the_Day, String enter_The_Month,  String enter_the_Year,String enter_test_email, String	enter_test_company, String	enter_test_Password
			) throws IOException {
		Open_excel_sheet();
		XSSFWorkbook test_work_book = new XSSFWorkbook(targeted_excel_for_test);
		XSSFSheet test_sheet = test_work_book.getSheetAt(0);
		Map<String, Object[]> data = new TreeMap<String, Object[]>(); 
//		data.put("0", new Object[]{"gender", "first_name", "Last_name", "theDay", "TheMonth", "theYear", "email", "company", "testPassword"});
		data.put(row_location, new Object[]{ enter_gender, enter_first_name, enter_last_name, enter_the_Day, enter_The_Month, enter_the_Year, enter_test_email, enter_test_company, enter_test_Password});
		Set<String> keyset = data.keySet();
		int rownum = row_count; 
		for (String key : keyset) { 
			// this creates a new row in the sheet 
			
			Row row = test_sheet.createRow(rownum); 
			Object[] objArr = data.get(key); 
			int cellnum = 0; 
			for (Object obj : objArr) { 
				// this line creates a cell in the next column of that row 
				Cell cell = row.createCell(cellnum++); 

				if (obj instanceof String) {
					cell.setCellValue((String)obj); 
				}
				else if (obj instanceof Integer) {
					cell.setCellValue((Integer)obj); 
				}
			} 
			rownum++;
		} 
		try { 
			File the_excel_file = new File(file_Path);
			FileOutputStream out = new FileOutputStream(the_excel_file); 
			test_work_book.write(out); 
			out.close(); 
//			test_work_book.close();
			System.out.println("written successfully on disk."); 
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 


}

