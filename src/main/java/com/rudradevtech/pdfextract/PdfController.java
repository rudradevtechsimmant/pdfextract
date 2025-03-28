package com.rudradevtech.pdfextract;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/pdf")
public class PdfController {
    private final PdfTextExtractorService extractorService;

    public PdfController(PdfTextExtractorService extractorService) {
        this.extractorService = extractorService;
    }

    @PostMapping("/extract-text")
    public String extractText(@RequestParam("file") MultipartFile file) throws IOException {

        return extractorService.extractTextFromBytes(file.getBytes());
    }
}
