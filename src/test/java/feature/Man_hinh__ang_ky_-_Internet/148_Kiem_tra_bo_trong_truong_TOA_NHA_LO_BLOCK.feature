# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra bỏ trống trường TOÀ NHÀ/LÔ/BLOCK

	Scenario Outline: Kiểm tra bỏ trống trường TOÀ NHÀ/LÔ/BLOCK
		Given Truy cập trang Đăng ký của gói Internet <ten_goi_cuoc> trên web DKOL
		And Chờ màn hình Đăng ký tải hoàn tất
		And Click radio button Loại nhà: CHUNG CƯ
		And Bỏ trống trường TOÀ NHÀ/LÔ/BLOCK và nhập đầy đủ các thông tin vào trường còn lại
		And Nhấn tiếp tục
		Then Kiểm tra chuyển sang màn hình Chọn dịch vụ thành công

		@1
		Examples:
		| ten_goi_cuoc |
		| "Sky" |