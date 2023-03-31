# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra hiển thị trường txtbox Địa chỉ, Số nhà, txtbox Ghi chú khi Loại nhà defaut: Nhà riêng, kiểm tra placeholder, để trống ,nhập lớn hơn 30 ký tự vào trường Địa chỉ, Số nhà

	Scenario Outline: Kiểm tra hiển thị trường txtbox Địa chỉ, Số nhà, txtbox Ghi chú khi Loại nhà defaut: Nhà riêng, kiểm tra placeholder, để trống ,nhập lớn hơn 30 ký tự vào trường Địa chỉ, Số nhà
		Given Truy cập trang Đăng ký của gói Internet <ten_goi_cuoc> trên web DKOL
		And Chờ màn hình Đăng ký tải hoàn tất
		Then Kiểm tra hiển thị trường txtbox Địa chỉ, Số nhà, txtbox Ghi chú khi trường Loại nhà là default: Nhà riêng
		Then Kiểm tra placeholder text của trường Địa chỉ, Số nhà <placeholder_diachi>
		And Nhấn tiếp tục
		Then Hiện thông báo khi để trống trường Địa chỉ, số nhà "Vui lòng nhập địa chỉ/số nhà."
		And Nhập vào trường Địa chỉ, Số nhà lớn hơn ba mươi ký tự <dia_chi_lon_hon_30>
		Then Kiểm tra hệ thống chỉ cho phép lấy tối đa ba mươi ký tự <dia_chi_30> vào trường địa chỉ

		@1
		Examples:
		| dia_chi_30 | dia_chi_lon_hon_30 | placeholder_diachi | ten_goi_cuoc |
		| "DFCdIYhJdUhIDFSpKVDJaKPBIFWGVd" | "DFCdIYhJdUhIDFSpKVDJaKPBIFWGVd333" | "Ví dụ: 16, Hẻm 32, Ngách 65, Ngõ 165" | "Sky" |