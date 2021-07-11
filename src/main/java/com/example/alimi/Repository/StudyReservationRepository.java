package com.example.alimi.Repository;

import com.example.alimi.Domain.StudyReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyReservationRepository extends JpaRepository<StudyReservation, Long> {
}
