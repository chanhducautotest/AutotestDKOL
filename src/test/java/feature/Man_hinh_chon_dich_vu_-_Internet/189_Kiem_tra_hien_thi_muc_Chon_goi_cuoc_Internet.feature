# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra hiển thị mục Chọn gói cước Internet

	Scenario Outline: Kiểm tra hiển thị mục Chọn gói cước Internet
		Given Truy cập trang Chọn dịch vụ của gói Internet <ten_goi_cuoc> trên web DKOL
		Then Kiểm tra hiển thị thông tin gói cước Internet
		And Kiểm tra chọn radio button các gói cước Internet
		Then Kiểm tra hiển thị Sản phẩm đi kèm gói dịch vụ
		Then Kiểm tra hiển thị Mua thêm nhận ưu đãi
		And Kiểm tra chọn checkbox các dịch vụ mua thêm

		@1
		Examples:
		| ten_goi_cuoc |
		| "Sky" |