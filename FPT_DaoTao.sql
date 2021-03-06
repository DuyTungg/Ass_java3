create database FPT_DaoTao
go
use FPT_DaoTao
go

---Tài Khoản
if OBJECT_ID('TaiKhoan') is not null
drop table TaiKhoan
go
create table TaiKhoan
(
	UsernameTK varchar(60) not null,
	PasswordTK varchar(60),
	TypeTK varchar(20),
	constraint pk_TaiKhoan primary key (UsernameTK)
)

---Danh sách sinh viên
go
if OBJECT_ID ('SinhVien') is not null
       drop table SinhVien
       go
       create table SinhVien
       (
        MaSV varchar (20) not null,
        HoTen nvarchar (60),
        SoDT varchar (20),
        Email varchar (60),
        NgaySinh date,
        GioiTinh bit,
        DiaChi nvarchar (100),
        MoTa nvarchar (100),
        constraint pk_sv primary key (MaSV)
)

---Bảng Điểm
go
if OBJECT_ID ('Diem') is not null
       drop table Diem
       go
       create table Diem
       (
        MaSV varchar (20),
        HoTen nvarchar (60),
        TinHoc float,
        TiengAnh float,
        LapTrinh float,
        DoHoa float,
        constraint pk_Diem primary key (MaSV),
        constraint fk_SinhVien_Diem foreign key (MaSV) references SinhVien (MaSV)
)
go


---Tài khoản
insert into TaiKhoan values('duytung','duytung','giangvien')
insert into TaiKhoan values('ngocduong','ngocduong','daotao')
insert into TaiKhoan values('vantuan','vantuan','giangvien')
insert into TaiKhoan values('thanhhoa','thanhhoa','daotao')
insert into TaiKhoan values('haiyen','haiyen','giangvien')
insert into TaiKhoan values('yennhi','yennhi','daotao')
select * from TaiKhoan
delete from TaiKhoan

---Sinh Viên
insert into SinhVien values('FPT00124',N'Đỗ Huy Nam','01235894215','huynam@gmail.com','01/20/1998',1,N'Hà Nội',N'Không có')
insert into SinhVien values('FPT00157',N'Vũ Văn Thủy','01587426541','vanthuy@gmail.com','02/16/1998',1,N'Thái Nguyên',N'Không có')
insert into SinhVien values('FPT00168',N'Hà Đình Phong','05894123654','dinhphong@gmail.com','05/05/1998',1,N'Hải Dương',N'Không có')
insert into SinhVien values('FPT00175',N'Vũ Thanh Hoa','01574123654','thanhhoa@gmail.com','11/27/1998',0,N'Cao Bằng',N'Không có')
insert into SinhVien values('FPT00182',N'Trần Yên Nhi','02132158741','yennhi@gmail.com','10/30/1998',0,N'Lào Cai',N'Không có')
insert into SinhVien values('FPT00188',N'Nguyễn Đình Thanh','06541248741','dinhthanh@gmail.com','04/07/1998',1,N'Thái Bình',N'Không có')
insert into SinhVien values('FPT00186',N'Ngô Đắc Hùng','04521698741','dachung@gmail.com','09/21/1998',1,N'Nam định',N'Không có')
insert into SinhVien values('FPT00194',N'Trần Thu Trang','01236547521','thutrang@gmail.com','02/19/1998',0,N'Phú Thọ',N'Không có')
insert into SinhVien values('FPT00125',N'Trần Mạnh Cường','01236585214','manhcuong@gmail.com','08/14/1998',1,N'Ninh Bình',N'Không có')
insert into SinhVien values('FPT00138',N'Phạm Vân Anh','08521474125','vananh@gmail.com','06/24/1998',0,N'Hải Phòng',N'Không có')
select * from SinhVien
delete from SinhVien


----điểm
insert into Diem values ('FPT00124',N'Đỗ Huy Nam',8,6,8,9)
insert into Diem values ('FPT00157',N'Vũ Văn Thủy',7,8,8,6)
insert into Diem values ('FPT00168',N'Hà Đình Phong',6,7,8,8)
insert into Diem values ('FPT00175',N'Vũ Thanh Hoa',9,8,7,8)
insert into Diem values ('FPT00182',N'Trần Yên Nhi',6,8,9,9)
insert into Diem values ('FPT00188',N'Nguyễn Đình Thanh',7,8,7,8)
insert into Diem values ('FPT00186',N'Ngô Đắc Hùng',6,8,7,9)
insert into Diem values ('FPT00194',N'Trần Thu Trang',7,7,6,10)
insert into Diem values ('FPT00125',N'Trần Mạnh Cường',8,8,9,9)
insert into Diem values ('FPT00138',N'Phạm Vân Anh',6,9,6,9)
select * from Diem
delete from Diem

select * from SinhVien where MaSV like '%124'