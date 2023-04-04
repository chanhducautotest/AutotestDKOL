# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra click Sản phẩm đi kèm gói dịch vụ

	Scenario: Kiểm tra click Sản phẩm đi kèm gói dịch vụ
		Given Truy cập trang Chọn dịch vụ của gói Internet <ten_goi_cuoc> trên web DKOL
		Then Kiểm tra hiển thị Sản phẩm đi kèm gói dịch vụ
		And Kiểm tra click checkbox Thiết bị Internet