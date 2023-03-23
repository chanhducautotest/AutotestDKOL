# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra khi để trống, nhập vào CMND/CCCD bé hơn 9 số, lớn hơn 12 số, có chứa chữ, ký tự đặc biệt và CMND/CCCD hợp lệ

	Scenario Outline: Kiểm tra khi để trống, nhập vào CMND/CCCD bé hơn 9 số, lớn hơn 12 số, có chứa chữ, ký tự đặc biệt và CMND/CCCD hợp lệ
		Given Truy cập hệ thống DKOL
		When Vào mục internet
		And Chọn gói cước: <ten_goi_cuoc>
		And Nhấn tiếp tục
		Then Hiện thông báo chưa nhập CMND/CCCD "Vui lòng nhập CMND/CCCD."
		And Nhập Số CMND/CCCD bé hơn chín số <cmnd_be_hon_9>
		And Nhấn tiếp tục
		Then Hiện thông báo nhập sai format CMND/CCCD "CMND/CCCD phải từ 9 đến 12 chữ số."
		And Nhập Số CMND/CCCD có chứa chữ, ký tự đặc biệt <cmnd_ky_tu_dac_biet>
		Then Kiểm tra hệ thống không cho phép nhập chữ và ký tự đặc biệt vào trường CMND/CCCD
		And Nhập Số CMND/CCCD lớn hơn mười hai số <cmnd_lon_hon_12>
		Then Kiểm tra hệ thống chỉ cho phép nhập vào CMND/CCCD mười hai số <cmnd_12_so>
		And Nhập Số CMND/CCCD hợp lệ <cmnd_hop_le> và các thông tin còn lại
		And Nhấn tiếp tục
		Then Kiểm tra chuyển sang màn hình Chọn dịch vụ thành công

		@1
		Examples:
		| cmnd_12_so | cmnd_be_hon_9 | cmnd_hop_le | cmnd_ky_tu_dac_biet | cmnd_lon_hon_12 | ten_goi_cuoc |
		| 078223449106 | 0 | 0285574432 | "0$#%*:1a'?" | 0782234491069999 | "Sky" |