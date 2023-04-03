# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra bố cục màn hình Thanh toán

	Scenario Outline: Kiểm tra bố cục màn hình Thanh toán
		Given Truy cập thành công trang Thanh toán của gói Internet <ten_goi_cuoc> trên web DKOL
		And Chờ màn hình Thanh toán tải hoàn tất
		Then Kiểm tra có hiển thị các bố cục của trang Thanh toán

		@1
		Examples:
		| ten_goi_cuoc |
		| "Sky" |