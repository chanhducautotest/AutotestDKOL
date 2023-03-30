# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra nhập > 50 và =< 50 ký tự vào trường TOÀ NHÀ/LÔ/BLOCK

	Scenario Outline: Kiểm tra nhập > 50 và =< 50 ký tự vào trường TOÀ NHÀ/LÔ/BLOCK
		Given Truy cập trang Đăng ký của gói Internet <ten_goi_cuoc> trên web DKOL
		And Chờ màn hình Đăng ký tải hoàn tất
		And Click radio button Loại nhà: CHUNG CƯ
		And Nhập vào trường TOÀ NHÀ,LÔ,BLOCK lớn hơn năm chục ký tự <lon_hon_50_ky_tu>
		Then Kiểm tra hệ thống chỉ lấy tối đa năm chục ký tự <50_ky_tu> ở trường TOÀ NHÀ,LÔ,BLOCK
		And Nhập vào trường TOÀ NHÀ,LÔ,BLOCK nhỏ hơn hoặc bằng năm chục ký tự <50_ky_tu_chinh_xac> và các thông tin còn lại
		And Nhấn tiếp tục
		Then Kiểm tra chuyển sang màn hình Chọn dịch vụ thành công

		@1
		Examples:
		| 50_ky_tu | 50_ky_tu_chinh_xac | lon_hon_50_ky_tu | ten_goi_cuoc |
		| "duZBhgycCsZxomDFslSmOiqhNPbctdhinYEGtRtqmtMDEDmgZM" | "BVP Liên Hoa" | "duZBhgycCsZxomDFslSmOiqhNPbctdhinYEGtRtqmtMDEDmgZMcc" | "Sky" |