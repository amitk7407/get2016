import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestBinaryToOctal {
	int num = 110101;
	BinaryToOctal binaryToOctal = new BinaryToOctal();
	
	@Test
	public void testConvertBinaryToOctal() {
		assertEquals("Conversion is successful !", 65, binaryToOctal.convertBinaryToOctal(num));
	}
}