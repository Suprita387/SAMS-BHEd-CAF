package com.BHEd.Tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BHEd.GenericLibrary.constants;
import com.BHEd.Listeners.ExtentFactory;
import com.BHEd.ObjectRepository.BHEdCAF;
import com.BHEd.ObjectRepository.BHEdData;
import com.BHEd.ObjectRepository.BHEdLogin;
import com.BHEd.ObjectRepository.BaseClass;
import com.BHEd.browser.BrowserFactoryNew;

public class AgeCriteriaForTransgenderApplicants extends BaseClass implements BHEdData {

	XSSFWorkbook wb;
	XSSFSheet sht;
	String sheetName = "Result";
	int rowCount = constants.fileone.getRowCount(sheetName);

	@Test(priority = 0)
	public void Login() throws Exception {

		BHEdLogin login = new BHEdLogin(driver);

		BrowserFactoryNew bc = new BrowserFactoryNew();
		bc.Login(MobileNumber, Password);
		Thread.sleep(3000);

		login.ApplicationFormButton().click();
		Thread.sleep(1000);
		login.Close().click();
		Thread.sleep(1000);
		login.BrochureYes().click();
		Thread.sleep(1000);
		login.SelectCourse(SelectCourse4);
		Thread.sleep(1000);
	}

	@Test(priority = 1)
	public void TransgenderApplicantBornBeforeAgeAsOn() throws Exception {

		//logger = report.createTest("Trandgender Male Applicant Born Before Age As On");

		BHEdCAF Form = new BHEdCAF(driver);
		Thread.sleep(1000);
		Form.TenthBoard(TenthBoard);
		Thread.sleep(1000);
		Form.TenthYOP(TenthYOP);
		Thread.sleep(1000);
		Form.Annual().click();
		Thread.sleep(1000);
		Form.GraduationPassed().click();
		Thread.sleep(1000);
		Form.TenthRollNo().sendKeys(TenthRollNumber);
		Thread.sleep(3000);
		Form.MotherName().click();
		Thread.sleep(1000);
		Form.MotherName().sendKeys(MotherName);
		Thread.sleep(1000);
		Form.ApplicantName().sendKeys(ApplicantName);
		Thread.sleep(1000);
		Form.FatherSpouseGuardianName().sendKeys(FatherName);
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Selecting Gender As Transgender");
		Form.Gender(GenderT);
		Thread.sleep(1000);

		ExtentFactory.getInstance().getExtent().info("Selecting DOB Before Valid Date For Transgender Applicant");
		Form.TransgenderBornBefore();
		Thread.sleep(1000);
		Form.AadhaarNumber().sendKeys(AadhaarNo);
		Thread.sleep(1000);
		Form.SocialCategory(SocialCategoryG);

		Thread.sleep(1000);
		String msg = Form.GetMsg();
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (msg.equals("Date Of Birth Should be On or  After 31-Aug-1993")) {
			System.out.println(msg);
			Thread.sleep(3000);
			Form.JavaAcceptAlert();

			constants.fileone.setCellData(sheetName, "Status", 107, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 107, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "Date Of Birth Should be On or  After 31-Aug-1993");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully Checked Transgender Applicant Born Before Age As On Scenario");

	}

	@Test(priority = 2)
	public void PWDTransgenderApplicantBornBeforeAgeAsOn() throws Exception {

		//logger = report.createTest("PWD Transgender Applicant Born Before Age As On");

		BHEdLogin login = new BHEdLogin(driver);
		Thread.sleep(3000);
		login.ApplicationFormButton().click();
		Thread.sleep(1000);
		login.Close().click();
		Thread.sleep(1000);
		login.BrochureYes().click();
		Thread.sleep(1000);
		login.SelectCourse(SelectCourse4);
		Thread.sleep(1000);

		BHEdCAF Form = new BHEdCAF(driver);
		Thread.sleep(1000);
		Form.TenthBoard(TenthBoard);
		Thread.sleep(1000);
		Form.TenthYOP(TenthYOP);
		Thread.sleep(1000);
		Form.Annual().click();
		Thread.sleep(1000);
		Form.GraduationPassed().click();
		Thread.sleep(1000);
		Form.TenthRollNo().clear();
		Form.TenthRollNo().sendKeys(TenthRollNumber);
		Thread.sleep(3000);
		Form.MotherName().click();
		Thread.sleep(1000);
		Form.MotherName().sendKeys(MotherName);
		Thread.sleep(1000);
		Form.ApplicantName().sendKeys(ApplicantName);
		Thread.sleep(1000);
		Form.FatherSpouseGuardianName().sendKeys(FatherName);
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Selecting Gender As Transgender");
		Form.Gender(GenderT);
		Thread.sleep(1000);

		ExtentFactory.getInstance().getExtent().info("Selecting DOB Before Valid Date For PWD Transgender Applicant");
		Form.PWDTransgenderBornBefore();
		Thread.sleep(1000);
		Form.ReserveCategory(ReserveCategoryPH);
		Thread.sleep(1000);
		Form.SocialCategory(SocialCategoryG);

		Thread.sleep(1000);
		String msg = Form.GetMsg();
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (msg.equals("Date Of Birth Should be On or  After 31-Aug-1983")) {
			System.out.println(msg);
			Form.JavaAcceptAlert();

			constants.fileone.setCellData(sheetName, "Status", 108, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 108, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "Date Of Birth Should be On or  After 31-Aug-1983");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully Checked PWD Transgender Applicant Born Before Age As On Scenario");

	}

	@Test(priority = 3)
	public void TransgenderApplicantBornOnAgeAsOn() throws Exception {

		//logger = report.createTest("Transgender Male Applicant Born On Age As On");

		BHEdLogin login = new BHEdLogin(driver);
		Thread.sleep(3000);
		login.ApplicationFormButton().click();
		Thread.sleep(1000);
		login.Close().click();
		Thread.sleep(1000);
		login.BrochureYes().click();
		Thread.sleep(1000);
		login.SelectCourse(SelectCourse4);
		Thread.sleep(1000);

		BHEdCAF Form = new BHEdCAF(driver);
		Thread.sleep(1000);
		Form.TenthBoard(TenthBoard);
		Thread.sleep(1000);
		Form.TenthYOP(TenthYOP);
		Thread.sleep(1000);
		Form.Annual().click();
		Thread.sleep(1000);
		Form.GraduationPassed().click();
		Thread.sleep(1000);
		Form.TenthRollNo().clear();
		Form.TenthRollNo().sendKeys(TenthRollNumber);
		Thread.sleep(3000);
		Form.MotherName().click();
		Thread.sleep(1000);
		Form.MotherName().sendKeys(MotherName);
		Thread.sleep(1000);
		Form.ApplicantName().sendKeys(ApplicantName);
		Thread.sleep(1000);
		Form.FatherSpouseGuardianName().sendKeys(FatherName);
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Selecting Gender As Transgender");
		Form.Gender(GenderT);
		Thread.sleep(1000);

		ExtentFactory.getInstance().getExtent().info("Selecting DOB Before Valid Date For Transgender Applicant");
		Form.TransgenderBornOn();
		Thread.sleep(1000);
		Form.AadhaarNumber().clear();
		Form.AadhaarNumber().sendKeys(AadhaarNo);
		Thread.sleep(1000);
		Form.SocialCategory(SocialCategoryG);
//		Thread.sleep(1000);
//		Form.ReserveCategory(ReserveCategoryS);
		Thread.sleep(1000);
		Form.MaritalStatus(MaritalStatusU);
		Thread.sleep(1000);
		Form.HindiQualificationCriteria(HindiQualification1);
		Thread.sleep(1000);
		Form.AddressLine1().clear();
		Form.AddressLine1().sendKeys(Add1);
		Thread.sleep(1000);
		Form.AddressLine2().clear();
		Form.AddressLine2().sendKeys(Add2);
		Thread.sleep(1000);
		Form.PresentState(StateO);
		Thread.sleep(1000);
		Form.PresentDistrict(District1);
		Thread.sleep(1000);
		Form.PresentPinCode().clear();
		Form.PresentPinCode().sendKeys(Pincode);
		Thread.sleep(1000);
		Form.SameAsPresent().click();
		Thread.sleep(1000);
		Form.OdiaStudied().click();
		
		Thread.sleep(1000);
		Form.TenthExamType(TenthExamName);
		Thread.sleep(1000);
		Form.TenthMarkType(MarkTypeM);
		Thread.sleep(1000);
		Form.TenthMaxMark().sendKeys(TenthMaxMark);
		Thread.sleep(1000);
		Form.TenthObtainedMark().sendKeys(TenthSecuredMark);
		Thread.sleep(1000);
		Form.TwelthExamPassed(TwelthExamName);
		Thread.sleep(1000);
		Form.TwelthBoard(TwelthBoardName);
		Thread.sleep(1000);
		Form.TwelthYOP(TwelthYOP);
		Thread.sleep(1000);
		Form.TwelthRollNo().sendKeys(TwelthRollNumber);
		Thread.sleep(1000);
		Form.TwelthMarkType(MarkTypeM);
		Thread.sleep(1000);
		Form.TwelthMaxMark().sendKeys(TwelthMaxMark);
		Thread.sleep(1000);
		Form.TwelthObtainedMark().sendKeys(TwelthSecuredMark);
		Thread.sleep(1000);
		Form.GraduationExamPassed(GraduationExamName);
		Thread.sleep(1000);
		Form.GraduationBoard(GraduationBoardName);
		Thread.sleep(1000);
		Form.GraduationYOP(GraduationYOP);
		Thread.sleep(1000);
		Form.GraduationRollNo().sendKeys(GradRollNumber);
		Thread.sleep(1000);
		Form.GraduationMarkType(MarkTypeM);
		Thread.sleep(1000);
		Form.GraduationMaxMark().sendKeys(GradMaxMark);
		Thread.sleep(1000);
		Form.GraduationObtainedMark().sendKeys(GradSecuredMark);
		Thread.sleep(1000);
		Form.PGExamPassed(PGExamName);
		Thread.sleep(1000);
		Form.PGBoard(PGBoardName);
		Thread.sleep(1000);
		Form.PGYOP(PGYOP);
		Thread.sleep(1000);
		Form.PGRollNo().sendKeys(PGRollNumber);
		Thread.sleep(1000);
		Form.PGMarkType(MarkTypeM);
		Thread.sleep(1000);
		Form.PGMaxMark().sendKeys(PGMaxMark);
		Thread.sleep(1000);
		Form.PGObtainedMark().sendKeys(PGSecuredMark);
		Thread.sleep(1000);

		Form.Submit().click();
		Thread.sleep(600);

		String msg = Form.GetMsg();
		Thread.sleep(600);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (msg.equals("Are you sure you want to proceed ?")) {
			System.out.println(msg);
			Form.JavaDismissAlert();

			constants.fileone.setCellData(sheetName, "Status", 109, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 109, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "Are you sure you want to proceed ?");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully Checked Transgender Applicant Born On Age As On");

	}

	@Test(priority = 4)
	public void PWDTransgenderApplicantBornOnAgeAsOn() throws Exception {

		//logger = report.createTest("PWD Transgender Applicant Born On Age As On");

		BHEdLogin login = new BHEdLogin(driver);
		Thread.sleep(3000);
		login.ApplicationFormButton().click();
		Thread.sleep(1000);
		login.Close().click();
		Thread.sleep(1000);
		login.BrochureYes().click();
		Thread.sleep(1000);
		login.SelectCourse(SelectCourse4);
		Thread.sleep(1000);

		BHEdCAF Form = new BHEdCAF(driver);
		Thread.sleep(1000);
		Form.TenthBoard(TenthBoard);
		Thread.sleep(1000);
		Form.TenthYOP(TenthYOP);
		Thread.sleep(1000);
		Form.Annual().click();
		Thread.sleep(1000);
		Form.GraduationPassed().click();
		Thread.sleep(1000);
		Form.TenthRollNo().clear();
		Form.TenthRollNo().sendKeys(TenthRollNumber);
		Thread.sleep(3000);
		Form.MotherName().click();
		Thread.sleep(1000);
		Form.MotherName().sendKeys(MotherName);
		Thread.sleep(1000);
		Form.ApplicantName().sendKeys(ApplicantName);
		Thread.sleep(1000);
		Form.FatherSpouseGuardianName().sendKeys(FatherName);
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Selecting Gender As Transgender");
		Form.Gender(GenderT);
		Thread.sleep(1000);

		ExtentFactory.getInstance().getExtent().info("Selecting DOB Before Valid Date For PWD Transgender Applicant");
		Form.PWDTransgenderBornOn();
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Selecting Reserve Category as PH");
		Form.ReserveCategory(ReserveCategoryPH);
		Thread.sleep(1000);
		Form.SocialCategory(SocialCategoryG);
		Thread.sleep(1000);
		Form.AadhaarNumber().clear();
		Form.AadhaarNumber().sendKeys(AadhaarNo);
		Thread.sleep(1000);
		Form.UDIDNumber().sendKeys(UDIDNumber);
		Thread.sleep(1000);
		Form.ScribeNeeded().click();
		Thread.sleep(1000);
		Form.DisabilityType(DisabilityTypeB);
		Thread.sleep(1000);
		Form.DisabilityPercent().sendKeys(DisabilityPerc2);
		Thread.sleep(1000);
		Form.MaritalStatus(MaritalStatusU);
		Thread.sleep(1000);
		Form.HindiQualificationCriteria(HindiQualification1);
		Thread.sleep(1000);
		Form.AddressLine1().clear();
		Form.AddressLine1().sendKeys(Add1);
		Thread.sleep(1000);
		Form.AddressLine2().clear();
		Form.AddressLine2().sendKeys(Add2);
		Thread.sleep(1000);
		Form.PresentState(StateO);
		Thread.sleep(1000);
		Form.PresentDistrict(District1);
		Thread.sleep(1000);
		Form.PresentPinCode().clear();
		Form.PresentPinCode().sendKeys(Pincode);
		Thread.sleep(1000);
		Form.SameAsPresent().click();
		Thread.sleep(1000);
		Form.OdiaStudied().click();
		
		Thread.sleep(1000);
		Form.TenthExamType(TenthExamName);
		Thread.sleep(1000);
		Form.TenthMarkType(MarkTypeM);
		Thread.sleep(1000);
		Form.TenthMaxMark().sendKeys(TenthMaxMark);
		Thread.sleep(1000);
		Form.TenthObtainedMark().sendKeys(TenthSecuredMark);
		Thread.sleep(1000);
		Form.TwelthExamPassed(TwelthExamName);
		Thread.sleep(1000);
		Form.TwelthBoard(TwelthBoardName);
		Thread.sleep(1000);
		Form.TwelthYOP(TwelthYOP);
		Thread.sleep(1000);
		Form.TwelthRollNo().sendKeys(TwelthRollNumber);
		Thread.sleep(1000);
		Form.TwelthMarkType(MarkTypeM);
		Thread.sleep(1000);
		Form.TwelthMaxMark().sendKeys(TwelthMaxMark);
		Thread.sleep(1000);
		Form.TwelthObtainedMark().sendKeys(TwelthSecuredMark);
		Thread.sleep(1000);
		Form.GraduationExamPassed(GraduationExamName);
		Thread.sleep(1000);
		Form.GraduationBoard(GraduationBoardName);
		Thread.sleep(1000);
		Form.GraduationYOP(GraduationYOP);
		Thread.sleep(1000);
		Form.GraduationRollNo().sendKeys(GradRollNumber);
		Thread.sleep(1000);
		Form.GraduationMarkType(MarkTypeM);
		Thread.sleep(1000);
		Form.GraduationMaxMark().sendKeys(GradMaxMark);
		Thread.sleep(1000);
		Form.GraduationObtainedMark().sendKeys(GradSecuredMark);
		Thread.sleep(1000);
		Form.PGExamPassed(PGExamName);
		Thread.sleep(1000);
		Form.PGBoard(PGBoardName);
		Thread.sleep(1000);
		Form.PGYOP(PGYOP);
		Thread.sleep(1000);
		Form.PGRollNo().sendKeys(PGRollNumber);
		Thread.sleep(1000);
		Form.PGMarkType(MarkTypeM);
		Thread.sleep(1000);
		Form.PGMaxMark().sendKeys(PGMaxMark);
		Thread.sleep(1000);
		Form.PGObtainedMark().sendKeys(PGSecuredMark);
		Thread.sleep(1000);

		Form.Submit().click();
		Thread.sleep(600);

		String msg = Form.GetMsg();
		Thread.sleep(600);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (msg.equals("Are you sure you want to proceed ?")) {
			System.out.println(msg);
			Form.JavaDismissAlert();

			constants.fileone.setCellData(sheetName, "Status", 110, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 110, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "Are you sure you want to proceed ?");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully Checked Transgender Applicant Born On Age As On Scenario");

	}

	@Test(priority = 5)
	public void TransgenderApplicantBornAfterAgeAsOn() throws Exception {

		//logger = report.createTest("Transgender Applicant Born After Age As On");

		BHEdLogin login = new BHEdLogin(driver);
		Thread.sleep(3000);
		login.ApplicationFormButton().click();
		Thread.sleep(1000);
		login.Close().click();
		Thread.sleep(1000);
		login.BrochureYes().click();
		Thread.sleep(1000);
		login.SelectCourse(SelectCourse4);
		Thread.sleep(1000);

		BHEdCAF Form = new BHEdCAF(driver);
		Thread.sleep(1000);
		Form.TenthBoard(TenthBoard);
		Thread.sleep(1000);
		Form.TenthYOP(TenthYOP);
		Thread.sleep(1000);
		Form.Annual().click();
		Thread.sleep(1000);
		Form.GraduationPassed().click();
		Thread.sleep(1000);
		Form.TenthRollNo().clear();
		Form.TenthRollNo().sendKeys(TenthRollNumber);
		Thread.sleep(3000);
		Form.MotherName().click();
		Thread.sleep(1000);
		Form.MotherName().sendKeys(MotherName);
		Thread.sleep(1000);
		Form.ApplicantName().sendKeys(ApplicantName);
		Thread.sleep(1000);
		Form.FatherSpouseGuardianName().sendKeys(FatherName);
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Selecting Gender As Transgender");
		Form.Gender(GenderT);
		Thread.sleep(1000);

		ExtentFactory.getInstance().getExtent().info("Selecting DOB After Valid Date For Transgender Applicant");
		Form.TransgenderBornAfter();
		Thread.sleep(1000);
		Form.AadhaarNumber().clear();
		Form.AadhaarNumber().sendKeys(AadhaarNo);
		Thread.sleep(1000);
		Form.SocialCategory(SocialCategoryG);
//		Thread.sleep(1000);
//		Form.ReserveCategory(ReserveCategoryS);
		Thread.sleep(1000);
		Form.MaritalStatus(MaritalStatusU);
		Thread.sleep(1000);
		Form.HindiQualificationCriteria(HindiQualification1);
		Thread.sleep(1000);
		Form.AddressLine1().clear();
		Form.AddressLine1().sendKeys(Add1);
		Thread.sleep(1000);
		Form.AddressLine2().clear();
		Form.AddressLine2().sendKeys(Add2);
		Thread.sleep(1000);
		Form.PresentState(StateO);
		Thread.sleep(1000);
		Form.PresentDistrict(District1);
		Thread.sleep(1000);
		Form.PresentPinCode().clear();
		Form.PresentPinCode().sendKeys(Pincode);
		Thread.sleep(1000);
		Form.SameAsPresent().click();
		Thread.sleep(1000);
		Form.OdiaStudied().click();
		
		Thread.sleep(1000);
		Form.TenthExamType(TenthExamName);
		Thread.sleep(1000);
		Form.TenthMarkType(MarkTypeM);
		Thread.sleep(1000);
		Form.TenthMaxMark().sendKeys(TenthMaxMark);
		Thread.sleep(1000);
		Form.TenthObtainedMark().sendKeys(TenthSecuredMark);
		Thread.sleep(1000);
		Form.TwelthExamPassed(TwelthExamName);
		Thread.sleep(1000);
		Form.TwelthBoard(TwelthBoardName);
		Thread.sleep(1000);
		Form.TwelthYOP(TwelthYOP);
		Thread.sleep(1000);
		Form.TwelthRollNo().sendKeys(TwelthRollNumber);
		Thread.sleep(1000);
		Form.TwelthMarkType(MarkTypeM);
		Thread.sleep(1000);
		Form.TwelthMaxMark().sendKeys(TwelthMaxMark);
		Thread.sleep(1000);
		Form.TwelthObtainedMark().sendKeys(TwelthSecuredMark);
		Thread.sleep(1000);
		Form.GraduationExamPassed(GraduationExamName);
		Thread.sleep(1000);
		Form.GraduationBoard(GraduationBoardName);
		Thread.sleep(1000);
		Form.GraduationYOP(GraduationYOP);
		Thread.sleep(1000);
		Form.GraduationRollNo().sendKeys(GradRollNumber);
		Thread.sleep(1000);
		Form.GraduationMarkType(MarkTypeM);
		Thread.sleep(1000);
		Form.GraduationMaxMark().sendKeys(GradMaxMark);
		Thread.sleep(1000);
		Form.GraduationObtainedMark().sendKeys(GradSecuredMark);
		Thread.sleep(1000);
		Form.PGExamPassed(PGExamName);
		Thread.sleep(1000);
		Form.PGBoard(PGBoardName);
		Thread.sleep(1000);
		Form.PGYOP(PGYOP);
		Thread.sleep(1000);
		Form.PGRollNo().sendKeys(PGRollNumber);
		Thread.sleep(1000);
		Form.PGMarkType(MarkTypeM);
		Thread.sleep(1000);
		Form.PGMaxMark().sendKeys(PGMaxMark);
		Thread.sleep(1000);
		Form.PGObtainedMark().sendKeys(PGSecuredMark);
		Thread.sleep(1000);

		Form.Submit().click();
		Thread.sleep(600);

		String msg = Form.GetMsg();
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (msg.equals("Are you sure you want to proceed ?")) {
			System.out.println(msg);
			Form.JavaDismissAlert();

			constants.fileone.setCellData(sheetName, "Status", 111, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 111, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "Are you sure you want to proceed ?");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully Checked Transgender Applicant Born After Age As On scenario");

	}

	@Test(priority = 6)
	public void PWDTransgenderApplicantBornAfterAgeAsOn() throws Exception {

		//logger = report.createTest("PWD Transgender Applicant Born After Age As On");

		BHEdLogin login = new BHEdLogin(driver);
		Thread.sleep(3000);
		login.ApplicationFormButton().click();
		Thread.sleep(1000);
		login.Close().click();
		Thread.sleep(1000);
		login.BrochureYes().click();
		Thread.sleep(1000);
		login.SelectCourse(SelectCourse4);
		Thread.sleep(1000);

		BHEdCAF Form = new BHEdCAF(driver);
		Thread.sleep(1000);
		Form.TenthBoard(TenthBoard);
		Thread.sleep(1000);
		Form.TenthYOP(TenthYOP);
		Thread.sleep(1000);
		Form.Annual().click();
		Thread.sleep(1000);
		Form.GraduationPassed().click();
		Thread.sleep(1000);
		Form.TenthRollNo().clear();
		Form.TenthRollNo().sendKeys(TenthRollNumber);
		Thread.sleep(3000);
		Form.MotherName().click();
		Thread.sleep(1000);
		Form.MotherName().sendKeys(MotherName);
		Thread.sleep(1000);
		Form.ApplicantName().sendKeys(ApplicantName);
		Thread.sleep(1000);
		Form.FatherSpouseGuardianName().sendKeys(FatherName);
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Selecting Gender As Transgender");
		Form.Gender(GenderT);
		Thread.sleep(1000);

		ExtentFactory.getInstance().getExtent().info("Selecting DOB After Valid Date For PWD Transgender Applicant");
		Form.PWDTransgenderBornAfter();

		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Selecting Reserve Category as PH");
		Form.ReserveCategory(ReserveCategoryPH);
		Thread.sleep(1000);
		Form.SocialCategory(SocialCategoryG);
		Thread.sleep(1000);
		Form.AadhaarNumber().clear();
		Form.AadhaarNumber().sendKeys(AadhaarNo);
		Thread.sleep(1000);
		Form.UDIDNumber().clear();
		Form.UDIDNumber().sendKeys(UDIDNumber);
		Thread.sleep(1000);
		Form.ScribeNeeded().click();
		Thread.sleep(1000);
		Form.DisabilityType(DisabilityTypeB);
		Thread.sleep(1000);
		Form.DisabilityPercent().clear();
		Form.DisabilityPercent().sendKeys(DisabilityPerc2);
		Thread.sleep(1000);
		Form.MaritalStatus(MaritalStatusU);
		Thread.sleep(1000);
		Form.HindiQualificationCriteria(HindiQualification1);
		Thread.sleep(1000);
		Form.AddressLine1().clear();
		Form.AddressLine1().sendKeys(Add1);
		Thread.sleep(1000);
		Form.AddressLine2().clear();
		Form.AddressLine2().sendKeys(Add2);
		Thread.sleep(1000);
		Form.PresentState(StateO);
		Thread.sleep(1000);
		Form.PresentDistrict(District1);
		Thread.sleep(1000);
		Form.PresentPinCode().clear();
		Form.PresentPinCode().sendKeys(Pincode);
		Thread.sleep(1000);
		Form.SameAsPresent().click();
		Thread.sleep(1000);
		Form.OdiaStudied().click();
		
		Thread.sleep(1000);
		Form.TenthExamType(TenthExamName);
		Thread.sleep(1000);
		Form.TenthMarkType(MarkTypeM);
		Thread.sleep(1000);
		Form.TenthMaxMark().sendKeys(TenthMaxMark);
		Thread.sleep(1000);
		Form.TenthObtainedMark().sendKeys(TenthSecuredMark);
		Thread.sleep(1000);
		Form.TwelthExamPassed(TwelthExamName);
		Thread.sleep(1000);
		Form.TwelthBoard(TwelthBoardName);
		Thread.sleep(1000);
		Form.TwelthYOP(TwelthYOP);
		Thread.sleep(1000);
		Form.TwelthRollNo().sendKeys(TwelthRollNumber);
		Thread.sleep(1000);
		Form.TwelthMarkType(MarkTypeM);
		Thread.sleep(1000);
		Form.TwelthMaxMark().sendKeys(TwelthMaxMark);
		Thread.sleep(1000);
		Form.TwelthObtainedMark().sendKeys(TwelthSecuredMark);
		Thread.sleep(1000);
		Form.GraduationExamPassed(GraduationExamName);
		Thread.sleep(1000);
		Form.GraduationBoard(GraduationBoardName);
		Thread.sleep(1000);
		Form.GraduationYOP(GraduationYOP);
		Thread.sleep(1000);
		Form.GraduationRollNo().sendKeys(GradRollNumber);
		Thread.sleep(1000);
		Form.GraduationMarkType(MarkTypeM);
		Thread.sleep(1000);
		Form.GraduationMaxMark().sendKeys(GradMaxMark);
		Thread.sleep(1000);
		Form.GraduationObtainedMark().sendKeys(GradSecuredMark);
		Thread.sleep(1000);
		Form.PGExamPassed(PGExamName);
		Thread.sleep(1000);
		Form.PGBoard(PGBoardName);
		Thread.sleep(1000);
		Form.PGYOP(PGYOP);
		Thread.sleep(1000);
		Form.PGRollNo().sendKeys(PGRollNumber);
		Thread.sleep(1000);
		Form.PGMarkType(MarkTypeM);
		Thread.sleep(1000);
		Form.PGMaxMark().sendKeys(PGMaxMark);
		Thread.sleep(1000);
		Form.PGObtainedMark().sendKeys(PGSecuredMark);
		Thread.sleep(1000);

		Form.Submit().click();
		Thread.sleep(600);

		String msg = Form.GetMsg();
		Thread.sleep(600);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (msg.equals("Are you sure you want to proceed ?")) {
			System.out.println(msg);
			Form.JavaDismissAlert();

			constants.fileone.setCellData(sheetName, "Status", 112, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 112, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "Are you sure you want to proceed ?");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully Checked PWD Transgender Applicant Born After Age As On Scenario");

	}
}