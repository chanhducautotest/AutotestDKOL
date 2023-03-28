# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra khi để trống, nhập sai thông tin, nhập chữ và ký tự đặc biệt, nhập ngày tháng năm sinh nhỏ hơn 15 tuổi, nhập bằng 15 tuổi vào trường ngày sinh.

	Scenario Outline: Kiểm tra khi để trống, nhập sai thông tin, nhập chữ và ký tự đặc biệt, nhập ngày tháng năm sinh nhỏ hơn 15 tuổi, nhập bằng 15 tuổi vào trường ngày sinh.
		Given Truy cập hệ thống DKOL
		When Vào mục internet
		And Chọn gói cước: <ten_goi_cuoc>
		And Để trống trường Ngày sinh và nhấn tiếp tục
		Then Hiện thông báo khi để trống trường Số điện thoại "Vui lòng nhập ngày sinh"
		And Nhập sai thông tin trong trường ngày sinh <ngay_sinh_sai>
		And Nhấn tiếp tục
		Then Hiện thông báo khi nhập sai thông tin trong trường ngày sinh "Năm sinh không hợp lệ"
		And Nhập số điện thoại có chứa chữ, ký tự đặc biệt <ngay_sinh_dac_biet>
		Then Kiểm tra hệ thống không cho phép nhập chữ, ký tự đặc biệt vào trường Ngày sinh
		And Nhập ngày tháng năm sinh nhỏ hơn mười lăm tuổi <ngay_sinh_nho_hon_15t>
		And Nhấn tiếp tục
		Then Hiển thị thông báo khi nhập vào ngày sinh nhỏ hơn mười lăm tuổi "Khách hàng phải lớn hơn 15 tuổi"
		And Nhập ngày tháng năm sinh bằng mười lăm tuổi <ngay_sinh_15t> và các thông tin còn lại
		And Nhấn tiếp tục
		Then Kiểm tra chuyển sang màn hình Chọn dịch vụ thành công

		@1
		Examples:
		| ngay_sinh_15t | ngay_sinh_dac_biet | ngay_sinh_nho_hon_15t | ngay_sinh_sai | ten_goi_cuoc |
		| "27/03/2008" | "@#/*&/?Ab)" | "27/03/2023" | "01/01/0011" | "Sky" |