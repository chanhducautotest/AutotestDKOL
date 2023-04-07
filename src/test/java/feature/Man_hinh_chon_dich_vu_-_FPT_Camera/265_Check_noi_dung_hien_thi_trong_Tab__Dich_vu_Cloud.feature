# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check nội dung hiển thị trong Tab  Dịch vụ Cloud

	Scenario: Check nội dung hiển thị trong Tab  Dịch vụ Cloud
		Given Truy cập hệ thống DKOL thành công
		When Điều hướng tới menu FPT Camera
		And Chọn tab dịch vụ Icloud
		Then Check nội dung hiển thị tab Dịch vụ Cloud