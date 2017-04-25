package com.gjyl.appserver.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by LiD on 2017/4/24.
 */
public class ExcelUtil {

    public static List<Object> getDataFromExcel(HttpServletRequest request, Class<?> clazz) throws IOException {

        //反射处理类
        int propertyNum = getPropertyNum(clazz);
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("fields长度:" + fields.length);
        String realName = "";
        //Excel文件处理,保存到本地
        CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getServletContext());
        if (resolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (!file.isEmpty()) {
                    realName = getRealName(file.getOriginalFilename());
                    String parentPath = request.getServletContext().getRealPath("/files");
                    File fd = new File(parentPath);
                    if (!fd.exists()) {
                        fd.mkdirs();
                    }
                    //存盘
                    file.transferTo(new File(parentPath, realName));
                }
            }
        }

        ServletInputStream inputStream = request.getInputStream();
        if (inputStream.isFinished()) {//上传结束后,获取文件全路径
            String realPath = request.getServletContext().getRealPath("/files/" + realName);
            System.out.println("realPath==============\n" + realPath);
            if ((!realName.endsWith(".xls")) && (!realName.endsWith(".xlsx"))) {
                System.out.println("文件不是Excel表格..............");
                return null;
            }
            FileInputStream fis;
            Workbook workbook;
            try {
                fis = new FileInputStream(realPath);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("文件不存在.........");
                return null;
            }

            try {
                //2003版本的excel，用.xls结尾
                workbook = new HSSFWorkbook(fis);
            } catch (Exception e) {
                //e.printStackTrace();
                try {
                    fis = new FileInputStream(realPath);
                    //2007版本的excel，用.xlsx结尾
                    workbook = new XSSFWorkbook(fis);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return null;
                }
            }

            //得到一个工作表
            Sheet sheet = workbook.getSheetAt(0);
            //得到表头
            Row th = sheet.getRow(0);

            //根据不同的data放置不同的表头
            Map<Object, Integer> headMap = new HashMap<>();

            if (th.getPhysicalNumberOfCells() > propertyNum) {
                System.out.println("表格表头格式不对...............");
                return null;
            }


            try {//列名与下标对应
                for (int i = 0; i < th.getPhysicalNumberOfCells(); i++) {
                    Cell cell = th.getCell(i);
                    for (int j = 0; j < fields.length; j++) {
                        Field f = fields[j];
                        if (getECellType(cell).toString().equals(f.getName())) {
                            headMap.put(f.getName(), i);
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("表格不符合规范,请检查后重新导入.....");
            }
            System.out.println("headMap:"+headMap);
            //获得数据的总行数
            int totalRowNum = sheet.getLastRowNum();
            //获取所有数据
            for (int i=1;i<totalRowNum;i++){//循环行
                Row row=sheet.getRow(i);
                for (int j=0;j<row.getPhysicalNumberOfCells();j++){//循环列
                    for (int k=0;k<fields.length;k++){//循环属性
                        Field f=fields[i];
                        if (getECellType(row.getCell(j)).toString().equals(f.getName())){
                            //取出相应单元格的数据,对属性赋值
                            Integer integer = headMap.get(f.getName());
                            Cell cell = row.getCell(integer);
                            Object cellType = getECellType(cell);
                            System.out.println(cellType+"..............");
                        }

                    }
                }

            }

        }
        return null;


    }

    /**
     * 获取clazz的属性数量
     * @param clazz
     * @return
     */
    private static int getPropertyNum(Class<?> clazz){
        Field[] fields = clazz.getDeclaredFields();
        return fields.length;
    }

//    private



    /**
     *
     * @param cell 一个单元格的对象
     * @return 返回该单元格相应的类型的值
     */
    private static Object getECellType(Cell cell){

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

    // 得到上传文件真实名称 c:\a.txt a.txt
    private static String getRealName(String filename) {

        int index = filename.lastIndexOf("\\") + 1;

        return filename.substring(index);

    }


}
