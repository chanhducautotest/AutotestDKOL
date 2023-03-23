# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra khi để trống, nhập vào chữ, ký tự đặc biệt, nhập vào số điện thoại bé hơn 10 số, nhập vào số có số đầu khác 0 và nhập vào số điện thoại hợp lệ

	Scenario Outline: Kiểm tra khi để trống, nhập vào chữ, ký tự đặc biệt, nhập vào số điện thoại bé hơn 10 số, nhập vào số có số đầu khác 0 và nhập vào số điện thoại hợp lệ
		Given Truy cập hệ thống DKOL
		When Vào mục internet
		And Chọn gói cước: <ten_goi_cuoc>
		And Để trống trường Số điện thoại và nhấn tiếp tục
		Then Hiện thông báo khi để trống trường Số điện thoại "Vui lòng nhập số điện thoại."
		And Nhập số điện thoại có chứa chữ, ký tự đặc biệt <sdt_dac_biet>
		Then Kiểm tra hệ thống không cho phép nhập chữ, ký tự đặc biệt vào trường Số điện thoại
		And Nhập số điện thoại bé hơn mười số <sdt_be_hon_10>
		And Nhấn tiếp tục
		Then Hiện thông báo khi nhập vào số điện thoại bé hơn mười số "Số điện thoại của bạn không đúng định dạng!"
		And Nhập số điện thoại có số đầu khác không <sdt_khac_0>
		And Nhấn tiếp tục
		Then Hiện thông báo khi nhập vào số điện thoại có đầu số khác không "Số điện thoại của bạn không đúng định dạng!"
		And Nhập số điện thoại hợp lệ <sdt_hop_le> và các thông tin còn lại
		And Nhấn tiếp tục
		Then Kiểm tra chuyển sang màn hình Chọn dịch vụ thành công

		@1
		Examples:
		| sdt_be_hon_10 | sdt_dac_biet | sdt_hop_le | sdt_khac_0 | ten_goi_cuoc |
		| 090732 | "0$%:(;*^@8" | 0907323446 | 2348819075 | "Sky" |