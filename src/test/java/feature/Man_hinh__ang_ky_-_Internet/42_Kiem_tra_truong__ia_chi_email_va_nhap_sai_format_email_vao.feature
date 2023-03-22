# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra trường Địa chỉ email và nhập sai format email vào

	Scenario Outline: Kiểm tra trường Địa chỉ email và nhập sai format email vào
		Given Truy cập hệ thống DKOL
		When Vào mục internet
		And Chọn gói cước: <ten_goi_cuoc>
		Then Kiểm tra default email <default_email>
		And Nhập email sai format <error_format_email> và nhập tất cả thông tin còn lại
		And Nhấn tiếp tục
		Then Hiện thông báo sai format email "Email không đúng định dạng."

		@1
		Examples:
		| default_email | error_format_email | ten_goi_cuoc |
		| "email@gmail.com" | "email123.mailne.com" | "Sky" |