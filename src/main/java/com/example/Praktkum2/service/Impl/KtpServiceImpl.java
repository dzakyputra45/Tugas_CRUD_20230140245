package com.example.Praktkum2.service.Impl;

import com.example.Praktkum2.model.dto.KtpDto;
import com.example.Praktkum2.model.entity.Ktp;
import com.example.Praktkum2.repository.KtpRepository;
import com.example.Praktkum2.service.KtpService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KtpServiceImpl implements KtpService {

    private final KtpRepository repository;

    public KtpServiceImpl(KtpRepository repository) {
        this.repository = repository;
    }

    @Override
    public KtpDto save(KtpDto dto) {

        // VALIDASI NOMOR KTP TIDAK BOLEH SAMA
        if(repository.findByNomorKtp(dto.getNomorKtp()).isPresent()){
            throw new RuntimeException("Nomor KTP tidak boleh sama");
        }

        Ktp ktp = new Ktp();

        ktp.setNomorKtp(dto.getNomorKtp());
        ktp.setNamaLengkap(dto.getNamaLengkap());
        ktp.setAlamat(dto.getAlamat());
        ktp.setTanggalLahir(dto.getTanggalLahir());
        ktp.setJenisKelamin(dto.getJenisKelamin());

        Ktp saved = repository.save(ktp);

        dto.setId(saved.getId());

        return dto;
    }

    @Override
    public List<KtpDto> findAll() {

        return repository.findAll().stream().map(k -> {

            KtpDto dto = new KtpDto();

            dto.setId(k.getId());
            dto.setNomorKtp(k.getNomorKtp());
            dto.setNamaLengkap(k.getNamaLengkap());
            dto.setAlamat(k.getAlamat());
            dto.setTanggalLahir(k.getTanggalLahir());
            dto.setJenisKelamin(k.getJenisKelamin());

            return dto;

        }).collect(Collectors.toList());
    }

    @Override
    public KtpDto findById(Integer id) {

        Ktp ktp = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        KtpDto dto = new KtpDto();

        dto.setId(ktp.getId());
        dto.setNomorKtp(ktp.getNomorKtp());
        dto.setNamaLengkap(ktp.getNamaLengkap());
        dto.setAlamat(ktp.getAlamat());
        dto.setTanggalLahir(ktp.getTanggalLahir());
        dto.setJenisKelamin(ktp.getJenisKelamin());

        return dto;
    }

    @Override
    public KtpDto update(Integer id, KtpDto dto) {

        Ktp ktp = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        ktp.setNamaLengkap(dto.getNamaLengkap());
        ktp.setAlamat(dto.getAlamat());
        ktp.setTanggalLahir(dto.getTanggalLahir());
        ktp.setJenisKelamin(dto.getJenisKelamin());

        repository.save(ktp);

        return dto;
    }

    @Override
    public void delete(Integer id) {

        repository.deleteById(id);

    }

}