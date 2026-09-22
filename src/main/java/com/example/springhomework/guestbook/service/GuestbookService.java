package com.example.springhomework.guestbook.service;

import com.example.springhomework.guestbook.dto.GuestbookCreateRequest;
import com.example.springhomework.guestbook.dto.GuestbookDetailResponse;
import com.example.springhomework.guestbook.dto.GuestbookSummaryResponse;
import com.example.springhomework.guestbook.dto.GuestbookUpdateRequest;
import com.example.springhomework.guestbook.entity.Guestbook;
import com.example.springhomework.guestbook.repository.GuestbookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestbookService {

    private final GuestbookRepository guestbookRepository;

    public List<GuestbookSummaryResponse> getGuestbooks() {
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

    public GuestbookDetailResponse getGuestbook(Long guestbookId) {
        Guestbook guestbook = findGuestbookById(guestbookId);

        return toDetailResponse(guestbook);
    }

    public GuestbookDetailResponse createGuestbook(
            GuestbookCreateRequest request
    ) {
        Guestbook guestbook = new Guestbook(
                request.getTitle(),
                request.getContent(),
                request.getWriter(),
                request.getPs()
        );

        Guestbook savedGuestbook =
                guestbookRepository.save(guestbook);

        return toDetailResponse(savedGuestbook);
    }

    @Transactional
    public GuestbookDetailResponse updateGuestbook(
            Long guestbookId,
            GuestbookUpdateRequest request
    ) {
        Guestbook guestbook = findGuestbookById(guestbookId);

        guestbook.update(
                request.getTitle(),
                request.getContent(),
                request.getWriter(),
                request.getPs()
        );

        return toDetailResponse(guestbook);
    }

    @Transactional
    public void deleteGuestbook(Long guestbookId) {
        Guestbook guestbook = findGuestbookById(guestbookId);

        guestbookRepository.delete(guestbook);
    }

    public long countGuestbooks() {
        return guestbookRepository.count();
    }

    private Guestbook findGuestbookById(Long guestbookId) {
        return guestbookRepository.findById(guestbookId)
                .orElseThrow();
    }

    private GuestbookDetailResponse toDetailResponse(
            Guestbook guestbook
    ) {
        return new GuestbookDetailResponse(
                guestbook.getId(),
                guestbook.getTitle(),
                guestbook.getContent(),
                guestbook.getWriter(),
                guestbook.getCreatedAt(),
                guestbook.getPs()
        );
    }
}