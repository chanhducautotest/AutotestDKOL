# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra xử lý khi chọn button Thanh toán với hình thức thanh toán bằng ví điện tử MoMo

	Scenario Outline: Kiểm tra xử lý khi chọn button Thanh toán với hình thức thanh toán bằng ví điện tử MoMo
		Given Truy cập thành công trang Thanh toán của gói Internet <ten_goi_cuoc> trên web DKOL
		And Chờ màn hình Thanh toán tải hoàn tất
		And Click chọn trong khung Hình thức thanh toán
		And Chọn hình thức thanh toán bằng ví điện tử MoMo <hinh_thuc_thanh_toan>
		And Click chọn button Thanh toán
		Then Kiểm tra hiển thị trang QR code thanh toán MoMo

		@1
		Examples:
		| hinh_thuc_thanh_toan | ten_goi_cuoc |
		| "Thanh toán bằng Ví điện tử MoMo" | "Sky" |