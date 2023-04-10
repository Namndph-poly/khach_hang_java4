package com.fpt.poly.pe.repository;

import com.fpt.poly.pe.entity.KhachHang;
import com.fpt.poly.pe.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class KhachhangRepository {
    private Session hSession = HibernateUtil.getFACTORY().openSession();
    public void insert(KhachHang kh){

        Transaction transaction = hSession.getTransaction();
        try {
            transaction.begin();
            hSession.persist(kh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(KhachHang kh){
        Transaction transaction = hSession.getTransaction();
        try {
            transaction.begin();
            hSession.delete(kh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update(KhachHang kh){
        Transaction transaction = hSession.getTransaction();
        try {
            transaction.begin();
            hSession.merge(kh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public List<KhachHang> findAllKhachHang(){
        String hql = "SELECT obj FROM KhachHang obj";
        TypedQuery<KhachHang> query = hSession.createQuery(hql,KhachHang.class);
        return query.getResultList();
    }
    public KhachHang findById(String id){
        return hSession.find(KhachHang.class,id);
    }
    public KhachHang findByMa (String ma){
        String hql = "SELECT obj FROM KhachHang obj where obj.ma = ?1";
        TypedQuery<KhachHang> query = hSession.createQuery(hql,KhachHang.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }
}
