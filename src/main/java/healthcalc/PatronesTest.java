package healthcalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PatronesTest {

	private final HealthCalcImpl calcu = HealthCalcImpl.getInstance();

	@Test // 1
	@DisplayName("Comprobación de que la calculadora funciona normalmente")
	public void testBasico() throws Exception {
		float IW = 110 - 100 - (110 - 150) / 4f;
		assertEquals(IW, calcu.idealWeight(110, 'm'));

		IW = 100 - 100 - (100 - 150) / 2.5f;
		assertEquals(IW, calcu.idealWeight(100, 'w'));
	}

	private final Adapter_HealthCalc adapterCalcu = new Adapter_HealthCalc();

	@Test // 2
	@DisplayName("Comprobación de que adapter va")
	public void testAdapter() throws Exception {
		float IW = 110 - 100 - (110 - 150) / 4f;
		assertEquals(IW, adapterCalcu.pesoIdeal('m', 1.1f));

		IW = 100 - 100 - (100 - 150) / 2.5f;
		assertEquals(IW, adapterCalcu.pesoIdeal('w', 1f));
	}
}
