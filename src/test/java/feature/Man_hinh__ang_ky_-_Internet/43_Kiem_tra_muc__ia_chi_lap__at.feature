# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra mục Địa chỉ lắp đặt

	Scenario Outline: Kiểm tra mục Địa chỉ lắp đặt
		Given Truy cập hệ thống DKOL
		When Vào mục internet
		And Chọn gói cước: <ten_goi_cuoc>
		Then Kiểm tra hiển thị các mục Tỉnh/ Thành phố, Quận/ huyện, Phường/ xã, Đường , Radio button: NHÀ RIÊNG / CHUNG CƯ, Địa chỉ/ số nhà , Ghi chú, Btn Tiếp tục

		@1
		Examples:
		| ten_goi_cuoc |
		| "Sky" |