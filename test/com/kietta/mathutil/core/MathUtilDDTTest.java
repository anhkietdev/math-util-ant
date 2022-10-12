/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kietta.mathutil.core;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static com.kietta.mathutil.core.MathUtil.*;

/**
 *
 * @author ACER
 */
@RunWith(value = Parameterized.class)
public class MathUtilDDTTest {
    
    //Chuẩn bị data, mảng 2 chiều vì nó có n đưa vào và expected
    // và có nhiều cặp như thế [7]
    // mảng 2 chiều [2]
    
    @Parameterized.Parameters
    public static Object[][] initData(){
        int a[] = {5, 10, 15, 20, 25};
        int b[][] = {{1, 0}, {1, 1}, {2, 2}, {6, 3}, {24, 4}, {120, 5}, {720, 6}};
        int c[][] = {{1, 0}, 
                     {1, 1}, 
                     {2, 2}, 
                     {6, 3}, 
                     {24, 4}, 
                     {120, 5}, 
                     {720, 6}
                    };
        return new Integer[][] {{1, 0}, 
                               {1, 1}, 
                               {2, 2}, 
                               {6, 3}, 
                               {24, 4}, 
                               {120, 5}, 
                               {720, 6}
                    };
    } // xài Wrapper class nếu chơi số, ví dụ Integer(int) Long (long)
    
    // sau khi có bộ data qua mảng 2 chiều, JUnit sẽ tự lặp for
    //để lôi ra từng cặp data (1, 0) (1, 1) (2, 2) ....
    //nhồi cặp này vào trong hàm so sánh
    //nhưng nhồi bằng cách nào ? --> gán vào biến nào đó
    //--> tham số hoá PARAMETERIZED
    //ta sẽ map/ánh xạ 2 cột ứng với 2 biến: cột 0 - expected
    //                                       cột 1 - n đưa vào hàm getF()
    
    
    @Parameterized.Parameter(value = 0)
    public long expected;
    
    
    @Parameterized.Parameter(value = 1)
    public int n;
    
    // tiến hành test vì đã có các test case và data
    
    @Test
    public void testFactorialGivenRightArgumentReturnWell(){
        Assert.assertEquals(expected, getFactorial(n));
        
        
    }
    
}

// class này chứa code để test code chính bên class MathUtil
// class này chứa code để test hàm getF coi hàm chạy đúng hông
// code viết ra dùng để test code khác/hàm khác/class khác thì đoạn
//code này hay class này được gọi tên là test script
// trong test script sẽ có những tình huống xài app - đưa data cụ thể
//vào và chờ xem hàm xử lý có như kỳ vọng hay không
// 1 test script chứa nhiều test case, mỗi test case sẽ ứng với tình huống xài hàm

// phân tích test script cũ
// trong test script cũ xuất hiện bad smell, sự trùng lặp về câu lệnh dưới đây
// Assert.assertEquals(120, MathUtil.getFactorial(5));
// lệnh so sánh hàm, lệnh gọi giá trị hàm được lặp đi lặp lại với mỗi bộ test case
// cũng hàm này, cũng lệnh này nhưng nó phải viết lại cho các bộ data sau:

// Expected          n
// 1                 0
// 1                 1
// 2                 2
// 6                 3
// 24                4
// 120               5
// 720               6

// có cách nào kiểu thay 2 con số trong lệnh so sánh bằng 2 ??? nào đó

// Assert.assertEquals(???, MathUtil.getFactorial(???));
// Assert.assertEquals(expected, MathUtil.getFactorial(n));

// Nếu ta tách được toàn bộ data trong các câu lệnh so sánh ở trên
// ra một chỗ riêng biệt như 2 cột ở trên, sau đó ta chỉ việc pick/lấy
// data này nạp/nhồi dần vào lệnh gọi hàm thì ta sẽ đạt được
// - code gọn gàng hơn, không trùng lặp
// - nhìn tổng quan, biết có bao nhiêu test case và liệu đã đủ hay chưa

// Kỹ thuật viết test script (câu lệnh test) mà tách biệt data ra khỏi lệnh
// so sánh được gọi bằng những tên sau:
// -PARAMETERIZED - Tham số hoá, biến data ra 1 chỗ, đặt cho chúng tên biến,
//sau đó nhồi chúng trở lại lệnh so sánh

// - DDT - Data driven testing - viết code kiểm thử theo style tách data
// JUnit FW hỗ trợ sẵn ta vụ tách data, duyệt vòng for trên data nhồi
//vào hàm tương ứng

// Để chơi với DDT, ta cần
// - Tách data ra 1 chỗ - MẢNG
// - Map cái data này vào các biến tương ứng
// - Nhồi các biến tương ứng này vào câu lệnh so sánh/gọi hàm