# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra thanh toán đơn hàng  bằng thẻ ATM thành công

	Scenario Outline: Kiểm tra thanh toán đơn hàng  bằng thẻ ATM thành công
		Given Truy cập thành công trang Thanh toán của gói Internet <ten_goi_cuoc> trên web DKOL
		And Chờ màn hình Thanh toán tải hoàn tất
		And Click chọn button Thanh toán
		Then Kiểm tra chuyển sang màn hình thanh toán của Foxpay
		And Nhập thông tin the ATM hợp lệ
		And Nhấn button tiến tục
		And Nhập thông tin OTP hợp lệ
		And Nhấn button tiến tục
		Then Kiểm tra chuyển sang màn hình Hoàn tất đăng ký thành công

		@1
		Examples:
		| ten_goi_cuoc |
		| "Sky" |