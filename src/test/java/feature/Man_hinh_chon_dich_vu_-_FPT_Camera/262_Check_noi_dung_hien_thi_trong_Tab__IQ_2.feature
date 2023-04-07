# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check nội dung hiển thị trong Tab  IQ 2

	Scenario: Check nội dung hiển thị trong Tab  IQ 2
		Given Truy cập hệ thống DKOL thành công
		When Điều hướng tới menu FPT Camera
		And Chọn nút Camera IQ 2
		Then Check nội dung hiển thị trong Tab IQ 2