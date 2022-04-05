package Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
    private final WebElement tableElement;

    public Table(WebElement tableElement, WebDriver driver) {
        this.tableElement = tableElement;
    }
// array of rows without header row
    public List<WebElement> getRows() {
        return tableElement.findElements(By.xpath("//div/tr"));
    }
// header elements array
    public List<WebElement> getHeadings() {
        WebElement headingsRow = tableElement.findElement(By.xpath(".//tr[1]"));
        return headingsRow.findElements(By.xpath(".//td"));
    }
// array of rows with elements
    public List<List<WebElement>> getRowsWithColumns() {
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
        for (WebElement row:rows) {
            List<WebElement> rowWithColumns = row.findElements(By.xpath(".//td"));
            rowsWithColumns.add(rowWithColumns);
        }
        return rowsWithColumns;
    }
// array of Map: rows with elements by headers
    public List<Map<String, WebElement>> getRowsWithColumnsByHeadings(){

        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = new ArrayList<Map<String, WebElement>>();
        Map<String, WebElement> rowByHeadings;
        List<WebElement> headingColumns = getHeadings();

        for (List<WebElement> row : rowsWithColumns){
            rowByHeadings = new HashMap<String, WebElement>();
            for (int i = 0; i < headingColumns.size(); i++){
                String heading = headingColumns.get(i).getText();
                WebElement cell = row.get(i);
                rowByHeadings.put(heading, cell);
            }
            rowsWithColumnsByHeadings.add(rowByHeadings);
        }
        return rowsWithColumnsByHeadings;
    }

    public String getValueFromCell(int rowNumber, int columnNumber){
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        WebElement cell = rowsWithColumns.get(rowNumber - 1).get(columnNumber - 1);
        return cell.getText();
    }

    public String getValueFromCell(int rowNumber, String columnName){
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = getRowsWithColumnsByHeadings();
        return rowsWithColumnsByHeadings.get(rowNumber - 1).get(columnName).getText();
    }
}
