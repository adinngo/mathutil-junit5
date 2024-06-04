/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ngovinhthang.mathutil.core;

import static com.ngovinhthang.mathutil.core.MathUtil.getFractorial;
//import static là kĩ thuật dành riêng cho những hàm static 
//khai báo mà k cần tên class
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author gnaht
 */
public class MathUtilTest {
    
    @Test
    public void testGetFractorialGivenRightArgumentReturnsWell() {
        assertEquals(120, getFractorial(5));
    }
    
    //bắt ngoại lệ
    
     @Test
    public void testGetFractorialGivenWrongArgumentThrowsException() {
        //xài biểu thức lambda
        //hàm nhận tham số là một cái object/có code implement cái
        //functional interface tên là Executable - có 1 hàm duy nhất k có code tên là execute()
        //chơi chậm 
//        Executable exObject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                getFractorial(21);
//            }
//        }
        
         assertThrows(IllegalArgumentException.class, () -> getFractorial(21));
         
    }
    
    //DDT
    //tách data ra khỏi câu lệnh kiểm thử và tham số hóa data này
    //vào trong câu lệnh kiểm thử
    //chuẩn bị bộ data
    public static Object[][] initData() {
        return new Integer[][] {
            {0, 1},
            {1, 1},
            {2, 2},
            {3, 6},
            {4, 24},
            {5, 120},
            {6, 720}
        };
    }
      @ParameterizedTest
      @MethodSource(value = "initData") //tên hàm cung cấp data và ngầm định thứ tự của các phần tử trong mảng
                                        //map vào tham số hàm
    public void testGetFractorialGivenRightArgumentReturnsWell(int input, long expected) {
        assertEquals(expected, getFractorial(input));
    }
}
