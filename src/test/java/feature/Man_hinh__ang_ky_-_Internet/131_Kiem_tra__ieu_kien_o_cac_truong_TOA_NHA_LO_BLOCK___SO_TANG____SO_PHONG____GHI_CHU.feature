# Automation priority: 1
# Test case importance: Low
# language: en
Feature: Kiểm tra điều kiện ở các trường TOÀ NHÀ/LÔ/BLOCK , SỐ TẦNG *, SỐ PHÒNG *, GHI CHÚ

	Scenario Outline: Kiểm tra điều kiện ở các trường TOÀ NHÀ/LÔ/BLOCK , SỐ TẦNG *, SỐ PHÒNG *, GHI CHÚ
		Given Truy cập hệ thống DKOL
		When Vào mục internet
		And Chọn gói cước: <ten_goi_cuoc>
		And Click radio button Loại nhà: CHUNG CƯ
		And Bỏ trống trường Tòa nhà/ Lô/ Block nhập đầy đủ thông tin khác
		And Nhấn tiếp tục
		Then Kiểm tra chuyển sang màn hình Chọn dịch vụ thành công
		And Nhập vào trường TOÀ NHÀ/LÔ/BLOCK nhỏ hơn hoặc bằng năm mươi ký tự <50_ky_tu> và các thông tin còn lại
		And Nhấn tiếp tục
		And Nhập vào trường TOÀ NHÀ/LÔ/BLOCK nhỏ hơn hoặc bằng năm mươi ký tự <50_ky_tu> và các thông tin còn lại
		Then Kiểm tra chuyển sang màn hình Chọn dịch vụ thành công
		And Nhập vào trường TOÀ NHÀ/LÔ/BLOCK lớn hơn năm mươi ký tự <hon_50_ky_tu>
		Then Kiểm tra hệ thống chỉ cho phép nhập tối đa năm mươi ký tự vào trường TOÀ NHÀ/LÔ/BLOCK <50_ky_tu>
		And Bỏ trống trường SỐ TẦNG và nhấn tiếp tục
		Then Hiện thông báo khi bỏ trống trường SỐ TẦNG "Vui lòng nhập số tầng."
		And Nhập vào trường SỐ TẦNG nhỏ hơn hoặc bằng mười ký tự <so_tang_10_ky_tu> và các thông tin còn lại
		And Nhấn tiếp tục
		Then Kiểm tra chuyển sang màn hình Chọn dịch vụ thành công
		And Nhập vào trường SỐ TẦNG lớn hơn mười ký tự <so_tang_hon_10_ky_tu>
		Then Kiểm tra hệ thống chỉ cho phép nhập tối đa mười ký tự vào trường SỐ TẦNG <so_tang_10_ky_tu>
		And Bỏ trống trường SỐ PHÒNG và nhấn tiếp tục
		Then Hiện thông báo khi bỏ trống trường SỐ PHÒNG "Vui lòng nhập số phòng."
		And Nhập vào trường SỐ PHÒNG nhỏ hơn hoặc bằng mười ký tự <so_phong_10_ky_tu> và các thông tin còn lại
		And Nhấn tiếp tục
		Then Kiểm tra chuyển sang màn hình Chọn dịch vụ thành công
		And Nhập vào trường SỐ PHÒNG lớn hơn mười ký tự <so_phong_hon_10_ky_tu>
		Then Kiểm tra hệ thống chỉ cho phép nhập tối đa mười ký tự vào trường SỐ PHÒNG <so_phong_10_ky_tu>
		And Nhập vào trường GHI CHÚ lớn hơn một trăm ký tự <ghi_chu_hon_100_ky_tu>
		Then Kiểm tra hệ thống chỉ cho phép nhập tối đa một trăm ký tự vào trường GHI CHÚ <ghi_chu_100_ky_tu>

		@1
		Examples:
		| 50_ky_tu | ghi_chu_100_ky_tu | ghi_chu_hon_100_ky_tu | hon_50_ky_tu | so_phong_10_ky_tu | so_phong_hon_10_ky_tu | so_tang_10_ky_tu | so_tang_hon_10_ky_tu | ten_goi_cuoc |
		| "UpEarxfvFSqObPOyQVcMNHtPRxIwkhCaZzYTWDDutIBCMZUljJ" | "KqEADNRGyxahwhCdQSWHziNArMyclohVYKFBMBFlwqLRZcyiAjzNUFxhztctErALAYAfBALnsuDKnbfyXAnRFPQfYXHvynmdjvCB" | "KqEADNRGyxahwhCdQSWHziNArMyclohVYKFBMBFlwqLRZcyiAjzNUFxhztctErALAYAfBALnsuDKnbfyXAnRFPQfYXHvynmdjvCBY" | "UpEarxfvFSqObPOyQVcMNHtPRxIwkhCaZzYTWDDutIBCMZUljJ222" | 1111111111 | 11111111111 | 1111111111 | 11111111111 | "Sky" |