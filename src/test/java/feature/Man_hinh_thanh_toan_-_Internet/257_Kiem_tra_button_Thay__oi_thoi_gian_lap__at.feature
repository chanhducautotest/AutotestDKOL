# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra button Thay đổi thời gian lắp đặt

	Scenario Outline: Kiểm tra button Thay đổi thời gian lắp đặt
		Given Truy cập thành công trang Thanh toán của gói Internet <ten_goi_cuoc> trên web DKOL
		And Chờ màn hình Thanh toán tải hoàn tất
		And Nhấn button Thay đổi ở thời gian lắp đặt
		Then Kiểm tra chuyển sang màn hình Chọn dịch vụ thành công

		@1
		Examples:
		| ten_goi_cuoc |
		| "Sky" |