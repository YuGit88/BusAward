package com.zz80z.busAward.common.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;



/**
 * 操作Excel表格
 * 
 * @author Administrator
 */
public class ExcelUtils {

	private final static String xls = "xls";
	private final static String xlsx = "xlsx";

	/**
	 * 生成导入模板
	 * 
	 * @param response
	 * @param request
	 * @param fileName文件名
	 * @param header标题名
	 * @param columns列名
	 * @throws IOException
	 */
	public static void creatExcel(HttpServletResponse response, HttpServletRequest request, String fileName,
			String header, List<String> columns) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/vnd.ms-excel");
		OutputStream out = response.getOutputStream();
		// 报头用于提供一个推荐的文件名，并强制浏览器显示保存对话框,并设置文件名
		response.setHeader("Content-Disposition",
				"attachment; filename=" + new String(fileName.getBytes(), "ISO8859-1"));
		// 创建workbook工作薄
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		HSSFCellStyle hssfCellStyle = (HSSFCellStyle) workbook.createCellStyle();
		hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 居中显示
		hssfCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 纵向居中
		// 创建行
		Row row0 = sheet.createRow(0);
		// 参数说明：1：开始行 2：结束行 3：开始列 4：结束列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, columns.size() - 1));
		// 设置表头名字
		Cell cell = row0.createCell(0);
		cell.setCellValue(header);
		cell.setCellStyle(hssfCellStyle);

		// 循环给列名赋值
		Row row = sheet.createRow(1);
		for (int i = 0; i < columns.size(); i++) {
			Cell cells = row.createCell(i);
			cells.setCellValue(new String(columns.get(i).getBytes(), "GB2312"));
			cells.setCellStyle(hssfCellStyle);
		}

		workbook.write(out);
		out.flush();
		out.close();
	}

	/**
	 * 读入excel文件，解析后返回
	 * 
	 * @param file
	 * @throws IOException
	 */
	public static List<Map<String, String>> readExcel(MultipartFile file) throws IOException {
		// 检查文件
		checkFile(file);
		// 获得Workbook工作薄对象
		Workbook workbook = getWorkBook(file);
		// 创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		if (workbook != null) {
			for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
				// 获得当前sheet工作表
				Sheet sheet = workbook.getSheetAt(sheetNum);
				if (sheet == null) {
					continue;
				}
				// 获得当前sheet的开始行
				int firstRowNum = sheet.getFirstRowNum();
				// 获得当前sheet的结束行
				int lastRowNum = sheet.getLastRowNum();
				// 循环除了第一行的所有行的数据
				for (int rowNum = firstRowNum + 2; rowNum <= lastRowNum; rowNum++) {
					Map<String, String> map = new HashMap<String, String>();
					// 获得第二行列名
					Row row2 = sheet.getRow(1);
					// 获得第三行之后的内容
					Row row = sheet.getRow(rowNum);
					if (row == null) {
						continue;
					}
					// 获得当前行的开始列
					int firstCellNum = row.getFirstCellNum();
					// 获得当前行的列数
					int lastCellNum = row.getPhysicalNumberOfCells();

					// 循环第三行之后的表格的内容
					for (int cellNum = firstCellNum; cellNum <= lastCellNum; cellNum++) {

						Cell cell2 = row2.getCell(cellNum);
						Cell cell = row.getCell(cellNum);
						// 把第二行列名做为map的Key,内容循环做为Value
						map.put(getCellValue(cell2), getCellValue(cell));
						
					}
					list.add(map);
				}
			}
		}
		return list;
	}

	
	public static void checkFile(MultipartFile file) throws IOException {
		// 判断文件是否存在
		if (null == file) {
			LoggerUtils.error(ExcelUtils.class, "文件不存在！");
			throw new FileNotFoundException("文件不存在！");
		}
		// 获得文件名
		String fileName = file.getOriginalFilename();
		// 判断文件是否是excel文件
		if (!fileName.endsWith(xls) && !fileName.endsWith(xlsx)) {
			LoggerUtils.error(ExcelUtils.class, "不是excel文件");
			throw new IOException(fileName + "不是excel文件");
		}
	}

	
	public static Workbook getWorkBook(MultipartFile file) {
		// 获得文件名
		String fileName = file.getOriginalFilename();
		// 创建Workbook工作薄对象，表示整个excel
		Workbook workbook = null;
		InputStream is = null;
		try {
			// 获取excel文件的io流
			is = file.getInputStream();
			// 根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
			if (fileName.endsWith(xls)) {
				// 2003
				workbook = new HSSFWorkbook(is);
			} else if (fileName.endsWith(xlsx)) {
				// 2007 及2007以上
				workbook = new XSSFWorkbook(is);
			}
		} catch (IOException e) {
			LoggerUtils.error(ExcelUtils.class, e.getMessage());
		}finally {
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return workbook;
	}

	
	public static String getCellValue(Cell cell) {
		String cellValue = "";
		if (cell == null) {
			return cellValue;
		}
		// 把数字当成String来读，避免出现1读成1.0的情况
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
		}
		// 判断数据的类型
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC: // 数字
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case Cell.CELL_TYPE_STRING: // 字符串
			cellValue = String.valueOf(cell.getStringCellValue());
			break;
		case Cell.CELL_TYPE_BOOLEAN: // Boolean
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_FORMULA: // 公式
			cellValue = String.valueOf(cell.getCellFormula());
			break;
		case Cell.CELL_TYPE_BLANK: // 空值
			cellValue = "";
			break;
		case Cell.CELL_TYPE_ERROR: // 故障
			cellValue = "非法字符";
			break;
		default:
			cellValue = "未知类型";
			break;
		}
		return cellValue;
	}

}
