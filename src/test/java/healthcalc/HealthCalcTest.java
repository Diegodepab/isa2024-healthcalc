package healthcalc;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {

	private HealthCalc calcu;
	///////////////////////////////////////////////////////////////////////////
	//////////////idealWeight() test /////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	@Test //1
	@DisplayName("Test de Altura Negativa IW")
	public void testAlturaNegativaIW() {
		assertThrows(IllegalArgumentException.class, 
		() -> calcu.idealWeight(-5, 'm'), 
		"La altura introducida es negativa");
	}
	//2
	@Test
	@DisplayName("Test de Altura menor a la esperada IW")
	public void testAlturaMenorPosibleIW() {
		assertThrows(IllegalArgumentException.class, 
		() -> calcu.idealWeight(20, 'm'), 
		"La altura introducida es menor a la esperada, recuerda que es altura en cm");
	}
	//3
	@Test
	@DisplayName("Test de Altura mayor a la esperada IW")
	public void testAlturaMayorPosibleIW() {
		assertThrows(IllegalArgumentException.class, 
		() -> calcu.idealWeight(300, 'm'), 
		"La altura introducida es demasiado alta, revisa los valores introducidos");
	}
	//4
	@Test
	@DisplayName("Test de altura problematica con la formula hombres IW")
	public void testAlturaProblemaHombresIW() {
		assertThrows(IllegalArgumentException.class, 
		() -> calcu.idealWeight(109, 'm'), 
		"La formula da error con valores lejanos al promedio, mejor contacte con especialista");
	}
	//5
	@Test
	@DisplayName("Test de altura problematica con la formula mujeres IW")
	public void testAlturaProblemaMujeresIW() {
		assertThrows(IllegalArgumentException.class, 
		() -> calcu.idealWeight(99, 'm'), 
		"La formula da error con valores lejanos al promedio, mejor contacte con especialista");
	}
	//6
	@Test
	@DisplayName("Test de sexo erroneo IW")
	public void testGenderProblematicIW() {
		assertThrows(IllegalArgumentException.class, 
		() -> calcu.idealWeight(168, 'h'), 
		"Solo se acepta entradas de 'w' for Woman (mujer) y 'm' for men (hombre) ");
	}
	//7
	@Test
	@DisplayName("Test entrada de sexo correcta IW")
	public void SexCorrectIW(){
		assertDoesNotThrow(() -> calcu.idealWeight(168, 'm'));
		assertDoesNotThrow(() -> calcu.idealWeight(168, 'M'));
		assertDoesNotThrow(() -> calcu.idealWeight(168, 'w'));
		assertDoesNotThrow(() -> calcu.idealWeight(168, 'W'));
	}
	//8
	@Test
	@DisplayName("Test hombre uso promedio IW")
	public void testHombrePromedioIW() throws Exception{
		float IW = 110 - 100 - (110 - 150) / 4f;
		assertEquals(IW, calcu.idealWeight(110, 'm'));

		IW = 168 - 100 - (168 - 150) / 4f;
		assertEquals(IW, calcu.idealWeight(168, 'm'));

		IW = 250 - 100 - (250 - 150) / 4f;
		assertEquals(IW, calcu.idealWeight(250, 'm'));
	}
	//9
	@Test
	@DisplayName("Test mujer uso promedio IW")
	public void testMujerPromedioIW() throws Exception{
		float IW = 100 - 100 - (100 - 150) / 2.5f;
		assertEquals(IW, calcu.idealWeight(100, 'w'));

		IW = 168 - 100 - (168 - 150) / 2.5f;
		assertEquals(IW, calcu.idealWeight(168, 'w'));

		IW = 250 - 100 - (250 - 150) / 2.5f;
		assertEquals(IW, calcu.idealWeight(250, 'w'));
	}
	// 10 usando calculadora para contrastar fuera del entorno
	@Test
	@DisplayName("Test hombre especifico IW")
	public void testHombreEspecificoIW() throws Exception{
		assertEquals(63.5, calcu.idealWeight(168, 'w'));
	}
	// 11
	@Test
	@DisplayName("Test mujer especifica IW")
	public void testMujerEspecificaIW() throws Exception{
		assertEquals(23, calcu.idealWeight(168, 'w'));
	}
	///////////////////////////////////////////////////////////////////////////
	//////////////basalMetabolicRate() test ///////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
}
