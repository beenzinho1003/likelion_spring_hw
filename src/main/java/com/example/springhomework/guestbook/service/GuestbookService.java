package com.example.springhomework.guestbook.service;

import com.example.springhomework.guestbook.dto.GuestbookSummaryResponse;
import com.example.springhomework.guestbook.entity.Guestbook;
import com.example.springhomework.guestbook.repository.GuestbookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestbookService {

    private final GuestbookRepository guestbookRepository;

    public GuestbookService(GuestbookRepository guestbookRepository) {
        this.guestbookRepository = guestbookRepository;
    }

    public List<GuestbookSummaryResponse> getGuestbooks()
    {
        List<Guestbook> guestbooks = guestbookRepository.findAll();
        List<GuestbookSummaryResponse> responses = new ArrayList<>();

        for (Guestbook guestbook : guestbooks) {
            GuestbookSummaryResponse response =
                    new GuestbookSummaryResponse(
                            guestbook.getTitle(),
                            guestbook.getWriter(),
                            guestbook.getPs()
                    );

            responses.add(response);
        }

        return responses;
    }
    public long countGuestbooks() {
        return guestbookRepository.count();
    }
}