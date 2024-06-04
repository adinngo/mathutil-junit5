/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ngovinhthang.mathutil.core;

/**
 *
 * @author gnaht
 */
public class MathUtil {

    public static long getFractorial(int n) {
        if (n < 0 || n > 20) {
            throw new IllegalArgumentException("n must be 0...20");
        }
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * getFractorial(n - 1);
    }
}
