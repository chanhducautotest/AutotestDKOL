# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra mục Thông tin khách hàng

	Scenario Outline: Kiểm tra mục Thông tin khách hàng
		Given Truy cập hệ thống DKOL
		When Vào mục internet
		And Chọn gói cước: <ten_goi_cuoc>
		Then Kiểm tra hiển thị các label: Họ và tên *, Số điện thoại *, Số CMND/CCCD *, Ngày sinh *, Giới tính, Địa chỉ email ở mục thông tin khách hàng

		@1
		Examples:
		| ten_goi_cuoc |
		| "Sky" |