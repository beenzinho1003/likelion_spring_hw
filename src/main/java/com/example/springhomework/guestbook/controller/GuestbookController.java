package com.example.springhomework.guestbook.controller;

import com.example.springhomework.guestbook.dto.GuestbookCreateRequest;
import com.example.springhomework.guestbook.dto.GuestbookDetailResponse;
import com.example.springhomework.guestbook.dto.GuestbookSummaryResponse;
import com.example.springhomework.guestbook.dto.GuestbookUpdateRequest;
import com.example.springhomework.guestbook.service.GuestbookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/guestbooks")
public class GuestbookController {

    private final GuestbookService guestbookService;

    public GuestbookController(GuestbookService guestbookService) {
        this.guestbookService = guestbookService;
    }

    @GetMapping
    public List<GuestbookSummaryResponse> getGuestbooks() {
        return guestbookService.getGuestbooks();
    }

    @GetMapping("/{guestbookId}")
    public GuestbookDetailResponse getGuestbook(
            @PathVariable("guestbookId") Long guestbookId
    ) {
        return guestbookService.getGuestbook(guestbookId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GuestbookDetailResponse createGuestbook(
            @Valid @RequestBody GuestbookCreateRequest request
    ) {
        return guestbookService.createGuestbook(request);
    }

    @PutMapping("/{guestbookId}")
    public GuestbookDetailResponse updateGuestbook(
            @PathVariable("guestbookId") Long guestbookId,
            @Valid @RequestBody GuestbookUpdateRequest request
    ) {
        return guestbookService.updateGuestbook(
                guestbookId,
                request
        );
    }

    @DeleteMapping("/{guestbookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGuestbook(
            @PathVariable("guestbookId") Long guestbookId
    ) {
        guestbookService.deleteGuestbook(guestbookId);
    }

    @GetMapping("/count")
    public long countGuestbooks() {
        return guestbookService.countGuestbooks();
    }
}