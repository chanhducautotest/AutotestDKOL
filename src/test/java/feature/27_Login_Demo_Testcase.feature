# Automation priority: null
# Test case importance: Low
# language: en
Feature: Login Demo Testcase

	Scenario Outline: Login Demo Testcase
		Given Truy cập vào hệ thống thành công
		When Người dùng nhập <user> và <password> sai
		Then Đăng nhập thất bại

		@1
		Examples:
		| password | user |
		| "admin" | "admin" |