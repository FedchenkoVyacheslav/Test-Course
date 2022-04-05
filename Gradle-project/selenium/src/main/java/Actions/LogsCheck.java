package Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;

public class LogsCheck {
    WebDriver driver;

    public LogsCheck (WebDriver driver) {
        this.driver = driver;
    }

    public LogEntries getBrowserLogs () {
        Logs logs = driver.manage().logs();
        LogEntries logEntries = logs.get(LogType.BROWSER);
        for (LogEntry logEntry : logEntries) {
            System.out.println(logEntry.getMessage());
        }
        return logEntries;
    }

    public static void checkLogs(LogEntries logEntries, String message) {
        for (LogEntry logEntry: logEntries) {
            if (logEntry.getMessage().contains(message)) System.out.println("Message exists");
            else System.out.println("ERROR!");
        }
    }
}
