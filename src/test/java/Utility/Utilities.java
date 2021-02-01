package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.TestNG;

import BaseClass.BaseClass;

public class Utilities extends BaseClass {
	TakesScreenshot takeScreenshot;
	File source, destination, dir;
	File[] files;
	byte[] buffer;
	FileOutputStream fos;
	ZipOutputStream zos;
	FileInputStream fis;
	int length;
	String screenshotPath = "";	
	public String[] directoryPath = {"C:/Automation_TestLogs","C:/DarsiniTeachers_Automation","C:/DarsiniTeachers_Automation/Logs", "C:DarsiniTeachers_Automation/Reports", 
			"C:/Project_Name/Reports/Report_"+reportTimestamp,"C:/Project_Name/Report_Zip","C:/Project_Name/Report_Zip/Report_"+reportTimestamp};
	String zipFile="C:/Project_Name/Report_Zip/Report_"+reportTimestamp+".zip";
	
	public String getScreenshot(WebDriver driver, String screenshotName) {
		try {
			takeScreenshot = (TakesScreenshot) driver;
			source = takeScreenshot.getScreenshotAs(OutputType.FILE);
			screenshotPath = reportDir+"/"+screenshotName+".png";
			destination = new File(screenshotPath);
			FileUtils.copyFile(source, destination);
			String[] relatvePath = destination.toString().split("Report_"+reportTimestamp);
	        screenshotPath = ".\\" + relatvePath[1];
		}catch(Exception e) {
			e.printStackTrace();
		}
		return screenshotPath;
	}
	
	public void createDirectoryIfNotExist() {
		try {
			for(int i=0;i<directoryPath.length;i++) {
				directory = new File(directoryPath[i]);
			    if (! directory.exists()){			    	
			        directory.mkdir();
			    }
			}			
		}catch(Exception e) {
			e.printStackTrace();
			//log.info(e);
		}		
	}
	
	public void createZip(String source) {
		try {			
			buffer = new byte[1024];			 
            fos = new FileOutputStream(zipFile); 
            zos = new ZipOutputStream(fos); 
            dir = new File(source); 
            files = dir.listFiles();
			
            for (int i = 0; i < files.length; i++) {
            	 fis = new FileInputStream(files[i]);
            	 zos.putNextEntry(new ZipEntry(files[i].getName()));
            	             	 
                 while ((length = fis.read(buffer)) > 0) {
                     zos.write(buffer, 0, length);
                 }
                 zos.closeEntry();
                 fis.close();
            }
            zos.close();			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void failedTestRunner() {
		try {
			TestNG runner = new TestNG();
			List<String> failedXML = new ArrayList<String>();
			failedXML.add(projectFolder+"/test-output/testng-failed.xml");
			runner.setTestSuites(failedXML);
			runner.run();		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}