# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra popup Hình thức thanh toán

	Scenario Outline: Kiểm tra popup Hình thức thanh toán
		Given Truy cập thành công trang Thanh toán của gói Internet <ten_goi_cuoc> trên web DKOL
		And Chờ màn hình Thanh toán tải hoàn tất
		And Click chọn trong khung Hình thức thanh toán
		Then Kiểm tra hiển thị popup và các phần tử trong popup Hình thức thanh toán

		@1
		Examples:
		| ten_goi_cuoc |
		| "Sky" |