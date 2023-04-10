package com.fpt.poly.pe.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;

    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "Ho")
    private String ho;
    @Column(name = "TenDem")
    private String tenDem;
    @Column(name = "Sdt")
    private String sdt;
    @Column(name = "DiaChi")
    private String diaChi;

    public KhachHang() {
    }

    public KhachHang(UUID id, String ma, String ten, String ho, String tenDem, String sdt, String diaChi) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.ho = ho;
        this.tenDem = tenDem;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public KhachHang(String ma, String ten, String ho, String tenDem, String sdt, String diaChi) {
        this.ma = ma;
        this.ten = ten;
        this.ho = ho;
        this.tenDem = tenDem;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTenDem() {
        return tenDem;
    }

    public void setTenDem(String tenDem) {
        this.tenDem = tenDem;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
