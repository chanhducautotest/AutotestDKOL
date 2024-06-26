# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra nhập Họ và tên lớn hơn 100 ký tự và bé hơn hoặc bằng 100 ký tự

	Scenario Outline: Kiểm tra nhập Họ và tên lớn hơn 100 ký tự và bé hơn hoặc bằng 100 ký tự
		Given Truy cập hệ thống DKOL
		When Vào mục internet
		And Chọn gói cước: <ten_goi_cuoc>
		Then Nhập Họ và tên lớn hơn một trăm ký tự <ho_ten_lon_hon_100>
		Then Kiểm tra chỉ cho phép lấy tối đa một trăm ký tự <ho_ten_be_hon_bang_100>
		Then Nhập họ và tên bé hơn hoặc bằng một trăm ký tự <ho_ten_be_hon_bang_100> và các thông tin còn lại
		And Nhấn tiếp tục
		Then Kiểm tra chuyển sang màn hình Chọn dịch vụ thành công

		@1
		Examples:
		| ho_ten_be_hon_bang_100 | ho_ten_lon_hon_100 | ten_goi_cuoc |
		| "sgExZXfHwkzFOlGyJuFDBwyUyvAFYpdleoIFRuFgUrXZigJAAwihFksXEvTxwkovvcqXdSFUPqAVwnWiWcDNNHWDkDLGVTRSrhNV" | "sgExZXfHwkzFOlGyJuFDBwyUyvAFYpdleoIFRuFgUrXZigJAAwihFksXEvTxwkovvcqXdSFUPqAVwnWiWcDNNHWDkDLGVTRSrhNV99" | "Sky" |