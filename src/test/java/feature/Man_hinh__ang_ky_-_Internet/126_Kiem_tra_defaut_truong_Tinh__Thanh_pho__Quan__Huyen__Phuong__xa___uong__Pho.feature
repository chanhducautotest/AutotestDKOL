# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra defaut trường Tỉnh, Thành phố; Quận, Huyện; Phường, xã; Đường, Phố

	Scenario Outline: Kiểm tra defaut trường Tỉnh, Thành phố; Quận, Huyện; Phường, xã; Đường, Phố
		Given Truy cập hệ thống DKOL
		When Vào mục internet
		And Chọn gói cước: <ten_goi_cuoc>
		Then Kiểm tra giá trị default của trường Tỉnh, Thành phố <default_tinh_thanh> và Combobox cho phép chọn giá trị
		Then Kiểm tra giá trị default của trường Quận, huyện <default_quan_huyen> và Combobox cho phép chọn giá trị
		Then Kiểm tra giá trị default của trường Phường, xã <default_phuong_xa> và Combobox cho phép chọn giá trị
		Then Kiểm tra giá trị default của trường Đường, Phố <default_duong_pho> và Combobox cho phép chọn giá trị

		@1
		Examples:
		| default_duong_pho | default_phuong_xa | default_quan_huyen | default_tinh_thanh | ten_goi_cuoc |
		| "Chọn Đường/phố" | "Phường Bến Nghé" | "Q1" | "Hồ Chí Minh" | "Sky" |