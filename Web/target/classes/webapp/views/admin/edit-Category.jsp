<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa danh mục</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: #f5f7fa;
            font-family: "Segoe UI", Roboto, "Helvetica Neue", Arial;
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 40px 0;
        }
        .card {
            width: 540px;
            border-radius: 12px;
            box-shadow: 0 6px 20px rgba(20,20,20,0.08);
        }
        .thumb {
            width: 140px;
            height: 110px;
            object-fit: cover;
            border-radius: 8px;
            border: 1px solid #e6e6e6;
        }
        .small-muted {
            font-size: 0.9rem;
            color: #6c757d;
        }
    </style>
</head>
<body>

<div class="card p-4 bg-white">
    <h4 class="mb-3 text-center">✏️ Chỉnh sửa danh mục</h4>

    <!-- Hiển thị thông báo nếu có -->
    <c:if test="${not empty message}">
        <div class="alert alert-info" role="alert">${message}</div>
    </c:if>

    <c:url value="/admin/category/edit" var="editUrl" />
    <form action="${editUrl}" method="post" enctype="multipart/form-data" novalidate>

        <!-- id (hidden) -->
        <input type="hidden" name="id" value="${category.id}" />
        <!-- giữ tên file ảnh cũ để nếu không upload mới thì dùng lại -->
        <input type="hidden" name="oldImage" value="${category.images}" />

        <div class="mb-3">
            <label for="name" class="form-label fw-semibold">Tên danh mục</label>
            <input id="name" name="name" type="text" class="form-control" value="${category.name}" required>
        </div>

        <div class="mb-3">
            <label class="form-label fw-semibold d-block">Ảnh hiện tại</label>

            <c:url value="/image?fname=${category.images}" var="imgUrl" />
            <img id="currentThumb" class="thumb mb-2" src="${imgUrl}" alt="Ảnh danh mục" onerror="this.style.display='none'">

            <div class="small-muted mb-2">Nếu bạn không chọn ảnh mới, hệ thống sẽ giữ lại ảnh hiện tại.</div>

            <label for="imageInput" class="form-label fw-semibold">Chọn ảnh mới (tùy chọn)</label>
            <input id="imageInput" name="image" type="file" class="form-control" accept="image/*">

            <!-- preview ảnh mới -->
            <img id="preview" class="thumb mt-2" style="display:none;" alt="Preview ảnh mới">
        </div>

        <div class="d-flex justify-content-between mt-4">
            <a href="${pageContext.request.contextPath}/admin/category/list" class="btn btn-outline-secondary">← Quay lại</a>
            <div>
                <button type="reset" class="btn btn-light me-2">Reset</button>
                <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
            </div>
        </div>
    </form>
</div>

<!-- Preview script -->
<script>
    const imageInput = document.getElementById('imageInput');
    const preview = document.getElementById('preview');
    const currentThumb = document.getElementById('currentThumb');

    imageInput.addEventListener('change', function() {
        const file = this.files && this.files[0];
        if (file) {
            preview.src = URL.createObjectURL(file);
            preview.style.display = 'inline-block';
            // ẩn ảnh cũ cho trực quan
            if (currentThumb) currentThumb.style.display = 'none';
        } else {
            preview.style.display = 'none';
            if (currentThumb) currentThumb.style.display = 'inline-block';
        }
    });
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
