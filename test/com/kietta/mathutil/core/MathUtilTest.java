package com.kietta.mathutil.core;

import org.junit.Assert;
import org.junit.Test;

public class MathUtilTest {

    // Ta đi test ngoại lệ, tức là so sánh/đo lường ngoại lệ có xuất hiện hay không
    // khi ta đưa data sai, n < 0 hoặc n > 20
    // thay vì so sánh expected vs actual value
    // lúc này ta đi so sánh/ước lượng xem ngoại lệ có xuất hiện hay không
    // nếu có xuất hiện như kỳ vọng, hàm chạy đúng
    // nếu ngoại lệ xuất hiện như kỳ vọng, màu xanh
    @Test(expected = Exception.class)
    public void testFactorialGivenWrongArguementThrowsException() {
        //Test case #3: đưa data n âm, hoặc n quá lớn
        //              hàm được thiết kế ném về ngoại lệ
        // VD đưa vào n = -5
        // Thầy ngoại lệ xuất hiện như expected -> passed test case -> màu xanh
        System.out.println("Have to see the exception. Illegal Arguement Exception.");
        MathUtil.getFactorial(-5);

    }

    @Test

    public void testFactorialGivenRightArgumentReturnsWell() {

        //Test case #4: check n = 3, hy vọng hàm trả về 6
        //                           thực tế chưa biết
        long expected = 6;
        long actual = MathUtil.getFactorial(3);
        //so sánh expected vs actual, máy tự so sánh, không cần sout
        Assert.assertEquals(expected, actual);

        //Test case #5: check n = 4, hy vọng hàm trả về 24
        //                           thực tế chưa biết
        Assert.assertEquals(24, MathUtil.getFactorial(4));

        //Test case #6: check n = 5, hy vọng hàm trả về 120
        //                           thực tế chưa biết
        Assert.assertEquals(120, MathUtil.getFactorial(5));

    }

    @Test

    //coding convention - quy tắc viết code
    //tên hàm của test script/kiểm thử phải nói lên ý nghĩa của việc kiểm thử
    //tình huống này ta muốn test hàm getF() đúng tham số, n phải thuộc [0,...20]
    public void testFactorialGivenRightArgumentReturnsWell2() {

        //Test case #1: check n = 0, hy vọng hàm trả về 1
        //                           thực tế chưa biết
        long expected = 1;
        long actual = MathUtil.getFactorial(0);
        //so sánh expected vs actual, máy tự so sánh, không cần sout
        Assert.assertEquals(expected, actual);

        //Test case #2: check n = 1, hy vọng hàm trả về 1
        //                           thực tế chưa biết
        Assert.assertEquals(1, MathUtil.getFactorial(1));

        //Test case #3: check n = 2, hy vọng hàm trả về 2
        //                           thực tế chưa biết
        Assert.assertEquals(2, MathUtil.getFactorial(2));

    }

    @Test
    public void tryJUnitComparison() {

        //@Test sẽ ra lệnh cho thư viện JUnit mà mình đã add và import, tự động generate
        // ra hàm public static void main, biến hàm tryJUnitComparison thành hàm main, và gửi hàm main
        // cho JVM chạy, nếu có @Test ~ main, không @Test - class không có main, no runnable
        // hàm này thử nghiệm việc so sánh expected vs actual, xem sai đúng ra màu ntn
        // ta đang sài hàm của thư viện JUnit nhưng không xài bừa bãi mà phải viết có quy tắc định trước
        // Quy tắc định trước nằm ở @ - annotation        
        Assert.assertEquals(100, 100);

    }
}

//Class này dev sẽ viết những câu lệnh dùng để test hàm của code chính
// test các hàm của class MathUtil
// Trong class này sẽ có những lời gọi hàm getFactorial();
// có những câu lệnh để so sánh expected vs actual
// giống với test ở Main nhưng khác ở chỗ: sai - ra màu đỏ
//                                         đúng - ra màu xanh
// mắt không cần nhìn các dòng output từ System.out
// mắt giờ chỉ nhìn 2 màu xanh - đỏ
// Muốn có được điều này, ta sẽ dùng thêm các Unit Testing framework
// VD: JUnit, TestNG(Java), xUnit, MSTest, NUnit(C#), PHPUnit(PHP)
// Việc viết code để test code gọi là Unit Testing
// Đoạn code trong class này, dùng JUnit, Unit Testing framework để kiểm 
// thử hàm của code chính, thì đoạn code này được gọi là test script
// Code dùng để test code (chính) gọi là test script
// test script là các đoạn code được viết ra để test code chính(DAO, DTO, Controller,...)
// Nếu muốn test thì cần phải phác thảo các test case
// Test script sẽ sử dụng các test case
// VD: Viết code để test hàm getFactorial() với các case n = -5, 0, 1,..
//Quy tắc xanh - đỏ
// Màu xanh: khi tất cả các test case màu xanh, tức là expected == actual
// cho tất cả các tình huống test
// Màu đỏ: chỉ cần 1 trong những test case, chỉ cần 1 cái expected != actual
// kết luận hàm sai
// Nếu đã liệt kê các test case thì chúng phải đúng hết
// chỉ cần 1 thằng sai, hàm không ổn định về việc return, hàm sai
// đúng - đúng hết, sai - chỉ cần 1
// expected == actual -> ít nhất test case pass
// expected != actual -> test case failed.
//          Nếu expected là chính xác -> hàm xử lý sai -> bug
//          Nếu expected bị sai -> lỗi do QC
