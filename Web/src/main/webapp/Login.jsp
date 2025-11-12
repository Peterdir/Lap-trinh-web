<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">
    <div class="container mt-5" style="max-width: 400px;">
        <h2 class="text-center mb-4">Đăng nhập hệ thống</h2>

        <!--Phần hiển thị thông báo alert -->
        <c:if test="${not empty alert}">
            <div class="alert alert-danger text-center" role="alert">
                ${alert}
            </div>
        </c:if>

        <!--Form đăng nhập -->
        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="mb-3">
                <label for="username" class="form-label"><b>Tên đăng nhập</b></label>
                <input type="text" class="form-control" id="username" name="username" placeholder="Nhập tên đăng nhập">
            </div>

            <div class="mb-3">
                <label for="password" class="form-label"><b>Mật khẩu</b></label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Nhập mật khẩu">
            </div>

            <div class="form-check mb-3">
                <input type="checkbox" class="form-check-input" id="remember" name="remember">
                <label class="form-check-label" for="remember">Ghi nhớ đăng nhập</label>
            </div>

            <div class="d-grid">
                <button type="submit" class="btn btn-primary">Đăng nhập</button>
            </div>

            <div class="mt-3 text-center">
                <a href="#">Quên mật khẩu?</a>
            </div>
        </form>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
