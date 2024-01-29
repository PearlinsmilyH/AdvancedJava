package com.pdf_generator.service;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Documented;

@Service
public class PdfService {

    public ByteArrayOutputStream generatePdf() {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, out);
        document.open();

        Paragraph p = new Paragraph("Intro");
        p.setAlignment(Paragraph.ALIGN_CENTER);


        document.add(p);

        document.add(new Paragraph("Hai, I'm Pearlin Smily. I from Nazareth. I'm working as a Software Engineer in DataSirpi."));
        document.close();
        return out;




    }
}
