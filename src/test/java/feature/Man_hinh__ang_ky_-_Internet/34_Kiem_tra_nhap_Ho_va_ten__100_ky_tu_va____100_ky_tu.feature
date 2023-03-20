# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra nhập Họ và tên >100 ký tự và <= 100 ký tự

	Scenario: Kiểm tra nhập Họ và tên >100 ký tự và <= 100 ký tự
		Given Truy cập hệ thống DKOL
		When Vào mục Internet
		And Chọn <ten_goi_cuoc>
		Then Nhập Họ và tên <ho_ten_lon_hon_100>
		Then Kiểm tra chỉ cho phép lấy tối đa 100 ký tự
		Then Nhập họ và tên bé hơn hoặc bằng 100 ký tự <ho_ten_be_hon_bang_100> và các thông tin còn lại
		And Nhấn tiếp tục
		Then Kiểm tra chuyển sang màn hình Chọn dịch vụ thành công