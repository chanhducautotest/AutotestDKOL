# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra trường Nhập tên chung cư: Kiểm tra hiển thị khi chọn option Nơi khác, Kiểm tra bỏ trống, Kiểm tra nhập vào nhỏ hơn hoặc bằng 50 ký tự, Kiểm tra nhập vào lớn hơn 50 ký tự

	Scenario Outline: Kiểm tra trường Nhập tên chung cư: Kiểm tra hiển thị khi chọn option Nơi khác, Kiểm tra bỏ trống, Kiểm tra nhập vào nhỏ hơn hoặc bằng 50 ký tự, Kiểm tra nhập vào lớn hơn 50 ký tự
		Given Truy cập trang Đăng ký của gói Internet <ten_goi_cuoc> trên web DKOL
		And Chờ màn hình Đăng ký tải hoàn tất
		And Click radio button Loại nhà: CHUNG CƯ
		And Chọn option Nơi khác
		Then Kiểm tra hiển thị trường Nhập tên chung cư
		And Nhấn tiếp tục
		Then Kiểm tra hiển thị thông báo khi bỏ trống trường Nhập tên chung cư "Vui lòng nhập tên chung cư."
		And Nhập tên chung cư lớn hơn năm mươi ký tự <ten_lon_hon_50>
		Then Kiểm tra hệ thống chỉ cho phép lấy được tối đa năm mươi ký tự <ten_50>
		And Nhập tên chung cư bé hơn hoặc bằng năm mươi ký tự <ten_50> và các thông tin còn lại
		Then Kiểm tra hiển thị popups thông báo "Hệ thống chưa xác định được địa chỉ lắp đặt của Quý khách có hạ tầng hay không. Sẽ có nhân viên FPT Telecom khu vực gọi lại trong vòng 5 phút. Xin cảm ơn!" và nhấn nút Đồng ý

		@1
		Examples:
		| ten_50 | ten_goi_cuoc | ten_lon_hon_50 |
		| "duZBhgycCsZxomDFslSmOiqhNPbctdhinYEGtRtqmtMDEDmgZM" | "Sky" | "duZBhgycCsZxomDFslSmOiqhNPbctdhinYEGtRtqmtMDEDmgZMcc" |