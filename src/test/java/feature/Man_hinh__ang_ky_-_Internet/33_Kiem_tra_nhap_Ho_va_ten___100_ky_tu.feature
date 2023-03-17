# Automation priority: 2
# Test case importance: Low
# language: en
Feature: Kiểm tra nhập Họ và tên > 100 ký tự

	Scenario: Kiểm tra nhập Họ và tên > 100 ký tự
		Given Truy cập hệ thống DKOL
		When Vào mục Internet
		And Chọn <ten_goi_cuoc>
		Then Kiểm tra hệ thống chỉ cho phép nhập 100 ký tự <ho_ten>