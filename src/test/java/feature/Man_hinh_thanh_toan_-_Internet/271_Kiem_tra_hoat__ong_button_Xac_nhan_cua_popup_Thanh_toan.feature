# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra hoạt động button Xác nhận của popup Thanh toán

	Scenario Outline: Kiểm tra hoạt động button Xác nhận của popup Thanh toán
		Given Truy cập thành công trang Thanh toán của gói Internet <ten_goi_cuoc> trên web DKOL
		And Chờ màn hình Thanh toán tải hoàn tất
		And Click chọn trong khung Hình thức thanh toán
		And Chọn hình thức thanh toán <hinh_thuc_thanh_toan>
		And Click chọn button Xác nhận
		Then Kiểm tra popup Thanh toán đã đóng, trở lại giao diện thông tin thanh toán và hiển thị hình thức thanh toán đã chọn <hinh_thuc_thanh_toan>

		@1
		Examples:
		| hinh_thuc_thanh_toan | ten_goi_cuoc |
		| "Thanh toán bằng thẻ quốc tế" | "Sky" |