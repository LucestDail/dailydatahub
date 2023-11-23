package com.dailydatahub.dailydatahub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailydatahub.dailydatahub.domain.MainCountDashboard;

public interface MainCountDashboardRepository extends JpaRepository<MainCountDashboard, Long>{

     Optional<MainCountDashboard> findTopByOrderBySeqDesc();
} 
