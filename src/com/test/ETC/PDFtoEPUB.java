package com.test.ETC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Metadata;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubWriter;

public class PDFtoEPUB {

    private static java.io.InputStream getResource(String path) {
        return PDFtoEPUB.class.getResourceAsStream(path);
    }

    private static Resource getResource(String path, String href) throws IOException {
        return new Resource(getResource(path), href);
    }

    public static void main(String[] args) throws IOException {
        // // load PDF with an instance of Document
        // Document document = new Document("template.pdf");
        // // save document in EPUB format
        // document.save("output.epub", SaveFormat.Epub);
        String pdf = "d:/temp.pdf";
        String html = "d:/temp.html";
        String output = "d:/temp.epub";
        PDDocument pdd = PDDocument.load(new File(pdf));
        String text = new PDFTextStripper().getText(pdd);

        FileOutputStream os = new FileOutputStream(output);
        ;
        Book book = new Book();
        Metadata metadata = book.getMetadata();
        metadata.addTitle("Epublib test book 1");
        // book.addSection("Introduction",getResource(html, "mymy"));
        book.addSection("Introduction",new Resource(new FileInputStream(html), html));
        
    
        EpubWriter writer = new EpubWriter();

        writer.write(book, os);
        System.out.println(text);

    }
}
