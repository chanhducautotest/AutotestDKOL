# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra chuyển hướng khi nhập đầy đủ thông tin ở tất cả các trường ở màn hình Thông tin đăng ký

	Scenario Outline: Kiểm tra chuyển hướng khi nhập đầy đủ thông tin ở tất cả các trường ở màn hình Thông tin đăng ký
		Given Truy cập trang Thông tin đăng ký của gói Internet <ten_goi_cuoc> trên web DKOL
		When Nhập Thông tin cá nhân
		And Chọn Địa chỉ lắp đặt Chung cư
		And Chọn button Tiếp tục
		Then Kiểm tra chuyển sang màn hình Chọn dịch vụ thành công
		Then Kiểm tra hiển thị các mục: Thông tin dịch vụ, Lựa chọn gói cước, Thời gian lắp đặt, Button Tiếp tục

		@test
		Examples:
		| ten_goi_cuoc |
		| "Sky" |