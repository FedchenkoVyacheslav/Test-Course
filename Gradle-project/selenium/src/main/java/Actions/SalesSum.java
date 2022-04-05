package Actions;
import Elements.Table;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SalesSum {
    public static float getSalesSum(Table table) {
        List<List<WebElement>> rowsWithColumns = table.getRowsWithColumns();
        float sum = 0;
        for (List<WebElement> rowsWithColumn : rowsWithColumns) {
            WebElement cell = rowsWithColumn.get(4);
            float cellValue = Float.parseFloat(cell.getText().substring(1));
            sum += cellValue;
        }
        return sum;
    }
}
