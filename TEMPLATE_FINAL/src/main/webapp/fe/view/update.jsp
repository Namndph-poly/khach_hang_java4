<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 14/03/2023
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<script>
    function check(){
        var ma = document.getElementById("ma").value;
        var ho = document.getElementById("ten").value;
        var ten = document.getElementById("ho").value;
        var tendem = document.getElementById("tendem").value;
        var sdt = document.getElementById("sdt").value;
        var diachi = document.getElementById("diachi").value

        if(ma == "" && ho == "" && ten == "" && tendem == "" && sdt == "" && diachi == "" ){

        }else{
            alert("Update Thành Công");
        }
    }
</script>
<body>
<div class="container">
<form action="/khach-hang/update?ma=${KH.ma}" method="post">
    <div class="row mt-2">
        <div class="row mt-2">
            <div class="col-4">
                <div class="mb-3">
                    <label class="form-label">Mã</label>
                    <input id="ma" type="text" class="form-control" disabled name="ma" value="${KH.ma}">
                </div>
                <p style="color: red">${ errorMessage }</p>
            </div>
            <div class="col-4">
                <div class="mb-3">
                    <label class="form-label">Họ</label>
                    <input id="ho" type="text" class="form-control" name="ho" value="${KH.ho}" >
                </div>
                <p style="color: red"> ${ errorMessageHo }</p>
            </div>
        </div>
        <div class="row mt-2">
            <div class="col-4">
                <div class="mb-3">
                    <label class="form-label">Tên Đệm</label>
                    <input id="tendem" type="text" class="form-control" name="tenDem" value="${KH.tenDem}" >
                </div>
                <p style="color: red">   ${ errorMessageTenDem } </p>
            </div>
            <div class="col-4">
                <div class="mb-3">
                    <label class="form-label">Tên</label>
                    <input id="ten" type="text" class="form-control" name="ten" value="${KH.ten}">
                </div>
                <p style="color: red">   ${ errorMessageTen } </p>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-4">
                <div class="mb-3">
                    <label class="form-label">Số Điện Thoại</label>
                    <input id="sdt" type="text" class="form-control" name="sdt" value="${KH.sdt}">
                </div>
                <p style="color: red">   ${ errorMessageSdt } </p>
            </div>
            <div class="col-4">
                <div class="mb-3">
                    <label>Địa Chỉ</label>
                    <input id="diachi" type="text" class="form-control" name="diaChi" value="${KH.diaChi}">
                </div>
                <p style="color: red">   ${ errorMessageDiaChi } </p>
            </div>
        </div>
        <div class="row mt-2">
            <div class="col-3" >
                <button type="submit" class="btn btn-success btn-rounded btn-block" style="width: 100px;height: 40px" onclick="check()"  >UPDATE</button>
            </div>
        </div>
    </div>
</form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
</body>
</html>