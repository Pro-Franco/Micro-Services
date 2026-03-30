package com.example.times_service.times;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Long> {
}
