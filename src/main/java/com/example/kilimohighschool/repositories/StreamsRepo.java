package com.example.kilimohighschool.repositories;

import com.example.kilimohighschool.models.Streams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StreamsRepo extends JpaRepository<Streams,Long> {

    Optional<Streams> findById(Long id);
}
