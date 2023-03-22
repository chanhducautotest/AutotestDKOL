# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra chọn icon X ở cuối textbox Họ và tên

	Scenario Outline: Kiểm tra chọn icon X ở cuối textbox Họ và tên
		Given Truy cập hệ thống DKOL
		When Vào mục internet
		And Chọn gói cước: <ten_goi_cuoc>
		Then Nhập Họ và tên <ho_ten>
		And Nhấn chọn icon X
		And Kiểm tra nội dung vừa nhập ở textbox Họ và tên đã được xóa

		@1
		Examples:
		| ho_ten | ten_goi_cuoc |
		| "Tạ Minh Chánh Đức" | "Sky" |