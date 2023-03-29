# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra bỏ trống, nhập > 10 và =< 10 ký tự vào trường SỐ TẦNG *

	Scenario Outline: Kiểm tra bỏ trống, nhập > 10 và =< 10 ký tự vào trường SỐ TẦNG *
		Given Truy cập trang Đăng ký của gói Internet <ten_goi_cuoc> trên web DKOL
		And Chờ màn hình Đăng ký tải hoàn tất
		And Click radio button Loại nhà: CHUNG CƯ
		And Nhấn tiếp tục
		Then Kiểm tra hiển thị thông báo khi bỏ trống trường SỐ TẦNG * "Vui lòng nhập số tầng."
		And Nhập vào trường SỐ TẦNG * lớn hơn mười ký tự <lon_hon_10_ky_tu>
		Then Kiểm tra hệ thống chỉ lấy tối đa mười ký tự <10_ky_tu> ở trường SỐ TẦNG *
		And Nhập vào trường SỐ TẦNG * nhỏ hơn hoặc bằng mười ký tự <10_ky_tu> và các thông tin còn lại
		And Nhấn tiếp tục
		Then Kiểm tra chuyển sang màn hình Chọn dịch vụ thành công

		@1
		Examples:
		| 10_ky_tu | lon_hon_10_ky_tu | ten_goi_cuoc |
		| 1111111111 | 11111111111 | "Sky" |