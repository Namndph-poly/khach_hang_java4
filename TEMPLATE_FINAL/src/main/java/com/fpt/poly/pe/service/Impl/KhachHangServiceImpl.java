package com.fpt.poly.pe.service.Impl;

import com.fpt.poly.pe.entity.KhachHang;
import com.fpt.poly.pe.repository.KhachhangRepository;
import com.fpt.poly.pe.service.KhachHangService;

import java.util.List;

public class KhachHangServiceImpl implements KhachHangService {
    private KhachhangRepository khachhangRepository = new KhachhangRepository();
    @Override
    public void insert(KhachHang kh) {
        khachhangRepository.insert(kh);
    }

    @Override
    public void delete(KhachHang kh) {
        khachhangRepository.delete(kh);
    }

    @Override
    public void update(KhachHang kh) {
        khachhangRepository.update(kh);
    }

    @Override
    public List<KhachHang> findAllKhachHang() {
        return khachhangRepository.findAllKhachHang();
    }

    @Override
    public KhachHang findById(String id) {
        return khachhangRepository.findById(id);
    }

    @Override
    public KhachHang findByMa(String ma) {
        return khachhangRepository.findByMa(ma);
    }
}
