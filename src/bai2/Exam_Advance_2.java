package bai2;

import java.util.Scanner;
import java.util.Stack;

public class Exam_Advance_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Lấy số ISBN gồm 10 chữ số từ người dùng.
        System.out.print("Nhập số ISBN (10 chữ số): ");
        String input = scanner.nextLine();

        // Bước 2: Kiểm tra xem người dùng có nhập số có mười chữ số hay không.
        if (input.length() != 10) {
            System.out.println("Số ISBN phải có 10 chữ số. Hãy thử lại.");
            return;
        }

        // Bước 3: Sử dụng Stack để lưu trữ các chữ số và tính tổng.
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        try {
            for (int i = 0; i < input.length(); i++) {
                int digit = Integer.parseInt(String.valueOf(input.charAt(i)));
                stack.push(digit);
                sum += (i + 1) * digit;
            }

            // Bước 4: Kiểm tra điều kiện và đưa ra kết luận.
            if (sum % 11 == 0) {
                System.out.println("ISBN hợp lệ.");
            } else {
                System.out.println("ISBN không hợp lệ.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Nhập không hợp lệ. Hãy nhập số nguyên.");
        }
    }
}
