package com.test.EXCEL;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.ClientAnchor.AnchorType;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelAddImage {
    static XSSFWorkbook x;

    public static void main(String[] args) throws Exception {
        String fileName = "D:/test/cell1.xlsx";
        String tar = "D:/test/temp.xlsx";
        copy(fileName, tar);
        x = (XSSFWorkbook) WorkbookFactory.create(new File(tar));
        addPic("d:/test/cell2.xlsx", "D:/test/images");
        System.out.println("끝");
    }

    // 파일 복사
    public static void copy(String src, String tar) throws IOException {
        FileInputStream is = new FileInputStream(new File(src));
        FileOutputStream os = new FileOutputStream(new File(tar));
        int c = 0;
        while ((c = is.read()) != -1) {
            os.write(c);
        }
        is.close();
        os.close();
    }

    public static void addPic(String fileName, String imageDirecto) {
        try {
            System.out.println("시작");
            FileOutputStream os = new FileOutputStream(fileName);
            XSSFSheet sheet = x.getSheetAt(0);
            XSSFDrawing drawing = sheet.createDrawingPatriarch();
            XSSFCreationHelper helper = x.getCreationHelper();

            // 엑셀 넓이 1000 당
            double cellWidthCm = sheet.getColumnWidth(0) * 0.816d / 1000 - 0.3d;

            List<int[]> picIdxs = getPicArr(imageDirecto);
            // 이미지 출력할 cell 위치
            int row = 7;
            int col = 0;
            for (int i = 0; i < picIdxs.size(); i++) {
                int[] now = picIdxs.get(i);
                int picIdx = now[0];
                XSSFClientAnchor anchor = helper.createClientAnchor();
                // anchor.setCol1(0);
                anchor.setCol2(1);
                anchor.setRow1(row + i);
                anchor.setAnchorType(AnchorType.MOVE_AND_RESIZE);

                // 이미지 그리기
                XSSFPicture pic = drawing.createPicture(anchor, picIdx);
                double d = 12.7 * 1080 / now[1];
                // System.out.println(d / cellWidthCm);

                pic.resize(d / cellWidthCm, 1);
                // pic.resize(1, 1);
            }
            x.write(os);
            x.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 이미지 파일이 역순으로 모여있는 파일의 경로
    public static List<int[]> getPicArr(String directo) throws IOException {
        File directory = new File(directo);
        File[] images = directory.listFiles((dir, name) -> {
            return name.endsWith("jpg") || name.endsWith("jpeg") || name.endsWith("png");
        });
        FileInputStream is = null;
        // List<Integer> result = new ArrayList<>();
        // Stack<Integer> stack = new Stack<>();
        List<int[]> result = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();
        for (File img : images) {
            is = new FileInputStream(img);
            BufferedImage i = ImageIO.read(is);
            is = new FileInputStream(img);
            int idx = x.addPicture(IOUtils.toByteArray(is), XSSFWorkbook.PICTURE_TYPE_JPEG);

            // System.out.println(i.getHeight() + " : " + i.getWidth());

            stack.add(new int[] { idx, i.getHeight() });
            // stack.add(idx);
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public static void addPicTest(String fileName) {
        try {
            System.out.println("되나?");
            InputStream is = new FileInputStream(fileName);
            FileOutputStream os = new FileOutputStream("d:/test/cell2.xlsx");
            byte[] bytes = IOUtils.toByteArray(is);
            // int picIdx = x.addPicture(bytes, XSSFWorkbook.PICTURE_TYPE_PNG);
            int picIdx = x.addPicture(bytes, XSSFWorkbook.PICTURE_TYPE_JPEG);
            XSSFSheet sheet = x.getSheetAt(0);

            XSSFDrawing drawing = sheet.createDrawingPatriarch();
            XSSFCreationHelper helper = x.getCreationHelper();
            XSSFClientAnchor anchor = helper.createClientAnchor();

            // 이미지 출력할 cell 위치
            anchor.setAnchorType(AnchorType.MOVE_AND_RESIZE);
            // anchor.setDx1(0);
            // anchor.setDx2(100);
            // anchor.setDy1(100);
            // anchor.setDy2(200);
            // anchor.setCol1(0);
            anchor.setRow1(8);
            // 이미지 그리기
            XSSFPicture pic = drawing.createPicture(anchor, picIdx);
            pic.resize(1);

            is.close();
            x.write(os);
            x.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
