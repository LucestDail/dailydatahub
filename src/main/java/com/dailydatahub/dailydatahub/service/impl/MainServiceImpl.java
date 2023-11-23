package com.dailydatahub.dailydatahub.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailydatahub.dailydatahub.domain.MainCountDashboard;
import com.dailydatahub.dailydatahub.repository.MainCountDashboardRepository;
import com.dailydatahub.dailydatahub.service.MainService;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private MainCountDashboardRepository mainCountDashboardRepository;

    @Override
    public Optional<MainCountDashboard> selectMainCountDashboard() {
        return mainCountDashboardRepository.findTopByOrderBySeqDesc();
    }
    
}
