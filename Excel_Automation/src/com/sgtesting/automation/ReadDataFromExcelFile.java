package com.sgtesting.automation;


import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcelFile {
	public static void main(String[] args) {
		readContent();

	}
	private static void readContent()
	{
		Workbook wb=null;
		FileInputStream fin=null;
		Sheet sh=null;
		Row row=null;
		Cell cell=null;
		try
		{
			fin=new FileInputStream("c:\\Excel\\Test.xlsx");
			wb=new XSSFWorkbook(fin);
			sh=wb.getSheet("Sheet1");
			int rc=sh.getPhysicalNumberOfRows();
			for(int r=0;r<rc;r++)
			{
				row=sh.getRow(r);
				int cc=row.getPhysicalNumberOfCells();
				for(int c=0;c<cc;c++)
				{
					cell=row.getCell(c);
					String data=cell.getStringCellValue();
					System.out.print(data+"  ");
				}
				System.out.println();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fin.close();
				wb.close();
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
