# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra nhập vào trường GHI CHÚ > 100 ký tự

	Scenario Outline: Kiểm tra nhập vào trường GHI CHÚ > 100 ký tự
		Given Truy cập trang Đăng ký của gói Internet <ten_goi_cuoc> trên web DKOL
		And Chờ màn hình Đăng ký tải hoàn tất
		And Click radio button Loại nhà: CHUNG CƯ
		And Nhập vào trường ghi chú nhiều hơn một trăm ký tự <ghi_chu_hon_100_ky_tu>
		Then Kiểm tra hệ thống chỉ lấy tối đa một trăm ký tự vào trường GHI CHÚ <ghi_chu_100_ky_tu>

		@1
		Examples:
		| ghi_chu_100_ky_tu | ghi_chu_hon_100_ky_tu | ten_goi_cuoc |
		| "KqEADNRGyxahwhCdQSWHziNArMyclohVYKFBMBFlwqLRZcyiAjzNUFxhztctErALAYAfBALnsuDKnbfyXAnRFPQfYXHvynmdjvCB" | "KqEADNRGyxahwhCdQSWHziNArMyclohVYKFBMBFlwqLRZcyiAjzNUFxhztctErALAYAfBALnsuDKnbfyXAnRFPQfYXHvynmdjvCBY" | "Sky" |