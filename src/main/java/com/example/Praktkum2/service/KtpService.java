package com.example.Praktkum2.service;

import com.example.Praktkum2.model.dto.KtpDto;
import java.util.List;

public interface KtpService {

    KtpDto save(KtpDto dto);
    List<KtpDto> findAll();
    KtpDto findById(Integer id);
    KtpDto update(Integer id, KtpDto dto);
    void delete(Integer id);
}