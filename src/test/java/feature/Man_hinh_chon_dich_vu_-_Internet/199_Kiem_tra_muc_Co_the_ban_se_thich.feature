# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra mục Có thể bạn sẽ thích

	Scenario Outline: Kiểm tra mục Có thể bạn sẽ thích
		Given Truy cập trang Chọn dịch vụ của gói Internet <ten_goi_cuoc> trên web DKOL
		Then Kiểm tra hiển thị thông tin gói F-safe
		And Kiểm tra click checkbox F-safe
		And Kiểm tra hyperlink của gói F-safe
		Then Kiểm tra hiển thị gói UltraFast
		And Kiểm tra click checkbox UltraFast
		And Kiểm tra click hyperlink của gói UltraFast

		@1
		Examples:
		| ten_goi_cuoc |
		| "Sky" |