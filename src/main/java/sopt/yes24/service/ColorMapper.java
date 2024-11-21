package sopt.yes24.service;

public class ColorMapper {
    public static String getColorForSeatType(String seatType, int totalSeatTypes) {
        if (totalSeatTypes == 4) {
            switch (seatType) {
                case "VIP석":
                    return "1"; // 보라색
                case "R석":
                    return "2"; // 하늘색
                case "S석":
                    return "3"; // 파란색
                case "A석":
                    return "4"; // 노란색
                default:
                    return "1";
            }
        } else if (totalSeatTypes == 2) {
            if (seatType.contains("지정석")) {
                return "1"; // 보라색
            } else if (seatType.contains("스탠딩")) {
                return "2"; // 하늘색
            } else {
                // 그 외 2종류인 경우
                return seatType.contains("R") || seatType.contains("VIP") ? "1" : "3"; // 보라색 또는 파란색
            }
        } else {
            // 전석 동일한 경우 보라,하늘 중 보라 리턴
            return "1";
        }
    }
}
