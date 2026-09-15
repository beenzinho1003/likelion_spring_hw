package com.example.springhomework.guestbook.dto;

public class GuestbookSummaryResponse {
    private final String title;
    private final String writer;
    private final String ps;
//이거 3개만 해야도미

    public GuestbookSummaryResponse(
            String title,
            String writer,
            String ps
    ) {
        this.title = title;
        this.writer = writer;
        this.ps = ps;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public String getPs() {
        return ps;
    }
}