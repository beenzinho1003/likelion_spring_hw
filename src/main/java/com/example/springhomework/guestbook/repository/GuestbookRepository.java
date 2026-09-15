package com.example.springhomework.guestbook.repository;

import com.example.springhomework.guestbook.entity.Guestbook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestbookRepository extends JpaRepository<Guestbook, Long> {
}