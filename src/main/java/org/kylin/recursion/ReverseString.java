package org.kylin.recursion;

import org.junit.Test;
import org.kylin.utils.ColorfulPrintUtil;

/**
 * Reverse String
 */
public class ReverseString {

    public static void Reverse(int n, String str) {
        if (n == str.length()) {
            return;
        }

        Reverse(n + 1, str);
        ColorfulPrintUtil.printCyan(str.charAt(n) + "\t");
    }

    @Test
    public void TestReverseString() {
        Reverse(0, "algorithm");
    }
}
