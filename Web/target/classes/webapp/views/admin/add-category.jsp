<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm danh mục</title>
    
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: #f5f7fa;
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            font-family: "Segoe UI", sans-serif;
        }

        .card {
            border-radius: 15px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            width: 460px;
            animation: fadeIn 0.4s ease-in-out;
        }

        @keyframes fadeIn {
            from {opacity: 0; transform: translateY(10px);}
            to {opacity: 1; transform: translateY(0);}
        }

        .btn-submit {
            background: #0d6efd;
            color: white;
        }

        .btn-submit:hover {
            background: #0b5ed7;
        }

        .img-preview {
            width: 100%;
            height: 180px;
            object-fit: cover;
            border-radius: 10px;
            margin-top: 10px;
            display: none;
        }
    </style>
</head>

<body>

<div class="card p-4">
    <h4 class="text-center mb-3">➕ Thêm danh mục</h4>

    <form action="add" method="post" enctype="multipart/form-data">

        <!-- Tên danh mục -->
        <div class="mb-3">
            <label class="form-label fw-semibold">Tên danh mục:</label>
            <input type="text" name="name" class="form-control" placeholder="Nhập tên danh mục" required>
        </div>

        <!-- Ảnh danh mục -->
        <div class="mb-3">
            <label class="form-label fw-semibold">Ảnh đại diện:</label>
            <input class="form-control" type="file" name="image" id="imageInput" accept="image/*">
            <img id="preview" class="img-preview" />
        </div>

        <!-- Nút -->
        <div class="d-flex justify-content-between mt-4">
            <button type="submit" class="btn btn-submit px-4">Thêm</button>
            <button type="reset" class="btn btn-secondary px-4">Hủy</button>
        </div>

    </form>
</div>


<!-- Preview hình ảnh -->
<script>
    const input = document.getElementById("imageInput");
    const preview = document.getElementById("preview");

    input.addEventListener("change", function(){
        const file = this.files[0];
        if (file){
            preview.style.display = "block";
            preview.src = URL.createObjectURL(file);
        }
    });
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
