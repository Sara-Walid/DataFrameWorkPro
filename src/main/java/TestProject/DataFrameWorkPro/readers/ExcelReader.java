package TestProject.DataFrameWorkPro.readers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelReader {
	
	static String filePath = "0";
//	static XSSFWorkbook wb;
	static HSSFWorkbook wb;
	
	public static void setPath(String filePath) throws IOException
	{
		File InputsFile = new File(filePath);
		FileInputStream fip = new FileInputStream(InputsFile);
//		wb = new XSSFWorkbook(fip); 
		wb = new HSSFWorkbook(fip); 
	}
	
	public static String read(int RowNumber, int ColumnNumber) throws IOException
	{
		String CellData = "2";

		Sheet sheet = wb.getSheetAt(0);
		Row row = sheet.getRow(RowNumber);
		//Iterator<Row> rowIt = sheet.rowIterator();
		
		//while(rowIt.hasNext())
		//{
			//row = rowIt.next();
			Cell cell = row.getCell(ColumnNumber);
			//Iterator<Cell> cellIt = row.cellIterator();

			if (CellData != null && cell != null) //for NullPoiterException
				CellData = cell.getStringCellValue().toString();
			//while(cellIt.hasNext())
			//{
				//cell = cellIt.next();
			//}
		//}
		return CellData;
	}
	
	public static void main( String[] args ) throws IOException
    {
		String filePath = System.getProperty("user.dir")+"/src/test/resources/"+"data.xls";
		setPath(filePath);
		
    	ExcelReader ExcelObj = new ExcelReader();
    	String CellDataValue = "1";
    	for (int i = 1; i< 2; i++)
    	{
    		for (int j = 0; j< 2; j++)
    		{
        		CellDataValue = ExcelObj.read(i, j);
        		System.out.println(CellDataValue);
    		}
    	}
    }
}
