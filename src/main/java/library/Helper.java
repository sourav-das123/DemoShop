package library;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Helper {

    private static String projectdirectory = System.getProperty("user.dir");

    public static String CaptureScreenshot(WebDriver driver)
    {
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String screenshotpath = projectdirectory+"\\screenshots\\scrprint "+getcurrentdatetime()+".png";
        try
        {
            FileHandler.copy(source, new File(screenshotpath));
        }
        catch (IOException e)
        {
            e.getMessage();
        }

        return screenshotpath;
    }

    public static String getcurrentdatetime()
    {
        DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date currentdate = new Date();
        return customformat.format(currentdate);

    }

}