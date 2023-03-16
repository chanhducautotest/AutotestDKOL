# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra thông báo khi để trống trường Họ và tên

	Scenario Outline: Kiểm tra thông báo khi để trống trường Họ và tên
		Given Truy cập hệ thống DKOL
		When Vào mục internet
		Then Chọn gói cước: <ten_goi_cuoc>
		And Nhấn Tiếp Tục
		Then Hiện thông báo "Vui lòng nhập họ tên"

		@1
		Examples:
		| ten_goi_cuoc |
		| "Sky" |