USE laptrinhweb2025;
INSERT INTO `user`
(email, user_name, full_name, password, avatar, role_id, phone)
VALUES
('duy@example.com', 'duylk', 'Lâm Khánh Duy', '123456', NULL, 1, '0987654321');


INSERT INTO user (email, user_name, full_name, password, avatar, role_id, phone)
VALUES
('admin@gmail.com', 'admin', 'Quản trị viên', '123456', NULL, 1, '0901234567'),
('duy@gmail.com', 'duy', 'Duy Lâm', '123456', NULL, 0, '0907654321'),
('user01@gmail.com', 'user01', 'Nguyễn Văn A', 'password', NULL, 0, '0911122233');

INSERT INTO category (name, images) VALUES
('Điện thoại', 'phone.jpg'),
('Laptop', 'laptop.jpg'),
('Tai nghe', 'headphone.jpg'),
('Phụ kiện', 'accessories.jpg'),
('Máy tính bảng', 'tablet.jpg');

INSERT INTO products (name, description, price, images, category_id) VALUES
('iPhone 14 Pro Max', 'Điện thoại cao cấp của Apple', 27990000, 'iphone14.jpg', 1),
('Samsung Galaxy S23', 'Điện thoại flagship Samsung', 22990000, 's23.jpg', 1),

('MacBook Pro M2', 'Laptop hiệu năng cao dành cho lập trình viên', 39990000, 'macbookm2.jpg', 2),
('Dell XPS 13', 'Laptop mỏng nhẹ cao cấp', 32990000, 'xps13.jpg', 2),

('Sony WH-1000XM5', 'Tai nghe chống ồn hàng đầu', 7990000, 'xm5.jpg', 3),
('AirPods Pro 2', 'Tai nghe không dây cao cấp của Apple', 5490000, 'airpodspro2.jpg', 3),

('Sạc nhanh 20W', 'Sạc nhanh chính hãng', 450000, 'charger20w.jpg', 4),
('Cáp Lightning', 'Cáp sạc iPhone chuẩn MFi', 250000, 'lightning.jpg', 4),

('iPad Pro 11', 'Máy tính bảng cao cấp của Apple', 24990000, 'ipadpro11.jpg', 5),
('Samsung Tab S8', 'Tablet mạnh mẽ dành cho công việc', 19990000, 'tabs8.jpg', 5);