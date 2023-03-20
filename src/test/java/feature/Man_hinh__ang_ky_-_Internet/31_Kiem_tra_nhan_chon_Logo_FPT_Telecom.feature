# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra nhấn chọn Logo FPT Telecom

	Scenario: Kiểm tra nhấn chọn Logo FPT Telecom
		Given Truy cập hệ thống DKOL
		When Vào mục Internet
		And Chọn <ten_goi_cuoc>
		Then Kiểm tra click vào logo FPT Telecom và trở về trang chủ DKOL