# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra UI hiển thị khi chọn Loại nhà: CHUNG CƯ

	Scenario Outline: Kiểm tra UI hiển thị khi chọn Loại nhà: CHUNG CƯ
		Given Truy cập trang Đăng ký của gói Internet <ten_goi_cuoc> trên web DKOL
		And Chờ màn hình Đăng ký tải hoàn tất
		And Click radio button Loại nhà: CHUNG CƯ
		Then Kiểm tra hiển thị Combobox: CHỌN CHUNG CƯ, Textbox TÒA NHÀ, LÔ,BLOCK, Textbox : SỐ TẦNG*, Textbox : SỐ PHÒNG*, Textbox : GHI CHÚ
		Then Kiểm tra hiển thị các placeholder của các textbox TÒA NHÀ,LÔ,BLOCK, SỐ TẦNG*, SỐ PHÒNG*, GHI CHÚ

		@1
		Examples:
		| ten_goi_cuoc |
		| "Sky" |