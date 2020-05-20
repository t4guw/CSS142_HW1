import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class HW_WarmUpTest {

    @org.junit.jupiter.api.Test
    void mainTestOne() {
        String data = "-5\r\n0\r\n70\r\ntrue\r\n2\r\n85\r\n78\r\nA\r\n50\r\n51\r\rn";
        InputStream stdin = System.in;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;

        System.setOut(ps);
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        HW_WarmUp.main(null);

        System.out.flush();

        System.setIn(stdin);
        System.setOut(old);

        System.out.println(baos.toString());
        String str = baos.toString();
        str.replaceAll("\n", "").replaceAll("\r", "");
        assertEquals("Enter the number for TODO 1\r\n" +
                "The number is negative\r\n" +
                "The number is zero\r\n" +
                "Enter a third number, a double, for the class average.\r\n" +
                "A passing grade\r\n" +
                "Is the answer the user reported true? Enter a Boolean value.\r\n" +
                "Value was true\r\n" +
                "The value is even\r\n" +
                "The grade is in the B range\r\n" +
                "What is the temperature\r\n" +
                "Lower than 78 degrees\r\n" +
                "no; not positive and odd or zero and even\r\n" +
                "The letter was A\r\n" +
                "Enter two integers:\r\n" +
                "Largest is 51\r\n" +
                "Smallest is 50\r\n", str);
    }

    @org.junit.jupiter.api.Test
    void max() {
        assertEquals(HW_WarmUp.max(50, 51), 51);
        assertEquals(HW_WarmUp.max(50, 50), 50);
        assertEquals(HW_WarmUp.max(-50, 50), 50);
        assertEquals(HW_WarmUp.max(50, -50), 50);
        assertEquals(HW_WarmUp.max(Integer.MAX_VALUE, Integer.MIN_VALUE), Integer.MAX_VALUE);
        assertEquals(HW_WarmUp.max(Integer.MIN_VALUE, Integer.MAX_VALUE), Integer.MAX_VALUE);
    }
}