/*
 * package generalUtilities;
 * 
 * import java.io.File; import java.io.FileInputStream; import
 * java.io.FileNotFoundException; import java.io.FileOutputStream; import
 * java.io.IOException;
 * 
 * import org.apache.poi.xssf.usermodel.XSSFCell; import
 * org.apache.poi.xssf.usermodel.XSSFRow; import
 * org.apache.poi.xssf.usermodel.XSSFSheet; import
 * org.apache.poi.xssf.usermodel.XSSFWorkbook;
 * 
 * public class ReadXlData {
 * 
 * public FileInputStream fis; public XSSFWorkbook wb; public XSSFSheet mySheet;
 * public int getRowCount(String filePath,String sheetName) throws IOException {
 * //String filePath="./Data/inputData.xlsx"; //File file=new File(filePath);
 * fis=new FileInputStream(filePath); wb=new XSSFWorkbook(); mySheet =
 * wb.getSheet(sheetName); int rowCount = mySheet.getLastRowNum(); wb.close();
 * fis.close(); return rowCount;
 * 
 * } public int getCellCount(String filePath,String sheetName,int rowNum) throws
 * IOException { fis=new FileInputStream(filePath); wb=new XSSFWorkbook();
 * mySheet = wb.getSheet(sheetName); XSSFRow row = mySheet.getRow(rowNum); int
 * cellnCount = row.getLastCellNum(); wb.close(); fis.close(); return
 * cellnCount; }
 * 
 * public static void setCellData(String filePath,String xlsheet,int rownum,int
 * colnum,String data) throws IOException { FileInputStream fis=new
 * FileInputStream(filePath); XSSFWorkbook wb=new XSSFWorkbook(fis); XSSFSheet
 * ws = wb.getSheet(xlsheet); XSSFRow row = ws.getRow(rownum);
 * 
 * XSSFCell cell = row.createCell(colnum); cell.setCellValue(data);
 * FileOutputStream fo = new FileOutputStream(filePath);
 * 
 * wb.write(fo); wb.close(); fis.close(); fo.close(); }
 * 
 * public void readCellData(String filePath,String xlsheet) throws IOException {
 * FileInputStream fis=new FileInputStream(filePath); XSSFWorkbook wb=new
 * XSSFWorkbook(fis); XSSFSheet sheet = wb.getSheet(xlsheet); int
 * rowCount=sheet.getLastRowNum(); int
 * colCount=sheet.getRow(1).getLastCellNum(); for(int i=0;i<rowCount;i++) {
 * XSSFRow row = sheet.getRow(i); for (int j = 0; j <colCount; j++) { XSSFCell
 * cellValue = row.getCell(j); switch(cellValue.getCellType()) { case
 * STRING:System.out.print(cellValue.getStringCellValue());break; case
 * NUMERIC:System.out.print(cellValue.getNumericCellValue());break; case
 * BOOLEAN:System.out.print(cellValue.getBooleanCellValue());break;
 * 
 * } System.out.print(" | "); }System.out.println(); }
 * 
 * }
 * 
 * public static void main(String[] args) throws IOException { ReadXlData
 * rdxl=new ReadXlData(); rdxl.readCellData(
 * "C:\\Users\\salman\\workspace\\AmazonPortal\\Data\\Book1.xlsx", "Sheet1"); }
 * 
 * }
 */