package hbi.core.util;

import hbi.core.dto.OrdersExcel;
import org.apache.poi.hssf.usermodel.*;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Alen on 2016/12/17.
 */
public class Excel {
    public static String Export(List<String> header,List<?> list) throws IllegalAccessException {
        String status="导入失败";
        // 声明一个工作薄
        HSSFWorkbook wb = new HSSFWorkbook();
        //声明一个单子并命名
        HSSFSheet sheet = wb.createSheet();
        //给单子名称一个长度
        sheet.setDefaultColumnWidth((short)15);
        // 生成一个样式
        HSSFCellStyle style = wb.createCellStyle();
        //创建表头
        HSSFRow row = sheet.createRow(0);
        //样式字体居中
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        for(short i = 0; i < header.size(); i++){
            HSSFCell cell = row.createCell((short) i);
            cell.setCellValue(header.get(i));
            cell.setCellStyle(style);
        }

        //向单元格里填充数据
        for (short i = 0; i < list.size(); i++) {
            row = sheet.createRow(i + 1);

            Field[] fields = list.get(i).getClass().getDeclaredFields();

            for(int j=0;j<fields.length;j++){
                 Object o=fields[j].get(list.get(i));
                if (o instanceof Date){
                    String str=DateUtil.dateToString((Date) o);
                    row.createCell(j).setCellValue(str);
                }else {
                    row.createCell(j).setCellValue(fields[j].get(list.get(i))+"");
                }

            }

        }

        try {

            FileOutputStream out = new FileOutputStream("C:/Users/Alen/Desktop/订单汇总表.xls");
            wb.write(out);
            out.close();
          /*  JOptionPane.showMessageDialog(null, "导出成功!");*/
            status="成功导入桌面";
        } catch (FileNotFoundException e) {
           /* JOptionPane.showMessageDialog(null, "导出失败!");*/
            e.printStackTrace();
        } catch (IOException e) {
           /* JOptionPane.showMessageDialog(null, "导出失败!");*/
            e.printStackTrace();
        }
        return status;
    }
    public static void main(String[] args) throws IllegalAccessException {
        List<String> header=new ArrayList<>();
        header.add("销售订单号");
        header.add("公司名称");
        header.add("客户名称");
        header.add("订单日期");
        header.add("订单状态");
        header.add("物料编码");
        header.add("物料描述");
        header.add("数量");
        header.add("销售单价");
        header.add("金额");
        List<OrdersExcel> list=new ArrayList<>();
        OrdersExcel ordersExcel=new OrdersExcel();
        ordersExcel.setCompanyName("哈哈");
        ordersExcel.setCustomerName("hehe");
        ordersExcel.setItemCode("ssss");
        ordersExcel.setItemDescription("asdfas");
        ordersExcel.setOrderDate(new Date());
        ordersExcel.setOrderNumber("sssssss");
        ordersExcel.setOrderPrice(new Long(444));
        ordersExcel.setOrderdQuantity(new Long(44));
        ordersExcel.setOrderStatus("new");
        list.add(ordersExcel);
        Export(header, list);
    }
}
