# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check menu LP-Camera

	Scenario: Check menu LP-Camera
		Given Truy cập hệ thống DKOL thành công
		When Điều hướng tới menu FPT Camera
		Then Check hiển thị 2 menu Camera IQ 2 và Camera IQ 2S