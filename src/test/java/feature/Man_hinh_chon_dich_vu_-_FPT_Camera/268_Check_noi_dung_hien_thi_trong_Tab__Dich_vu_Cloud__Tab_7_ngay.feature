# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check nội dung hiển thị trong Tab  Dịch vụ Cloud/ Tab 7 ngày

	Scenario: Check nội dung hiển thị trong Tab  Dịch vụ Cloud/ Tab 7 ngày
		Given Truy cập hệ thống DKOL thành công
		When Điều hướng tới menu FPT Camera
		And Chọn tab dịch vụ Icloud
		And Chọn tab 7 ngày
		Then Check nội dung hiển thị trong Tab Cloud 7 ngày