package com.example.kilimohighschool.repositories;

import com.example.kilimohighschool.models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepo extends JpaRepository<Students,Long> {
    List<Students> findByStreamsId(Long streamsId);
}
