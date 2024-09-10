// package com.test.ETC;

// import java.io.File;
// import java.io.FileInputStream;
// import java.io.FileNotFoundException;
// import java.io.FileOutputStream;
// import java.io.IOException;

// import org.apache.poi.xssf.usermodel.XSSFCell;
// import org.apache.poi.xssf.usermodel.XSSFRow;
// import org.apache.poi.xssf.usermodel.XSSFSheet;

// import org.apache.poi.openxml4j.util.ZipSecureFile;
// import org.apache.poi.ss.usermodel.CellType;
// import org.apache.poi.ss.usermodel.WorkbookFactory;
// import org.apache.poi.ss.util.CellRangeAddress;
// import org.apache.poi.xssf.usermodel.XSSFCell;
// import org.apache.poi.xssf.usermodel.XSSFRow;
// import org.apache.poi.xssf.usermodel.XSSFSheet;
// import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// public class ExelEdit {

// 	public static void main(String[] args) throws Exception{
// 		String directo = "D:\\class\\myIO";

// 		long start = System.currentTimeMillis();
// 		int x=0;
// 		System.out.println('+');
// 		for (Telecom TEL : Telecom.values()) {
// 			// 통신사별 폴더 생성
// 			File f = new File(directo+"/"+TEL.getName()+"/");
// 			if(!f.exists()) {
// 				f.mkdirs();
// 			}
			
// 			// 파일 복사
// 			for (File file : new File(directo).listFiles()) {
// 				if(file.isFile()) {					
// 					copyFile(file, f);
// 				}
// 			}
// 			// 엑셀 수정
// 			System.out.println();
// 			System.out.println(TEL.getName() + " job started");
// 			exel1(f.getAbsolutePath(),TEL);
			
// 			for (File file : f.listFiles()) {				
// 				if(file.isFile()) {
// 					file.delete();
// 				}
// 			}
// 			System.out.println(TEL.getName() + " job done");
// 			System.out.println();
// 		}
// 		System.out.println();

// 		System.out.println("====================================");
// 		System.out.println("All job finished : " + (System.currentTimeMillis() - start)/1000 );
// 		System.out.println();
		
// 	}



// 	private static void exel1(String directo,Telecom TEL) throws IOException, FileNotFoundException {
// 		File dir = new File(directo);
// 		File[] file = dir.listFiles();
// 		ZipSecureFile.setMinInflateRatio(0);		
// 		FileOutputStream os = null;
// 		XSSFWorkbook x = null;
		
// 		for (File src : file) {
// 			if(src.isDirectory()) {
// 				continue;
// 			}
// 			if(!src.getName().endsWith("xlsx")) {
// 				continue;
// 			}
			
// 			x = (XSSFWorkbook) WorkbookFactory.create(src);
			
// 			XSSFSheet shit = x.getSheetAt(1);
			
// 			// sk 머지된 영역 제거하기
// 			// 한번만 반복하면 풀리지 않는 머지 영역이 있어서 3번을 돌린다.
// 			for (int j = 0; j < 3; j++) {				
// 				for (int i = 0; i < shit.getNumMergedRegions(); i++) {
// 					CellRangeAddress s = shit.getMergedRegion(i);
// 					if(15 < s.getFirstRow() && s.getFirstRow() < 26) {
// 						shit.removeMergedRegion(i);
// 					}
// 				}
// 			}
			
// 			// 상단 2줄에 값 옮겨 넣기
// 			shit.getRow(11).getCell(1).setCellValue(TEL.getName());
// 			copyRowValue(shit.getRow(13),shit.getRow(13+TEL.getRow()),0);
// 			copyRowValue(shit.getRow(14),shit.getRow(14+TEL.getRow()),0);

// 			// 나머지 줄 삭제
// 			for (int i = 16; i < 26; i++) {
// 				shit.createRow(i);
// 			}
			
// 			// 줄별 처리
// 			for (int i = 31; i < 37; i++) { // row
// 				XSSFRow ro = shit.getRow(i);
// 				if (ro == null)
// 					continue;

// 				// 결과 부분 컬럼 수정
// 				for (int j = 0; j < ro.getLastCellNum(); j++) { // collum
// 					XSSFCell c = ro.getCell(j);
// 					if (c != null) {
// 						if (j == 3) {
// 							if (ro.getCell(j + TEL.getColumn()).getRawValue() != null) {
// 								copyCellValue(c, ro.getCell(j + TEL.getColumn()));
// 							}
// 						}
// 						if (4 < j && j < 9) {
// 							c.setBlank();
// 							c.setCellStyle(null);
// 						}
// 					}
// 				}

// 			}
			
// 			// 빈줄 잘라내기
// 			shit.shiftRows(26, 48, -10);
			
// 			// 마무리 작업
// 			File newFolder = new File(directo+"/completed/");
// 			if(!newFolder.exists()) {
// 				newFolder.mkdirs();
// 			}
// 			os = new FileOutputStream(new File(newFolder.getAbsolutePath()+"/"+src.getName()));
// 			x.write(os);

// 			x.close();
// 			os.close();
// 			System.out.println("\t"+src.getName());
// 		}
// 	}

// 	private static CellType printCell(XSSFCell c) {
// 		CellType type = c.getCellType();
// 		if(type == CellType.STRING) {
// 			System.out.println(c.getStringCellValue());
// 		}else if(type==CellType.NUMERIC) {
// 			System.out.println(c.getNumericCellValue());
// 		}else if(type==CellType.FORMULA) {
// 			System.out.println(c.getNumericCellValue());
// 		}else {
// 			System.out.println(type.name());
// 			System.out.println();
// 		}
// 		return type;
// 	}
	
// 	private static void copyRowValue(XSSFRow origin,XSSFRow src,int start) {
// 		for (int j = start; j < origin.getLastCellNum(); j++) {
// 			XSSFCell t = origin.getCell(j);
// 			XSSFCell s = src.getCell(j);
// 			if(t!=null && s !=null) {				
// 				copyCellValue(t, s);
// 			}
// 		}
// 	}
	
// 	private static void copyCellValue(XSSFCell origin, XSSFCell src) {
// 		CellType type = origin.getCellType();
// 		if(type == CellType.STRING) {
// 			origin.setCellValue(src.getStringCellValue());
// 		}else if(type==CellType.NUMERIC) {
// 			origin.setCellValue(src.getNumericCellValue());
// 		}else if(type==CellType.FORMULA) {
// 			origin.setCellValue(src.getCellFormula());			
// 		}else {
// 			origin.setCellValue(src.getRawValue());
// 		}
// 	}
	
// 	private static void copyFile(File origin, File... toDiretory) throws Exception {

// 		// 1. parameter check
// 		// 1-1 file 인지 확인
// 		if(!origin.isFile()) {
// 			System.out.println(origin.getName()+" : origin file must be file");
// 			return;
// 		}
// 		// 1-2 directory인지 확인
// 		for (File file : toDiretory) {
// 			if(!file.isDirectory() || file == null) {
// 				System.out.println("where you want to transfer is not directory");
// 				return;
// 			}
// 		}
		
// 		// 2. FileInputStream, FileOutputStream 준비
// 		FileInputStream input = new FileInputStream(origin);
// 		FileOutputStream[] oss = new FileOutputStream[toDiretory.length];
// 		for (int i = 0; i < oss.length; i++) {
// 			oss[i] = new FileOutputStream(toDiretory[i].getAbsolutePath()+"/"+origin.getName());
// 		}
	
// 		// 3. 한번에 read하고, write할 사이즈 지정
// 		byte[] buf = new byte[1024];

// 		// 4. buf 사이즈만큼 input에서 데이터를 읽어서, output에 쓴다.
// 		int readData;
// 		while ((readData = input.read(buf)) > 0) {
// 			for (FileOutputStream fileOutputStream : oss) {
// 				fileOutputStream.write(buf, 0, readData);
// 			}
// 		}

// 		// 5. Stream close
// 		input.close();
// 		for (FileOutputStream fileOutputStream : oss) {
// 			fileOutputStream.close();
// 		}
// 	}
// 	public enum Telecom {

// 		SKT("SKT",0,0),
// 		KT("KT",5,2),
// 		LG("LG",10,4),
// 		;
// 		private String name;
// 		private int row;
// 		private int column;
		
// 		private Telecom(String name, int row, int column) {
// 			this.name = name;
// 			this.row = row;
// 			this.column = column;
// 		}

// 		public String getName() {
// 			return name;
// 		}

// 		public int getRow() {
// 			return row;
// 		}

// 		public int getColumn() {
// 			return column;
// 		}
		
		
// 	}
// }
