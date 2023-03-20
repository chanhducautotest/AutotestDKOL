# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra nhấn chọn Logo FPT Telecom

	Scenario Outline: Kiểm tra nhấn chọn Logo FPT Telecom
		Given Truy cập hệ thống DKOL
		When Vào mục internet
		And Chọn gói cước: <ten_goi_cuoc>
		Then Kiểm tra click vào logo FPT Telecom và trở về trang chủ DKOL

		@1
		Examples:
		| ten_goi_cuoc |
		| "Sky" |