# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra default trường Giới tính và kiểm tra cho phép chọn 1 giá trị trong droplist Giới tính

	Scenario Outline: Kiểm tra default trường Giới tính và kiểm tra cho phép chọn 1 giá trị trong droplist Giới tính
		Given Truy cập hệ thống DKOL
		When Vào mục internet
		And Chọn gói cước: <ten_goi_cuoc>
		Then Kiểm tra giá trị default của trường giới tính <default_gioi_tinh>
		And Chọn giới tính: <gioi_tinh>
		Then Kiểm tra hiển thị đúng giá trị giới tính <gioi_tinh> vừa chọn

		@1
		Examples:
		| default_gioi_tinh | gioi_tinh | ten_goi_cuoc |
		| "Nam" | "Nữ" | "Sky" |