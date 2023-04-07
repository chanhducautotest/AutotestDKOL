# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check Giá CMR khi thay đổi Số lượng-Cameara 2S

	Scenario: Check Giá CMR khi thay đổi Số lượng-Cameara 2S
		Given Truy cập hệ thống DKOL thành công
		When Điều hướng tới menu FPT Camera
		And Chọn nút Camera IQ 2S
		And Chọn nút tăng/giảm số lượng
		Then Check Giá CMR khi thay đổi Số lượng