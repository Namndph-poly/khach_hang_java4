package com.fpt.poly.pe.service;

import com.fpt.poly.pe.entity.KhachHang;

import java.util.List;

public interface KhachHangService {
   public void insert(KhachHang kh);
    public void delete(KhachHang kh);
    public void update(KhachHang kh);
    public List<KhachHang> findAllKhachHang();
    public KhachHang findById(String id);
    public KhachHang findByMa(String ma);
}
