# Automation priority: null
# Test case importance: Low
# language: en
Feature: FPT Play

	Scenario Outline: FPT Play
		Given Truy cập hệ thống DKOL
		When Chọn mục FPT Play
		And Chọn <ten_goi>
		And Chọn nút mua ngay
		Then Hiển thị màn hình thanh toán

		@1
		Examples:
		| ten_goi |
		| "Gói VIP" |