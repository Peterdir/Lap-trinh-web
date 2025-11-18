<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Trang chủ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(135deg, #74ebd5 0%, #ACB6E5 100%);
            min-height: 100vh;
            font-family: 'Segoe UI', sans-serif;
        }

        .navbar {
            background: rgba(255, 255, 255, 0.15);
            backdrop-filter: blur(10px);
            border-bottom: 1px solid rgba(255, 255, 255, 0.3);
        }

        .navbar-brand {
            color: #fff !important;
            font-weight: 600;
            font-size: 1.25rem;
        }

        .btn-logout {
            background: #fff;
            color: #007bff;
            border: none;
            font-weight: 500;
        }

        .btn-logout:hover {
            background: #007bff;
            color: white;
        }

        .welcome-card {
            background: #fff;
            border-radius: 15px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            padding: 40px;
            margin-top: 100px;
            text-align: center;
            animation: fadeIn 0.6s ease-in-out;
        }

        @keyframes fadeIn {
            from {opacity: 0; transform: translateY(-10px);}
            to {opacity: 1; transform: translateY(0);}
        }

        h1 {
            color: #333;
            font-weight: 700;
        }

        p.lead {
            color: #555;
        }

        footer {
            text-align: center;
            margin-top: 50px;
            color: rgba(255, 255, 255, 0.9);
            font-size: 0.9rem;
        }
    </style>
</head>

<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg fixed-top shadow-sm">
        <div class="container">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/views/home.jsp">
                Trang chủ
            </a>

            <div class="ms-auto d-flex gap-3">

                <!-- Nút vào trang Admin -->
                <a href="${pageContext.request.contextPath}/views/admin/dashboard.jsp"
                   class="btn btn-light btn-sm fw-semibold">
                   Quản lý danh mục
                </a>

                <!-- Logout -->
                <form action="${pageContext.request.contextPath}/logout" method="get" class="d-inline">
                    <button class="btn btn-logout btn-sm">Đăng xuất</button>
                </form>
            </div>
        </div>
    </nav>

    <!-- Nội dung chính -->
    <div class="container">
        <div class="welcome-card mx-auto" style="max-width: 500px;">
            <h1>Xin chào <c:out value="${sessionScope.user}" />!</h1>
            <p class="lead mt-3">Chúc bạn một ngày học tập hiệu quả</p>

            <hr class="my-4">

            <div class="d-flex justify-content-center gap-3">
                <a href="#" class="btn btn-outline-primary">Trang cá nhân</a>
                <a href="#" class="btn btn-outline-secondary">Xem thông báo</a>
            </div>
        </div>

        <footer class="mt-5">
            &copy; 2025 - Bài tập môn Lập trình Web cơ bản
        </footer>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
