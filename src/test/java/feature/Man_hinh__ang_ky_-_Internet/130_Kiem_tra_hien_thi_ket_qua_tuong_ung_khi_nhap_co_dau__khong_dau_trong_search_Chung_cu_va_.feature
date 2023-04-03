# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra hiển thị kết quả tương ứng khi nhập có dấu, không dấu trong search Chung cư và kiểm tra hiển thị danh sách chung cư khi chọn Phường, xã không có chung cư

	Scenario Outline: Kiểm tra hiển thị kết quả tương ứng khi nhập có dấu, không dấu trong search Chung cư và kiểm tra hiển thị danh sách chung cư khi chọn Phường, xã không có chung cư
		Given Truy cập trang Đăng ký của gói Internet <ten_goi_cuoc> trên web DKOL
		And Chờ màn hình Đăng ký tải hoàn tất
		And Click radio button Loại nhà: CHUNG CƯ
		Then Nhập giá trị có dấu vào search Chung cư <chung_cu_co_dau> và kiểm tra hiển thị đúng giá trị có dấu tương ứng trong dropdown list Chung cư
		Then Nhập giá trị không dấu vào search Chung cư <chung_cu_khong_dau> và kiểm tra hiển thị đúng giá trị có dấu tương ứng <chung_cu_co_dau> trong dropdown list Chung cư
		And Chọn Phường, xã không có chung cư
		Then Kiểm tra dropdown list chung cư chỉ hiển thị một giá trị "Nơi khác"

		@1
		Examples:
		| chung_cu_co_dau | chung_cu_khong_dau | ten_goi_cuoc |
		| "CC Lý Tự Trọng" | "CC Ly Tu Trong" | "Sky" |