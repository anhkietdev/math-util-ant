/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kietta.mathutil.core;

/**
 *
 * @author ACER
 */
//day la class mo phong lai cac ham tien ich/ dung chung cho moi noi
//class khác, mô phỏng lại class tiện ích java.Math của JDK 
//Phàm cái gì là đồ dùng chung thường đc thiết kế là static
public class MathUtil {

    public static final double PI = 3.14;

    //hàm tiện ích tính n!
    //lưu ý/quy ước:
    // - Không tính giai thừa của số âm
    // - 0! = 1! = 1
    // - Vì giai thừa tăng cực nhanh, nên 21! đã vượt 18 số 0
    // - Tràn kiểu long, nên ta không tính 21! trở lên
    public static long getFactorial(int n) {
        if (n < 0 || n > 20) 
            throw new IllegalArgumentException("Invalid n, n must be between 0 to 20");
        
        if (n == 0 || n == 1) 
            return 1;
        

        //sống đến đây chắc chắn n = 0....20
        //ko xài else khi hàm đã có return
        long product = 1;//biến cộng dồn, biến tích luỹ
        for (int i = 2; i <= n; i++) 
            product *= i;
       
        return product;
    }
}

// Học về khái niệm TDD - Test Driven Development
// Là kỹ thuật lập trình/ áp dụng cho dân dev để gia tăng chất lượng của code,
// giảm thiểu công sức tìm bug/ phát hiện bug sớm
// TDD yêu cầu dev khi viết code/viết hàm/viết class phải viết luôn các bộ kiểm thử
// hay là viết luôn các test cases/viết luôn các đoạn code dùng thử hàm để kiếm tra
// tính đúng đắn của hàm
// viết code kèm với test cases, viết code có ý thức viết luôn phần kiểm thử code/hàm
//                               dev          driven                test
// Sau khi có tên hàm thì viết luôn các tình huống xài hàm
// chấp nhận khi chạy, hàm chạy sai do code chưa xong
// sau đó ta tối ưu, chỉnh sửa code để đảm bảo code đúng
// Quá trình sai - đúng -sai có thể diễn ra liên tục
