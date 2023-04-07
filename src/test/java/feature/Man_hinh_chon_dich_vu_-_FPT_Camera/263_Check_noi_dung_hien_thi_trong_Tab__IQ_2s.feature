# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check nội dung hiển thị trong Tab  IQ 2s

	Scenario: Check nội dung hiển thị trong Tab  IQ 2s
		Given Truy cập hệ thống DKOL thành công
		When Điều hướng tới menu FPT Camera
		And Chọn nút Camera IQ 2S
		Then Check nội dung hiển thị trong Tab IQ 2s