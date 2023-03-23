# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra màn hình thông tin đăng ký Internet - Combo

	Scenario Outline: Kiểm tra màn hình thông tin đăng ký Internet - Combo
		Given Truy cập hệ thống DKOL
		When Vào mục internet
		And Chọn gói cước: <ten_goi_cuoc>
		Then Kiểm tra hiển thị: Logo FPT Telecom, Thông tin đăng ký, Chọn dịch vụ, Thông tin thanh toán, Hoàn tất đăng ký

		@1
		Examples:
		| ten_goi_cuoc |
		| "Sky" |