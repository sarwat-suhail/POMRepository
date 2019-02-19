package com.pagefactory.pages.util;

import java.util.Hashtable;

public class DataUtil {

	
	public static Object[][] getTestData(String testName,Xls_Reader xls){
		
		
		int testStartRowNo=1;
		
		while(!xls.getCellData(Constants.DATASHEET_NAME, 0, testStartRowNo).equalsIgnoreCase(testName)){
			
			testStartRowNo++;
		}
		
		int colStartRowNo=testStartRowNo+1;
		int dataStartRowNo=testStartRowNo+2;
		
		int cols=0;
		
		while(!xls.getCellData(Constants.DATASHEET_NAME, cols,colStartRowNo).equals("")) {
			
			cols++;
		}
				
		System.out.println("Total no of Columns ---"+cols);
		
		int rows=0;
		
		while(!xls.getCellData(Constants.DATASHEET_NAME, 0, dataStartRowNo+rows).equals("")) {
			
			rows++;
			
		}
		
		System.out.println("Total no Rows ---"+rows);
		
		
		Object[][] data=new Object[rows][1];
		Hashtable<String,String> table=null;
		
		int dataRow=0;
		for(int rNum=dataStartRowNo;rNum<dataStartRowNo+rows;rNum++) {
			
			table=new Hashtable<String,String>();
			
			for(int cNum=0;cNum<cols;cNum++) {
				
				String key=xls.getCellData(Constants.DATASHEET_NAME, cNum, colStartRowNo);
				String value=xls.getCellData(Constants.DATASHEET_NAME, cNum, rNum);
				
				table.put(key, value);
				
				data[dataRow][0]=table;
				
			}
			
			dataRow++;
			
			
			
		}
		
		
		
		return data;
		
		
		
		
		
	}
	
	public static boolean isRunnable(String testName,Xls_Reader xls) {
		
		int rowcount=xls.getRowCount(Constants.TESTSHEET_NAME);
		
		for(int rnum=2;rnum<=rowcount;rnum++) {
			
			String TCID= xls.getCellData(Constants.TESTSHEET_NAME, Constants.TCID_COL,rnum );
			
			String RMod=xls.getCellData(Constants.TESTSHEET_NAME, Constants.RMOD_COL, rnum);
			
			if(TCID.equalsIgnoreCase(testName)) {
				
				if(RMod.equalsIgnoreCase("N"))
				{
					return false;
				}
			else {
				
				return true;
			}
				
		}
			
		}
		
		return false;
	
	}
	
	
	
}
