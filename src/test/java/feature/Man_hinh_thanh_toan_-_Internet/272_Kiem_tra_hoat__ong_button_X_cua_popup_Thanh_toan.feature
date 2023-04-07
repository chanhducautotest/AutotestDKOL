# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra hoạt động button X của popup Thanh toán

	Scenario Outline: Kiểm tra hoạt động button X của popup Thanh toán
		Given Truy cập thành công trang Thanh toán của gói Internet <ten_goi_cuoc> trên web DKOL
		And Chờ màn hình Thanh toán tải hoàn tất
		And Click chọn trong khung Hình thức thanh toán
		And Click chọn button X
		Then Kiểm tra popup Thanh toán đã đóng và trở lại giao diện thông tin thanh toán giữ nguyên hình thức thanh toán mặc định <hinh_thuc_mac_dinh>

		@1
		Examples:
		| hinh_thuc_mac_dinh | ten_goi_cuoc |
		| "Thanh toán bằng thẻ ATM" | "Sky" |