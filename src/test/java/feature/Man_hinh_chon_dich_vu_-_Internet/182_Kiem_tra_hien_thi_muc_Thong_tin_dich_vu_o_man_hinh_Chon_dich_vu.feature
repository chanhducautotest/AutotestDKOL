# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra hiển thị mục Thông tin dịch vụ ở màn hình Chọn dịch vụ

	Scenario Outline: Kiểm tra hiển thị mục Thông tin dịch vụ ở màn hình Chọn dịch vụ
		Given Truy cập trang Chọn dịch vụ của gói Internet <ten_goi_cuoc> trên web DKOL
		Then Kiểm tra Tên gói dịch vụ đã chọn
		And Kiểm tra Mô tả gói dịch vụ
		And Kiểm tra Tỉnh thành đã chọn theo trang đăng ký
		And Kiểm tra Giá gói dịch vụ và ghi chú

		@1
		Examples:
		| ten_goi_cuoc |
		| "Sky" |