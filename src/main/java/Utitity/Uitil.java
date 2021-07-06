package Utitity;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import Base.Base;


public class Uitil  extends Base
{
	
	public static int pageloadtimeout=20;
	public static int Imppilcitwait=10;
	
	public static Object[][]  getTestData() throws IOException{
		File src= new File("C:\\Users\\pc\\workspace\\guru99\\src\\main\\java\\TestDaata\\TestDta.xlsx");
		FileInputStream fis =new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1=	wb.getSheetAt(0);
		int rows=sheet1.getLastRowNum();
		int cols=sheet1.getRow(0).getLastCellNum();
		System.out.println(rows);
		System.out.println(cols);
		Object[][] data= new Object[sheet1.getLastRowNum()][sheet1.getRow(0).getLastCellNum()];
		for (int i=0; i<sheet1.getLastRowNum();i++){
			
			for (int j=0;j<sheet1.getRow(0).getLastCellNum();j++){
				
				
				
				data[i][j]=sheet1.getRow(i+1).getCell(j).getStringCellValue();
				
				System.out.println(data[i][j]);
				System.out.println();
			}
			
			
		}
		return data;
		
		
		
		
	}
	
	public static void takescreenShotMethod(){
		
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			try {
				FileHandler.copy(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
		
		
	
	
	
	


