package com.crm.qa.testcases.util;

import com.crm.qa.testcases.base.TestBase;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 20;

    public static long IMPLICIT_WAIT = 10;


    public static String path = "C:\\Users\\DRAGAN22\\IdeaProjects\\CRMProject\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmData.xlsx";
    static Workbook book;
    static Sheet sheet;


    public void switchToFrame() {

        driver.switchTo().frame("mainpanel");


    }

    public static Object[][] getTestData(String sheetName) {
        Workbook book;
        Sheet sheet = null;

        Object data[][] = null;
        try {
            FileInputStream ip = new FileInputStream(path);
            book = WorkbookFactory.create(ip);
            sheet = book.getSheet(sheetName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }

        return data;
    }

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }



}


