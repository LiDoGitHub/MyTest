package com.gjyl.appserver.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiD on 2017/4/24.
 */
public class ExcelUtil {

    public List<Object> getDataFromExcel(HttpServletRequest request,Class<?> clazz) throws IOException {

        int propertyNum=getPropertyNum(clazz);
        String filePath = FileUploadUtils.uploadFile(request);
        if ((!filePath.endsWith(".xls"))&&(!filePath.endsWith(".xlsx"))){
            System.out.println("文件不是Excel表格..............");
            return null;
        }
        FileInputStream fis = null;
        Workbook workbook=null;
        int flag=0;
        try {
            fis=new FileInputStream(filePath);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            //2003版本的excel，用.xls结尾
            workbook=new HSSFWorkbook(fis);
        }catch (Exception e){
            //e.printStackTrace();
            try {
                fis = new FileInputStream(filePath);
                //2007版本的excel，用.xlsx结尾
                workbook=new XSSFWorkbook(fis);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        //得到一个工作表
        Sheet sheet = workbook.getSheetAt(0);
        //得到表头
        Row th = sheet.getRow(0);

        //根据不同的data放置不同的表头
        Map<Object,Integer> headMap = new HashMap<>();

        if (th.getPhysicalNumberOfCells()>propertyNum){
            System.out.println("表格表头格式不对...............");
            return null;
        }


        try {//列名与下标对应
            while (flag<propertyNum){
                Cell cell=th.getCell(flag);
                System.out.println(cell.getCellType());
                if (getECellType(cell).toString().equals("")){

                }
                flag++;
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("表格不符合规范,请检查后重新导入.....");
        }

        return null;
    }

    /**
     * 获取clazz的属性数量
     * @param clazz
     * @return
     */
    private int getPropertyNum(Class<?> clazz){
        Field[] fields = clazz.getDeclaredFields();
        return fields.length;
    }

//    private



    /**
     *
     * @param cell 一个单元格的对象
     * @return 返回该单元格相应的类型的值
     */
    private Object getECellType(Cell cell){

        Object object = null;
        switch(cell.getCellType())
        {
            case Cell.CELL_TYPE_STRING :
            {
                object=cell.getStringCellValue();
                break;
            }
            case Cell.CELL_TYPE_NUMERIC :
            {
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                object=cell.getNumericCellValue();
                break;
            }

            case Cell.CELL_TYPE_FORMULA :
            {
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                object=cell.getNumericCellValue();
                break;
            }

            case Cell.CELL_TYPE_BLANK :
            {
                cell.setCellType(Cell.CELL_TYPE_BLANK);
                object=cell.getStringCellValue();
                break;
            }
        }
        return object;
    }


}
