# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check Số lượng - Camera IQ 2S

	Scenario: Check Số lượng - Camera IQ 2S
		Given Truy cập hệ thống DKOL thành công
		When Điều hướng tới menu FPT Camera
		And Chọn nút Camera IQ 2S
		Then Check trường số lượng