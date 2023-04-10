package com.fpt.poly.pe.controller;

import com.fpt.poly.pe.entity.KhachHang;
import com.fpt.poly.pe.service.Impl.KhachHangServiceImpl;
import com.fpt.poly.pe.service.KhachHangService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.HibernateException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet({
        "/khach-hang/show",
        "/khach-hang/detail",
        "/khach-hang/add",
        "/khach-hang/viewUpdate",
        "/khach-hang/update",
        "/khach-hang/delete",
        "/khach-hang/hienthi",
})
public class KhachHangServlet extends HttpServlet {
private KhachHangService khachHangService = new KhachHangServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("show")){
            this.show(req,resp);
        }else  if(uri.contains("detail")){
            this.detail(req,resp);
        }else  if(uri.contains("delete")){
            this.delete(req,resp);
        }else  if(uri.contains("viewUpdate")){
            this.viewUpdate(req,resp);
        }else  if(uri.contains("hienthi")){
            this.hienthi(req,resp);
        }
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        KhachHang kh = khachHangService.findByMa(ma);
        req.setAttribute("KH",kh);
        req.getRequestDispatcher("/fe/view/update.jsp").forward(req,resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        khachHangService.delete(khachHangService.findByMa(ma));
        resp.sendRedirect("/khach-hang/hienthi");
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        KhachHang kh = khachHangService.findByMa(ma);
        req.setAttribute("KH",kh);
        req.setAttribute("ListKH",this.khachHangService.findAllKhachHang());
        req.getRequestDispatcher("/fe/view/trang-chu.jsp").forward(req,resp);
    }

    private void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("ListKH",this.khachHangService.findAllKhachHang());
        req.getRequestDispatcher("/fe/view/trang-chu.jsp").forward(req,resp);

    }
    private void hienthi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("ListKH",this.khachHangService.findAllKhachHang());
        req.getRequestDispatcher("/fe/view/trang-chu.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")){
            this.add(req,resp);
        }else  if(uri.contains("update")){
            this.update(req,resp);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        String ho = req.getParameter("ho");
        String tenDem = req.getParameter("tenDem");
        String ten = req.getParameter("ten");
        String sdt = req.getParameter("sdt");
        String diaChi = req.getParameter("diaChi");

        System.out.println(ma);
        KhachHang kh = khachHangService.findByMa(ma);
        kh.setHo(ho);
        kh.setTenDem(tenDem);
        kh.setTen(ten);
        kh.setSdt(sdt);
        kh.setDiaChi(diaChi);
        khachHangService.update(kh);
        resp.sendRedirect("/khach-hang/hienthi");
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        String ho = req.getParameter("ho");
        String tenDem = req.getParameter("tenDem");
        String ten = req.getParameter("ten");
        String sdt = req.getParameter("sdt");
        String diaChi = req.getParameter("diaChi");
        System.out.println("---------------------------------------------------");
        System.out.println(ma);
        System.out.println(ho);
        System.out.println(ten);

        KhachHang kh = new KhachHang(ma, ten, ho, tenDem, sdt, diaChi);
        if (kh.getMa().isEmpty()) {
            req.setAttribute("errorMessage", "Chưa nhập mã");
            req.getRequestDispatcher("/fe/view/trang-chu.jsp").forward(req,resp);
        }
        if (kh.getTen().isEmpty()) {
            req.setAttribute("errorMessageTen", "Chưa nhập tên");
            req.getRequestDispatcher("/fe/view/trang-chu.jsp").forward(req,resp);
        }
        if (kh.getHo().isEmpty()) {
            req.setAttribute("errorMessageHo", "Chưa nhập họ");
            req.getRequestDispatcher("/fe/view/trang-chu.jsp").forward(req,resp);

        }
        if (kh.getTenDem().isEmpty()) {
            req.setAttribute("errorMessageTenDem", "Chưa nhập tên đệm");
            req.getRequestDispatcher("/fe/view/trang-chu.jsp").forward(req,resp);

        }
        if (kh.getSdt().isEmpty()) {
            req.setAttribute("errorMessageSdt", "Chưa nhập sdt");
            req.getRequestDispatcher("/fe/view/trang-chu.jsp").forward(req,resp);

        }
        if (kh.getDiaChi().isEmpty()) {
            req.setAttribute("errorMessageDiaChi", "Chưa nhập địa chỉ");
            req.getRequestDispatcher("/fe/view/trang-chu.jsp").forward(req,resp);

        } else {
            khachHangService.insert(kh);
            req.setAttribute("colorSuccess", "success");
            req.setAttribute("successfully", "Thêm Thành Công");
            resp.sendRedirect("/khach-hang/hienthi");
        }

    }
}
