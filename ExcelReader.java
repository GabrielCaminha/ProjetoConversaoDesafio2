import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    public static List<Double> lerColuna(String caminho, int colunaIndex) {
        List<Double> valores = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(new File(caminho));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);  // Assumindo que os dados estão na primeira aba

            for (Row row : sheet) {
                Cell cell = row.getCell(colunaIndex);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    valores.add(cell.getNumericCellValue());
                }
            }
            workbook.close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valores;
    }
}
