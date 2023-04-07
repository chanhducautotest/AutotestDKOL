# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check nội dung hiển thị trong Tab  Dịch vụ Cloud/ Tab 1 ngày

	Scenario: Check nội dung hiển thị trong Tab  Dịch vụ Cloud/ Tab 1 ngày
		Given Truy cập hệ thống DKOL thành công
		When Điều hướng tới menu FPT Camera
		And Chọn tab dịch vụ Icloud
		Then Check nội dung hiển thị trong Tab Cloud 1 ngày