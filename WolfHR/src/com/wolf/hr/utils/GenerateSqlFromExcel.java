
package com.wolf.hr.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;



import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;

public class GenerateSqlFromExcel {

	
	/**
	 * 导入报表Excel数据，生成Performance表的数据库导入语句
	 * @param formFile
	 * @return list ArrayList
	 * @throws Exception
	 */
	public static ArrayList generateStationBugSql(File formFile)
			throws Exception {
		InputStream in = null;//定义一个输入流
		Workbook wb = null;//
		ArrayList list = new ArrayList();
		
		try {
			if (formFile == null) {
				throw new Exception("文件为空！");
			}

			in = new FileInputStream(formFile);//用输入流解析Excel文件到输入流
			
			wb = Workbook.getWorkbook(in);//把输入流放到workbook.getWorkbook()方法中
			
			Sheet sheet[] = wb.getSheets();
			if (sheet != null) {
				for (int i = 0; i < sheet.length; i++) {
					if (!sheet[i].getName().equalsIgnoreCase("Performance")) {	//sheet的名称					
						throw new Exception("指定文件中不包含名称为Performance的sheet,请重新指定！");
					}
					//j从一开始是因为表头不要
					for (int j = 1; j < sheet[i].getRows(); j++) {
						String[] valStr = new String[12];//这个数组对应着Excel中数据的列数11列
						for (int k = 0; k < sheet[i].getColumns(); k++) {
							Cell cell = sheet[i].getCell(k, j);
							String content = "";
							//对excel中的内容为日期进行处理
							if (cell.getType() == CellType.DATE) {
								DateCell dateCell = (DateCell) cell;
								java.util.Date importdate = dateCell.getDate();/**如果excel是日期格式的话需要减去8小时*/
								long eighthour = 8*60*60*1000;
								SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
								/**在当前日期上减8小时*/
								long time = importdate.getTime()-eighthour; 
								java.util.Date date = new java.util.Date();
								date.setTime(time);
								content = simpledate.format(date); 
							} 
							else //否则就当常规类型处理
							{
								//临时的内容被处理
								String tempcontent = (cell.getContents() == null ? ""
										: cell.getContents());
								content = tempcontent.trim().replace('\'', ' ');
							}
							valStr[k] = content;//处理完的内容放到数组里面
							
						} 
						list.add(j-1,valStr);
					}
				}
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (wb != null) {
				wb.close();
			}
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
