# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra chọn Chung cư Nơi khác và chọn Chung cư ở địa chỉ không có hạ tầng

	Scenario: Kiểm tra chọn Chung cư Nơi khác và chọn Chung cư ở địa chỉ không có hạ tầng
		Given Truy cập trang Đăng ký của gói Internet <ten_goi_cuoc> trên web DKOL
		And Chờ màn hình Đăng ký tải hoàn tất
		And Click radio button Loại nhà: CHUNG CƯ
		And Chọn option Nơi khác và nhập đầy đủ thông tin
		And Nhấn tiếp tục
		Then Kiểm tra hiển thị popups thông báo "Hệ thống chưa xác định được địa chỉ lắp đặt của Quý khách có hạ tầng hay không. Sẽ có nhân viên FPT Telecom khu vực gọi lại trong vòng 5 phút. Xin cảm ơn!" và nhấn nút Đồng ý
		And Nhập thông tin địa chỉ Chung cư không có hạ tầng và các thông tin khác
		And Nhấn tiếp tục
		Then Kiểm tra hiển thị popups thông báo "Hệ thống chưa xác định được địa chỉ lắp đặt của Quý khách có hạ tầng hay không. Sẽ có nhân viên FPT Telecom khu vực gọi lại trong vòng 5 phút. Xin cảm ơn!" và nhấn nút Đồng ý