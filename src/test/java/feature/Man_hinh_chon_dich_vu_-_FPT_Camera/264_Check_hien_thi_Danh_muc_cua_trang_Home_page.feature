# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check hiển thị Danh mục của trang Home page

	Scenario: Check hiển thị Danh mục của trang Home page
		Given Truy cập hệ thống DKOL
		When Truy cập trang homepage thành công
		Then Hiển thị các thanh menu. Trang chủ - Internet - FPT Play - FPT Camera - FPT Play Box - Ultra Fast - Tin tức - Icon search - Location