# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check button Mua ngay

	Scenario: Check button Mua ngay
		Given Truy cập hệ thống DKOL thành công
		When Điều hướng tới menu FPT Camera
		And Chọn nút Camera IQ 2S
		And Check button Mua ngay
		Then Check hệ thống chuyển qua giao diện trang Thông tin đăng ký đúng FPT Camera KH chọn