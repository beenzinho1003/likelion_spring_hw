package com.example.springhomework.guestbook.controller;

import com.example.springhomework.guestbook.dto.GuestbookSummaryResponse;
import com.example.springhomework.guestbook.service.GuestbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GuestbookController {

    private final GuestbookService guestbookService;

    public GuestbookController(GuestbookService guestbookService) {
        this.guestbookService = guestbookService;
    }

    @GetMapping("/api/guestbooks")
    public List<GuestbookSummaryResponse> getGuestbooks() {
        return guestbookService.getGuestbooks();
    }
    @GetMapping("/api/guestbooks/count")
    public long countGuestbooks() {
        return guestbookService.countGuestbooks();
    }
}