package Actions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {
    public static void takeScreenshot(WebDriver driver){
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy_hh.mm.ss");
        String fileName = format.format(dateNow) + ".png";

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Screenshots\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
