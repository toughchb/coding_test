package heyplay;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class Test2Test {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void shouldInvert() {

        exceptionRule.expect(NullPointerException.class);
        String nullTest = Inverter.invert(null);

        String inverted = Inverter.invert("");
        assertEquals("Empty String.", "",inverted);

        inverted = Inverter.invert("abcd");
        assertEquals("Simple String", "dcba",inverted);

        inverted = Inverter.invert("c");
        assertEquals("One Character","c",inverted);

        inverted = Inverter.invert("ABCD");
        assertNotEquals("Not Equals Test", "abcd", inverted);

        //Assert.fail();
    }

    @Test
    public void emptyString() {
        String inverted = Inverter.invert("");
        assertEquals("Empty String.", "",inverted);
    }

    @Test
    public void longString() {
        String inverted = Inverter.invert("abcd");
        assertEquals("Simple String", "dcba",inverted);
    }

    @Test
    public void oneChar() {
        String inverted = Inverter.invert("c");
        assertEquals("One Character","c",inverted);
    }

    @Test
    public void wrongTest() {
        String inverted = Inverter.invert("ABCD");
        assertNotEquals("Not Equals Test", "abcd", inverted);
    }
}