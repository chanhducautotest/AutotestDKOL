# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra click hyperlink Thay đổi

	Scenario Outline: Kiểm tra click hyperlink Thay đổi
		Given Truy cập trang Chọn dịch vụ của gói Internet <ten_goi_cuoc> trên web DKOL
		When Click button Thay đổi
		Then Kiểm tra hiển thị Pop-up Lựa chọn gói cước
		And Kiểm tra click icon X trong popup

		@1
		Examples:
		| ten_goi_cuoc |
		| "Sky" |