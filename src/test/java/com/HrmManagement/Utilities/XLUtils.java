package com.HrmManagement.Utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class XLUtils 
{
    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet sh;
    public static XSSFRow row;
    public static XSSFCell cell;  
    public static int getRowCount(String xlfile,String xlssheet) throws IOException
    {
    	fi=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(fi);
    	sh=wb.getSheet(xlssheet);
    	int rowCount=sh.getLastRowNum();
    	wb.close();
    	fi.close();
		return rowCount;	
    }
    public static int getCellCount(String xlfile,String xlssheet,int rownum) throws IOException
    {
    	fi=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(fi);
    	sh=wb.getSheet(xlssheet);
    	row=sh.getRow(rownum);
    	int cellCount=row.getLastCellNum();
    	wb.close();
    	fi.close();
		return cellCount;	
    }
    public static String getCellData(String xlfile,String xlssheet,int rownum,int colnum) throws IOException
    {
    	fi=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(fi);
    	sh=wb.getSheet(xlssheet);
    	row=sh.getRow(rownum);
    	cell=row.getCell(colnum);
    	String data;
    	try
    	{
    		data=cell.toString();
    	}
    	catch(Exception e)
    	{
    		data="";
    	}
    	wb.close();
    	fi.close();
		return data;
    }
    public static void setCellData(String xlfile,String xlssheet,int rownum,int colnum,String data) throws IOException
    {
    	fi=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(fi);
    	sh=wb.getSheet(xlssheet);
    	row=sh.getRow(rownum);
    	cell=row.createCell(colnum);
    	cell.setCellValue(data);
    	fo=new FileOutputStream(xlfile);
    	wb.close();
    	fi.close();
    	fo.close();
    }
}
