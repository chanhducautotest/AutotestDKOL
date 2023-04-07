# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra mục Thời gian lắp đặt

	Scenario Outline: Kiểm tra mục Thời gian lắp đặt
		Given Truy cập trang Chọn dịch vụ của gói Internet <ten_goi_cuoc> trên web DKOL
		Then Kiểm tra Dropdownlist chọn Ngày
		Then Kiểm tra Dropdownlist chọn Giờ
		Then Click button Tiếp tục để chuyển qua bước tiếp

		@1
		Examples:
		| ten_goi_cuoc |
		| "Sky" |