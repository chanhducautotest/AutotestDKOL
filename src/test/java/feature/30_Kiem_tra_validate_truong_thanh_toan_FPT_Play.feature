# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra validate trường thanh toán FPT Play

	Scenario Outline: Kiểm tra validate trường thanh toán FPT Play
		Given Truy cập hệ thống DKOL
		When Vào mục FPT Play
		And Chọn gói cước: <tengoifptplay>
		And Nhấn Mua Ngay
		And Chọn nút Tiếp tục
		Then Hiện thông báo "Vui lòng nhập họ tên"

		@1
		Examples:
		| tengoifptplay |
		| "VIP" |

		@2
		Examples:
		| tengoifptplay |
		| "MAX" |

		@3
		Examples:
		| tengoifptplay |
		| "IZI" |