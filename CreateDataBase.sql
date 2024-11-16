USE master
go
CREATE DATABASE finalProject;
GO
USE finalProject;
GO

CREATE TABLE tbl_User (
    userId NVARCHAR(50) NOT NULL,
    password NVARCHAR(50) NOT NULL,
    fullName NVARCHAR(50) NOT NULL,
    role NVARCHAR(10) NOT NULL,
    gmail NVARCHAR(50) NULL,
    address NVARCHAR(50) NULL,
    CONSTRAINT PK_tbl_User PRIMARY KEY CLUSTERED (userId ASC)
    WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
);
GO

INSERT INTO tbl_User (userId, password, fullName, role, gmail, address) 
VALUES 
    ('Hau', '1310', 'Huynh Ngoc Hau', 'AD', 'hauhnse183392@fpt.edu.vn', 'Ho chi minh'),   
    ('nhan', 'nhan123', 'Nguyen Ba Nhan', 'US', 'nhannbse181234@fpt.edu.vn', 'Ho chi minh'),     
    ('phat', '123', 'Phat Canlez', 'US', 'phatnse181234@fpt.edu.vn', 'Tay ninh'),       
    ('Tuan', '123', 'Pham Huu Quoc Tuan', 'AD', 'tuanphqse181234@fpt.edu.vn', 'Vung Tau'),     
    ('Tai', '123', 'Thanh Tai', 'AD', 'Taivprose181234@fpt.edu.vn', 'Bien Hoa');
GO

CREATE TABLE tbl_Watch (
    watchId NVARCHAR(50) NOT NULL,
    name NVARCHAR(50) NOT NULL,
    brand NVARCHAR(50) NOT NULL,
    description NVARCHAR(250) NULL,
    type NVARCHAR(10) NULL,
    image NVARCHAR(MAX) NULL,
    price DECIMAL(18, 2) NOT NULL,
    quantity INT NOT NULL,
    notSale BIT NULL,
    CONSTRAINT PK_tbl_Watch PRIMARY KEY CLUSTERED (watchId ASC)
    WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
);
GO

INSERT INTO tbl_Watch (watchId, name, brand, description, type, image, price, quantity, notSale)
VALUES 
    ('GST-S110-1ADR', N'Casio G Shock GST-S110-1ADR', N'Casio', N'Đồng hồ Casio G-Shock GST-S110-1ADR màu đen, cá tính, pin năng lượng mặt trời, vỏ kim loại hầm hố.', N'Male', N'img/GST-S110-1A-0000.jpg', 6999000 / 23500, 30, 0),
    ('MTP-VD01-3EV', N'Casio MTP-VD01-3EVUDF', N'Casio', N'Đồng hồ Casio MTP-VD01-3EVUDF nam, dây nhựa màu xanh, 3 kim trên nền mặt đồng hồ màu đen, chống nước wr50m.', N'Male', N'img/MTP-VD01-3EV-000.jpg', 4000000 / 23500, 30, 0),
    ('RSD-126503', N'Rolex COSMOGRAPH DAYTONA', N'Rolex', N'Rolex Cosmograph Daytona 126503 mặt số đen, kim cương trên vỏ và dây.', N'Male', N'img/Rolex1.png', 2650000000 / 23500, 30, 0),
    ('RSD-116595RBOW', N'Rolex COSMOGRAPH DAYTONA', N'Rolex', N'Rolex Cosmograph Daytona 116595RBOW với kim cương trên mặt số và dây, dành cho cả nam và nữ.', N'Both', N'img/Rolex2.png', 15500000000 / 23500, 30, 0),
    ('RSD-126610lv-0002', N'Rolex Submariner Date Oyster', N'Rolex', N'Rolex Submariner Date Oyster bằng thép Oystersteel, mặt đồng hồ màu đen và vạch số phát quang.', N'Male', N'img/Rolex3.jpg', 273970000 / 23500, 30, 0),
    ('RSD-279171-0011', N'Rolex Lady-Datejust', N'Rolex', N'Rolex Lady-Datejust bằng thép Oystersteel và vàng Everose, mặt đồng hồ màu sô-cô-la, kim cương, dây đeo Jubilee.', N'Female', N'img/Rolex4.jpg', 390000000 / 23500, 30, 0),
    ('RSD-228239-0055', N'Rolox DAY-DATE', N'Rolex', N'Đồng hồ Rolex Thiên thạch, 10 viên kim cương baguette, thiết kế sang trọng.', N'Both', N'img/Rolex5.png', 15500000000 / 23500, 30, 0),
    ('WSBB0027', N'Cartier Ballon Bleu', N'Cartier', N'Đồng hồ Ballon Bleu de Cartier, chuyển động cơ học, vỏ thép, đá Spinel tổng hợp cabochon.', N'Male', N'img/cartier1.png', 158625000 / 23500, 30, 0),
    ('W1556222', N'Cartier Rotonde De Cartier', N'Cartier', N'Rotonde de Cartier Earth and Moon, tourbillon, cỡ nòng 47mm, động cơ cơ lên dây.', N'Both', N'img/cartier2.png', 6415500000 / 23500, 30, 0),
    ('HPI00716', N'Cartier Ballon De Certier', N'Cartier', N'Vỏ vàng trắng 18K, 131 viên kim cương tổng trọng lượng 1.83 carat, vương miện với viên sapphire.', N'Female', N'img/cartier3.png', 3548500000 / 23500, 30, 0),
    ('HPI00776', N'Cartier Panthères Et Colibri', N'Cartier', N'Bộ mặt số vàng trắng 18K, kim cương tổng trọng lượng 0.78 carat, hình quả lê và sơn mài đen.', N'Both', N'img/cartier4.png', 4206500000 / 23500, 30, 0),
    ('WJCS0012', N'Cartier Coussin', N'Cartier', N'Đồng hồ Coussin de Cartier, bộ máy thạch anh, vàng trắng 750/1000, kim cương, ngọc bích, tsavorite và tourmalines.', N'Female', N'img/cartier5.png', 1856500000 / 23500, 30, 0),
    ('HPI00615', N'Cartier D-art Rotonde De Cartier', N'Cartier', N'Đồng hồ Cartier d-Art Rotonde de Cartier, tourbillon, vỏ vàng trắng 18K, mặt số họa tiết cá sấu.', N'Both', N'img/cartier6.png', 3149000000 / 23500, 30, 0),
    ('WHTN0006', N'Cartier Tonneau', N'Cartier', N'Đồng hồ Tonneau Skeleton XL, cơ lên dây, vỏ bạch kim, kim hình thanh kiếm, dây đeo da cá sấu màu xanh.', N'Both', N'img/cartier7.png', 1844750000 / 23500, 30, 0),
    ('5089G-076', N'Patek Philippe Steam Locomotives', N'Patek Philippe', N'Bộ đồng hồ Calatrava với mặt số tráng men cloisonné, vàng hoặc bạc.', N'Both', N'img/Patek1.png', 3500000000 / 23500, 30, 0),
    ('5077-100G-042', N'Patek Philippe Hummingbirds', N'Patek Philippe', N'Đồng hồ tự lên dây siêu mỏng, vỏ vàng trắng, chiêm ngưỡng bộ chuyển động qua mặt sau.', N'Both', N'img/Patek2.png', 2500000000 / 23500, 30, 0),
    ('4899-901G-00', N'Patek Philippe Calatrava', N'Patek Philippe', N'Vỏ vàng trắng, hàng kim cương xen kẽ với ngọc bích, dành cho nữ.', N'Female', N'img/Patek3.png', 2500000000 / 23500, 30, 0),
    ('5968A', N'Patek Philippe Aquanaut', N'Patek Philippe', N'Đồng hồ bấm giờ Aquanaut, trẻ trung và năng động.', N'Male', N'img/Patek4.png', 1500000000 / 23500, 30, 0),
    ('18/1300R', N'Patek Philippe Nautilus 7', N'Patek Philippe', N'Nautilus mới dành cho phụ nữ, vàng hồng hài hòa với đá quý spessartite.', N'Female', N'img/Patek5.png', 2000000000 / 23500, 30, 0),
    ('68G-00', N'Patek Philippe 5 Aquanaut Arabic', N'Patek Philippe', N'Đồng hồ Aquanaut 42.2mm, mặt số từ đen sang xanh đêm.', N'Male', N'img/Patek6.png', 2100000000 / 23500, 30, 0),
    ('RM-029', N'Richard Mille RM 029 Automatic', N'Richard Mille', N'RM 029 Le Mans Classic, thạch anh trắng nghiền, sọc kép Le Mans từ thạch anh trắng.', N'Male', N'img/RM1.jpg', 12824000000 / 23500, 30, 0),
	('RM-07-03', N'Richard Mille Bonbon', N'Richard Mille', N'Bonbon Collection RM 07-03 CUPCAKE, ceramic, bezel và vỏ TZP ceramic.', N'Both', N'img/RM2.jpg', 5160000000 / 23500, 30, 0),
	('RM-07-01', N'Richard Mille Racing Red', N'Richard Mille', N'Với RM 07-01 Racing Red , Richard Mille kỷ niệm đội đua cùng tên của họ, đội tranh tài trong Giải vô địch sức bền thế giới FIA vào tháng 4 năm 2021.', N'Male', N'img/RM3.jpg', 9160000000 / 23500, 30, 0),
	('NX.7170.LR', N'Hublot Classic Fusion Titanium', N'Hublot', N'Hublot là thương hiệu đồng hồ của Thụy Sỹ thành lập năm 1980.', N'Male', N'img/Hublot1.png', 145000000 / 23500, 30, 0),
	('SX.9900.LR', N'Hublot Big Bang Rainbow', N'Hublot', N'Hublot là thương hiệu đồng hồ của Thụy Sỹ thành lập năm 1980.', N'Both', N'img/Hublot2.png', 1980000000 / 23500, 30, 0),
	('SB.131.RX', N'Hublot BIG BANG ORIGINAL STEEL', N'Hublot', N'Hublot là thương hiệu đồng hồ của Thụy Sỹ thành lập năm 1980.', N'Both', N'img/Hublot3.png', 250000000 / 23500, 30, 0),
	('NX.2001.RX', N' Hublot Big Bang Unico', N'Hublot', N'Hublot là thương hiệu đồng hồ của Thụy Sỹ thành lập năm 1980', N'Both', N'img/Hublot4.png', 585000000 / 23500 , 30, 0),
	('OX.2611.LR', N'Hublot Classic Fusion', N'Hublot', N'Hublot là thương hiệu đồng hồ của Thụy Sỹ thành lập năm 1980.', N'Female', N'img/Hublot5.png', 500000000 / 23500, 30, 0),
	('GST-B400BB', N'CASIO G-SHOCK', N'Casio', N'Đắm mình trong nét đẹp tinh tế, độc lạ với sự kết hợp giữa các thành phần nhựa resin và kim loại của G-STEEL trong mẫu đồng hồ G-SHOCK đen tuyền được ưa chuộng.', N'Both', N'img/casio1.png', 8962100 / 23500, 30, 0),
	('GLX-S5600-2', N'CASIO G-SHOCK', N'Casio', N'GLX-S5600, mẫu đồng hồ nhỏ hơn một chút so với mẫu cơ bản G-LIDE, có màu đất và thiết kế đậm chất bãi biển, gợi nhớ những chuyến lướt sóng gợi lên cảm giác hòa nhập với thiên nhiên.', N'Female', N'img/casio2.png', 4000000 / 23500, 30, 0),
	('LTP-2024VMG-7C', N'Đồng hồ Casio Nữ', N'Casio', N'Đồng hồ Casio Nữ LTP-2024VMG-7CDR thiết kế mặt tròn đơn giản, dây kim loại.', N'Female', N'img/casio3.png', 3768000 / 23500, 30, 0),
	('GM-2100-1ADR', N'CASIO G-SHOCK', N'Casio', N'Casio là thương hiệu đồng hồ Nhật Bản nổi tiếng ra đời vào năm 1946.', N'Male', N'img/casio4.png', 5370000 / 23500, 30, 0);

	go
	ALTER TABLE tbl_Watch
	ADD discount DECIMAL(5, 2); 
	go
	UPDATE tbl_Watch
	SET discount = 10; 
	go

-- Create the tbl_Invoice table
CREATE TABLE tbl_Invoice (
    invId NVARCHAR(50) NOT NULL,
    userId NVARCHAR(50) NOT NULL,
    gmail NVARCHAR(50) NULL,
    address NVARCHAR(50) NULL,
    purchaseDate DATETIME NULL,
    totalPrice DECIMAL(18, 2) NOT NULL,
    CONSTRAINT PK_tbl_Invoice PRIMARY KEY (invId)
    WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
);
GO

-- Insert records into tbl_Invoice
INSERT INTO tbl_Invoice (invId, userId, gmail, address, purchaseDate, totalPrice)
VALUES 
    ('INV001', 'Hau', 'hauhnse183392@fpt.edu.vn', 'Ho Chi Minh', '2024-06-11 10:00:00', 6999000.0),
    ('INV002', 'Hau', 'hauhnse183392@fpt.edu.vn', 'Ho Chi Minh', '2024-06-11 10:00:00', 4000000.0),
    ('INV003', 'nhan', 'nhannbse181234@fpt.edu.vn', 'Ho Chi Minh', '2024-06-12 15:30:00', 6999000.0);
GO



CREATE TABLE tbl_Cart (
	userId NVARCHAR(50),
    watchId NVARCHAR(50) NOT NULL,
    name NVARCHAR(50) NOT NULL,
	image NVARCHAR(MAX) NULL,
    price DECIMAL(18, 2) NOT NULL,
	quantity INT NOT NULL,
	discount DECIMAL(5, 2),
);
GO

CREATE TABLE tbl_WishList (
    userId NVARCHAR(50),
    watchId NVARCHAR(50) NOT NULL,
    CONSTRAINT uId_wId_PK PRIMARY KEY CLUSTERED (userId, watchId)
) ON [PRIMARY];



