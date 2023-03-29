# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra hiển thị đúng giá trị có dấu tương ứng khi nhập giá trị không dấu và có dấu vào phần search của các trường Tỉnh, Thành phố; Quận, Huyện; Phường, xã; Đường, phố

	Scenario Outline: Kiểm tra hiển thị đúng giá trị có dấu tương ứng khi nhập giá trị không dấu và có dấu vào phần search của các trường Tỉnh, Thành phố; Quận, Huyện; Phường, xã; Đường, phố
		Given Truy cập trang Đăng ký của gói Internet <ten_goi_cuoc> trên web DKOL
		And Chờ màn hình Đăng ký tải hoàn tất
		Then Nhập giá trị có dấu vào trường Tỉnh, Thành phố <tinh_thanh_co_dau> và kiểm tra hiển thị đúng giá trị có dấu tương ứng trong dropdown list Tỉnh, Thành phố
		Then Nhập giá trị không dấu vào trường Tỉnh, thành <tinh_thanh_khong_dau> và kiểm tra hiển thị đúng giá trị có dấu <tinh_thanh_co_dau> tương ứng trong dropdown list Tỉnh, Thành phố
		Then Nhập giá trị có dấu vào trường Quận, huyện <quan_huyen_co_dau> và kiểm tra hiển thị đúng giá trị có dấu tương ứng trong dropdown list Quận, Huyện
		Then Nhập giá trị không dấu vào trường Quận, huyện <quan_huyen_khong_dau> và kiểm tra hiển thị đúng giá trị có dấu <quan_huyen_co_dau> tương ứng trong dropdown list Quận, Huyện
		Then Nhập giá trị có dấu vào trường Phường, xã <phuong_xa_co_dau> và kiểm tra hiển thị đúng giá trị có dấu tương ứng trong dropdown list Phường, xã
		Then Nhập giá trị không dấu vào trường Phường, xã <phuong_xa_khong_dau> và kiểm tra hiển thị đúng giá trị có dấu <phuong_xa_co_dau> tương ứng trong dropdown list Phường, xã
		Then Nhập giá trị có dấu vào trường Đường, Phố <duong_pho_co_dau> và kiểm tra hiển thị đúng giá trị có dấu tương ứng trong dropdown list Đường, Phố
		Then Nhập giá trị không dấu vào trường Đường, Phố <duong_pho_khong_dau> và kiểm tra hiển thị đúng giá trị có dấu <duong_pho_co_dau> tương ứng trong dropdown list Đường, Phố

		@1
		Examples:
		| duong_pho_co_dau | duong_pho_khong_dau | phuong_xa_co_dau | phuong_xa_khong_dau | quan_huyen_co_dau | quan_huyen_khong_dau | ten_goi_cuoc | tinh_thanh_co_dau | tinh_thanh_khong_dau |
		| "Lý Chính Thắng" | "Ly Chinh Thang" | "Phường 10" | "Phuong 10" | "Q3" | "Q3" | "Sky" | "Hồ Chí Minh" | "Ho Chi MInh" |