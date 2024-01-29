package com.pdf_generator.controller;

import com.lowagie.text.DocumentException;
import com.pdf_generator.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
public class PdfController {

    @Autowired
    PdfService pdfService;



    @GetMapping("/generate-pdf")
    public ResponseEntity<ByteArrayResource> generatePdf() throws DocumentException, IOException {

        ByteArrayOutputStream bis = pdfService.generatePdf();

        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename=example.pdf");
        headers.add("Content-Disposition", "attachment; filename=Selfintro.pdf");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new ByteArrayResource(bis.toByteArray()));
    }

}
