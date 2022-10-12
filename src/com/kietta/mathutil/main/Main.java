/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kietta.mathutil.main;

import com.kietta.mathutil.core.MathUtil;

/**
 *
 * @author ACER
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("This statement come from the main method");
        tryTDDFirst();
        //testFactorialGivenWrongArguementThrowsException();
        
    }
    
    public static void testFactorialGivenWrongArguementThrowsException(){
        //Test case #3: đưa data n âm, hoặc n quá lớn
        //              hàm được thiết kế ném về ngoại lệ
        // VD đưa vào n = -5
        // Thầy ngoại lệ xuất hiện như expected -> passed test case -> màu xanh
        System.out.println("Have to see the exception. Illegal Arguement Exception.");
        MathUtil.getFactorial(-5);
    }
    
    //hàm này đc viết ra để dùng thử kỹ thuật TDD
    //gọi thử/ dùng thử hàm chính bên core/bên MathUtil
    // xem nó sai đúng ra sao ở ngay mức khởi đầu viết hàm
    public static void tryTDDFirst(){
        //Test case #1
        // -Input n = 1;
        // - Gọi hàm getFactorial(1)
        // - Hi vọng hàm trả về 1 vì 1! = 1
        long expected = 1;
        long actual = MathUtil.getFactorial(1);
        //so sánh expected vs actual coi chúng nó giống nhau không
        // giống --> hàm đúng với case đang test
        // sai --> có bug với case đang test
        
        System.out.println("Test 1! status: " +
                            "Expected: " + expected +
                            " | Actual: " + actual);
        
        
        //Test case #2
        // -Input n = 2;
        // - Gọi hàm getFactorial(2)
        // - Hi vọng hàm trả về 2 vì 2! = 2
        System.out.println("Test 2! status: " +
                            "Expected: 2" +
                            " | Actual: " + MathUtil.getFactorial(2));
    }
    
}


//Test case là gì
// Là 1 tình huống xài app, kiểm thử app/ kiểm thử tính năng/ chức năng xủ lí của app
// Test case là tình huống kiểm thử app/chức năng mà khi đó ta 
// đưa vào data giả/mẫu
// đưa ra giá trị kì vọng ta mong chờ app trả ra
// sau đó ta chờ hàm tính năng xử lí xong kết quả và so sánh kết quả với kỳ vọng
// để kết vọng hàm ổn/tính năng ổn --> test case passed
// hoặc kết luận test case failed

