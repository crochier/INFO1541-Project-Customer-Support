package com.crochier.crochiercustomersupport.site;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.View;

import java.util.Map;
import java.util.stream.Stream;

public class DownloadAttachment implements View
{
    private final String filename;
    private final byte[] contents;

    public DownloadAttachment(String filename, byte[] contents)
    {
        this.filename = filename;
        this.contents = contents;
    }

    @Override
    public String getContentType()
    {
        return View.super.getContentType();
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        response.setHeader("Content-Disposition", "attachment; filename = " + filename);
        response.setContentType("application/octet-stream");
        ServletOutputStream stream = response.getOutputStream();
        stream.write(contents);
    }
}
