package com.dailydatahub.dailydatahub.service;

import java.util.Optional;

import com.dailydatahub.dailydatahub.domain.MainCountDashboard;

public interface  MainService {
    public Optional<MainCountDashboard> selectMainCountDashboard();
    
}
