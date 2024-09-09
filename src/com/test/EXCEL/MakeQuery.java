package com.test.EXCEL;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MakeQuery {
	static XSSFWorkbook x;
	
	public static void main(String[] args) throws Exception {
		String outputFile = "d:/query.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outputFile)));
		ZipSecureFile.setMinInflateRatio(0);
		
		String xlsx = args[0];
        x = (XSSFWorkbook) WorkbookFactory.create(new File(xlsx));
        
        XSSFSheet sheetAt = x.getSheetAt(0);
        
        int first =sheetAt.getFirstRowNum(); 
        int last = sheetAt.getLastRowNum();
        String[] names = new String[] {"CNTRCT_TY_CODE","CNTRCT_GOODS_CODE","INFO_SE","NM","NM_KOR","ODR", "USE_AT", "ID_SE"};
//        String insert = "insert into TB_CNTRCT_CLMNS_MANAGE (CNTRCT_TY_CODE, CNTRCT_GOODS_CODE, INFO_SE, NM, NM_KOR, ODR, USE_AT, ID_SE, REGIST_DT, REGISTER_ID, REGIST_PROGRM_ID, UPDT_DT, UPDUSR_ID, UPDT_PROGRM_ID) values ";
        String insert = String.format("insert into TB_CNTRCT_CLMNS_MANAGE (%s, %s, %s, %s, %s, %s, %s, %s, REGIST_DT, REGISTER_ID, REGIST_PROGRM_ID, UPDT_DT, UPDUSR_ID, UPDT_PROGRM_ID) values ", names);
        String values = String.format("(@%s,@%s,@%s ,@%s,@%s, @%s, @%s, @%s, sysdate(), 'REGISTER_ID','REGIST_PROGRM_ID',sysdate(),'UPDUSR_ID','UPDT_PROGRM_ID'),",names);

        if(true) {
        	System.out.println(insert);
        	System.out.println(values);
        	return;
        }
        // 컬럼명과 이름 확인
        for (int i = first; i <2; i++) {
			XSSFRow row = sheetAt.getRow(i);
			int firstCol = row.getFirstCellNum();
			int lastCol = row.getLastCellNum();
			
			for (int j = firstCol; j < lastCol; j++) {
				XSSFCell cell = row.getCell(j);
				
//				System.out.printf("(%d,%d) value : %s / %s / %s, type : %s \n",i,j,cell.toString(),cell.getCTCell().getV(),cell.getRawValue(),cell.getCellType());
				System.out.printf("value : %s  \n",getValue(cell));
			}
		}
        
        for (int i = 2; i < last; i++) {
        	XSSFRow row = sheetAt.getRow(i);
        	int firstCol = row.getFirstCellNum();
			int lastCol = row.getLastCellNum();
			
			String cntrctTyCode = getValue(row.getCell(0));
			String cntrctGoodsCode = getValue(row.getCell(1));
			
			for (int j = firstCol + 2; j < lastCol; j++) {
				XSSFCell cell = row.getCell(j);
				System.out.printf( "%s ",getValue(cell));
			}
			String now = values.replace("", cntrctGoodsCode);
			System.out.println();
		}
        
        if(writer!= null) {
        	writer.close();
        }
	}
	public static String getValue(XSSFCell cell) {
		if(cell.getCellType().equals(CellType.NUMERIC)) {
			return String.valueOf((int)cell.getNumericCellValue()); 
		}
		return cell.toString().replaceAll("[^a-zA-Z0-9가-힣 _]", "");
	}
}
