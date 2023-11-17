package com.test.EXCEL;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AddPic {
    public static Boolean excelImag(XSSFWorkbook xlsWb, XSSFSheet sheet, String sFileRealNm, String sPath, String sId,
            int indexCell, int indexRow, String excelType) throws Exception {

        // String savePath = request.getSession().getServletContext().getRealPath("");
        // System.out.println(">>>>>>>>>>>>>>>>>savePath:"+savePath);

        String sSaveFile = sPath + sFileRealNm;
        System.out.println(">>>>>>>>>>>>>>>>>>>>>image:" + sSaveFile);

        // 파일 존재 유무 확인
        File file = new File(sSaveFile);
        if (!file.exists()) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>not image:" + sSaveFile);
            return false;
        }

        // String imgFilePath = sFileRealNm.substring(0, sFileRealNm.lastIndexOf("/"));
        // String sFileNm = sFileRealNm.substring(sFileRealNm.lastIndexOf("/") + 1,
        // sFileRealNm.length());

        // ----- 이미지 resize -----
        String sTmpFile = sPath + "1/image.jpg";
        System.out.println(">>>>>>>>>>>>>>>>>>>>>sTmpFile:" + sTmpFile);
        // int imgWidthSize = 219;
        // int imgHeightSize = 219;
        // if (excelType.equals("short")) {
        // imgWidthSize = 1
        // imgHeightSize = 130;
        // }

        // imgSizeChange(sSaveFile, sTmpFile, imgWidthSize, imgHeightSize);//
        // 원본파일명,resize파일명,변경width,변경hight
        // ----- 이미지 resize -----

        FileInputStream inputStream = new FileInputStream(sTmpFile);
        byte[] bytes = IOUtils.toByteArray(inputStream);
        int pictureIdx = xlsWb.addPicture(bytes, XSSFWorkbook.PICTURE_TYPE_JPEG);
        inputStream.close();

        XSSFCreationHelper helper = xlsWb.getCreationHelper();
        XSSFDrawing drawing = sheet.createDrawingPatriarch();
        XSSFClientAnchor anchor = helper.createClientAnchor();
        // 이미지를 출력할 CELL 위치 선정
        // System.out.println(">>>>>>>>>>>>>>>>>indexCell:"+(indexCell-1));
        // System.out.println(">>>>>>>>>>>>>>>>>indexRow:"+(indexRow-1));
        anchor.setCol1(indexCell - 1);
        anchor.setCol2((indexCell + 2) - 1); // cell 3개 병합해서 +2 함
        anchor.setRow1(indexRow - 1);
        anchor.setRow2(indexRow - 1);
        // anchor.setDx1(10 * XSSFShape.EMU_PER_PIXEL);//여백 뭔기능인지 모르겠음
        // anchor.setDx2(10 * XSSFShape.EMU_PER_PIXEL);//여백 뭔기능인지 모르겠음
        // anchor.setDy1(10 * XSSFShape.EMU_PER_PIXEL);//여백 뭔기능인지 모르겠음
        // anchor.setDy2(10 * XSSFShape.EMU_PER_PIXEL);//여백 뭔기능인지 모르겠음

        // 이미지 그리기
        XSSFPicture pict = drawing.createPicture(anchor, pictureIdx);

        // 이미지 사이즈 비율 설정
        pict.resize();

        return true;
    }

    // public static boolean imgSizeChange(String i_sSourceFile, String
    // i_sTargetFile, int iTargetWidth,
    // int iTargetHeight) {
    // boolean result = true;

    // Image imgSource = null;
    // Image imgTarget = null;

    // PixelGrabber grabber = null;
    // BufferedImage buffer = null;

    // FileOutputStream fos = null;
    // JPEGImageEncoder jpeg = null;
    // JPEGEncodeParam param = null;

    // double ratio;

    // try {
    // imgSource = new ImageIcon(i_sSourceFile).getImage();

    // int iSourceWidth = imgSource.getWidth(null);
    // int iSourceHeight = imgSource.getHeight(null);

    // // System.out.println(">>>>>>>>>>>>iSourceWidth:"+iSourceWidth);
    // // System.out.println(">>>>>>>>>>>>iSourceHeight:"+iSourceHeight);

    // int iSetWidth = 0;
    // int iSetHeight = 0;

    // if (iSourceWidth - iSourceHeight > 0) { // 가로 기준
    // System.out.println(">>>>>>>>>>>xx:가로");
    // if (iSourceWidth - iTargetWidth > 0) {
    // ratio = (double) iTargetWidth / (double) iSourceWidth;
    // iSetWidth = (int) (iSourceWidth * ratio);
    // iSetHeight = (int) (iSourceHeight * ratio);
    // }
    // // 세로 크기가 설정보다 크면 세로 설정기준으로 변경
    // if (iSetHeight - iTargetHeight > 0) {
    // ratio = (double) iTargetHeight / (double) iSourceHeight;
    // iSetWidth = (int) (iSourceWidth * ratio);
    // iSetHeight = (int) (iSourceHeight * ratio);
    // }
    // } else {// 세로 기준
    // System.out.println(">>>>>>>>>>>xx:세로");
    // if (iSourceHeight - iTargetHeight > 0) {
    // ratio = (double) iTargetHeight / (double) iSourceHeight;
    // iSetWidth = (int) (iSourceWidth * ratio);
    // iSetHeight = (int) (iSourceHeight * ratio);
    // }
    // }

    // // System.out.println(">>>>>>>>>>>>iTargetWidth:"+iSetWidth);
    // // System.out.println(">>>>>>>>>>>>iTargetHeight:"+iSetHeight);

    // imgTarget = imgSource.getScaledInstance(iSetWidth, iSetHeight,
    // Image.SCALE_SMOOTH);

    // int[] iPixels = new int[iSetWidth * iSetHeight];

    // grabber = new PixelGrabber(imgTarget, 0, 0, iSetWidth, iSetHeight, iPixels,
    // 0, iSetWidth);
    // grabber.grabPixels();

    // buffer = new BufferedImage(iSetWidth, iSetHeight,
    // BufferedImage.TYPE_INT_RGB);
    // buffer.setRGB(0, 0, iSetWidth, iSetHeight, iPixels, 0, iSetWidth);

    // fos = new FileOutputStream(i_sTargetFile);

    // jpeg = JPEGCodec.createJPEGEncoder(fos);

    // param = jpeg.getDefaultJPEGEncodeParam(buffer);
    // param.setQuality(1.0f, false);

    // jpeg.encode(buffer, param);
    // } catch (Exception e) {
    // result = false;
    // } finally {
    // try {
    // if (null != fos) {
    // fos.close();
    // }
    // } catch (Exception e) {
    // result = false;
    // }
    // }

    // return result;
    // }
}
