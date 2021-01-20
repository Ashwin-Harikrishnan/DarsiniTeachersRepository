package TestData;

import com.github.javafaker.Faker;



public class TestDataImport {
String[] testData;
String[] fakerData;
Faker faker = new Faker();

	public String[] getAddClassroomData() {
		testData = new String[6];
		testData[0] = ExcelDataImport.getValue(1, 0);//faker
		testData[1] = ExcelDataImport.getValue(1, 1);//subject
		testData[2] = ExcelDataImport.getValue(1, 2);//grade
		testData[3] = ExcelDataImport.getValue(1, 3);//year
		testData[4] = ExcelDataImport.getValue(1, 4);//duration
		testData[5] = ExcelDataImport.getValue(1, 5);//desc

				
		return testData;
	}
	
	public String[] getAddAssignmentData() {
		testData = new String[6];
		testData[0] = ExcelDataImport.getValue(1, 0);//title
		testData[1] = ExcelDataImport.getValue(1, 1);//Desc
		testData[2] = ExcelDataImport.getValue(1, 2);//upload
		testData[3] = ExcelDataImport.getValue(1, 3);//Date
		testData[4] = ExcelDataImport.getValue(1, 4);//comment
		testData[5] = ExcelDataImport.getValue(1, 5);//show parent
		
				
		return testData;
	}
	public String[] getAddAnnouncementData() {
		testData = new String[5];
		testData[0] = ExcelDataImport.getValue(1, 0);//title
		testData[1] = ExcelDataImport.getValue(1, 1);//Desc
		testData[2] = ExcelDataImport.getValue(1, 2);//upload
		testData[3] = ExcelDataImport.getValue(1, 3);//comment
		testData[4] = ExcelDataImport.getValue(1, 4);//showParent
		
		
				
		return testData;
	}
	public String[] getEditAssignmentData() {
		testData = new String[6];
		testData[0] = ExcelDataImport.getValue(6, 0);//title
		testData[1] = ExcelDataImport.getValue(6, 1);//Desc
		testData[2] = ExcelDataImport.getValue(6, 2);//upload
		testData[3] = ExcelDataImport.getValue(6, 3);//Date
		testData[4] = ExcelDataImport.getValue(6, 4);//comment
		testData[5] = ExcelDataImport.getValue(6, 5);//show parent
		
				
		return testData;
	}
	public String[] getEditAnnouncementData() {
		testData = new String[5];
		testData[0] = ExcelDataImport.getValue(6, 0);//title
		testData[1] = ExcelDataImport.getValue(6, 1);//Desc
		testData[2] = ExcelDataImport.getValue(6, 2);//upload
		testData[3] = ExcelDataImport.getValue(6, 3);//comment
		testData[4] = ExcelDataImport.getValue(6, 4);//showParent
		
		
				
		return testData;
	}
	
public String[] setFakerData() {
		
		fakerData = new String[2];
	
		ExcelDataImport.setValue(1, 0, faker.name().title());
		//ExcelDataImport.setValue(1, 1, faker.name().title());
		
		
		return fakerData;
		
	}
}

