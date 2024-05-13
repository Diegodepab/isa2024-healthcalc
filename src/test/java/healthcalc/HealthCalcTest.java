package healthcalc;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {

	private final HealthCalcImpl calcu =  HealthCalcImpl.getInstance();
	///////////////////////////////////////////////////////////////////////////
	//////////////idealWeight() test /////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	@Test //1
	@DisplayName("Test de Altura Negativa IW")
	public void testAlturaNegativaIW() {
		assertThrows(IllegalArgumentException.class, 
		() -> calcu.idealWeight(-5, 'M'), 
		"La altura introducida es negativa");
	}
	//2
	@Test
	@DisplayName("Test de Altura menor a la esperada IW")
	public void testAlturaMenorPosibleIW() {
		assertThrows(IllegalArgumentException.class, 
		() -> calcu.idealWeight(20, 'M'), 
		"La altura introducida es menor a la esperada la formula da errores con valores lejanos al promedio, recuerda que es altura en cm");
	}
	//3
	@Test
	@DisplayName("Test de Altura mayor a la esperada IW")
	public void testAlturaMayorPosibleIW() {
		assertThrows(IllegalArgumentException.class, 
		() -> calcu.idealWeight(300, 'M'), 
		"La altura introducida es demasiado alta, revisa los valores introducidos");
	}
	//4
	@Test
	@DisplayName("Test de altura problematica con la formula hombres IW")
	public void testAlturaProblemaHombresIW() {
		assertThrows(IllegalArgumentException.class, 
		() -> calcu.idealWeight(109, 'M'), 
		"La altura introducida es menor a la esperada la formula da errores con valores lejanos al promedio, recuerda que es altura en cm");
	}
	//5
	@Test
	@DisplayName("Test de altura problematica con la formula mujeres IW")
	public void testAlturaProblemaMujeresIW() {
		assertThrows(IllegalArgumentException.class, 
		() -> calcu.idealWeight(99, 'W'), 
		"La altura introducida es menor a la esperada la formula da errores con valores lejanos al promedio, recuerda que es altura en cm");
	}
	//6
	@Test
	@DisplayName("Test de sexo erroneo IW")
	public void testGenderProblematicIW() {
		assertThrows(IllegalArgumentException.class, 
		() -> calcu.idealWeight(168, 'h'), 
		"Solo se acepta entradas de 'w' for Woman (mujer) y 'm' for men (hombre)");
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
		assertEquals(63.5, calcu.idealWeight(168, 'M'));
		
	}
	// 11
	@Test
	@DisplayName("Test mujer especifica IW")
	public void testMujerEspecificaIW() throws Exception{
		assertEquals(61, (Math.round(calcu.idealWeight(168, 'w'))));
	}
	
	private final Adapter_HealthCalc adapterCalcu = new Adapter_HealthCalc();

	@Test // 12
	@DisplayName("Comprobación de que adapter funciona correctamente")
	public void testAdapterIW() throws Exception {
		float IW = 110 - 100 - (110 - 150) / 4f;
		assertEquals(IW, adapterCalcu.pesoIdeal('m', 1.1f));
		
		IW = 160 - 100 - (160 - 150) / 2.5f;
		assertEquals(IW, adapterCalcu.pesoIdeal('w', 1.6f));
	}
	
	Proxy_Registro_HealthCalc statsCalcu = new Proxy_Registro_HealthCalc(adapterCalcu);
	@Test // 13
	@DisplayName("Comprobación de que proxy funciona correctamente")
	public void testProxyIW() throws Exception {
		float IW = statsCalcu.pesoIdeal('m', 1.7f);
		assertEquals(statsCalcu.alturaMedia(), 1.7f);
		IW = statsCalcu.pesoIdeal('m', 1.3f);
		assertEquals(statsCalcu.alturaMedia(), 1.5f);
		assertEquals(statsCalcu.numSexoH(), 2);
	}
	///////////////////////////////////////////////////////////////////////////
	//////////////basalMetabolicRate() test ///////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	@Test //1
	@DisplayName("Test entrada incorrecta peso BMR")
	public void testPesoIncorrectoBMR() {
		assertThrows(IllegalArgumentException.class, 
		() -> calcu.basalMetabolicRate(-1, 168, 'M', 22), 
		"valor de peso incorrecto (solo se aceptaran valores dentro del umbral 20kg<X<650kg)");
	}
	@Test //2  
	@DisplayName("Test entrada incorrecta altura BMR")
	public void testAlturaIncorrectaBMR() {
		assertThrows(IllegalArgumentException.class, 
		() -> calcu.basalMetabolicRate(60, 0, 'M', 22), 
		"valor de altura incorrecto (solo se aceptaran valores dentro del umbral 40cm<X<275cm)");
	}
	@Test //3    
	@DisplayName("Test entrada incorrecta sexo BMR")
	public void testSexoIncorrectoBMR() {
		assertThrows(IllegalArgumentException.class, 
		() -> calcu.basalMetabolicRate(60, 168, 'A', 22), 
		"valor de sexo incorrecto (solo se aceptaran valores correspondientes a 'm' y 'w')");
	}
	@Test //4
	@DisplayName("Test entrada incorrecta edad BMR")
	public void testEdadIncorrectaBMR() {
		assertThrows(IllegalArgumentException.class, 
		() -> calcu.basalMetabolicRate(60, 168, 'M', 2001), 
		"edad incorrecto (solo se aceptaran valores dentro del umbral 0<X<100 años)");
	}
	@Test //5
	@DisplayName("Test entradas raras BMR")
	public void testValoresRarosBMR() {
		assertThrows(IllegalArgumentException.class, 
		() -> calcu.basalMetabolicRate(21, 41, 'W', 99), 
		"valores introducidos no son adecuados para el calculo");
	}
	@Test //6
	@DisplayName("Test entrada de TODOS los sexos BMR")
	public void SexCorrectoBMR(){
		assertDoesNotThrow(() -> calcu.basalMetabolicRate(60, 168, 'M', 21));
		assertDoesNotThrow(() -> calcu.basalMetabolicRate(60, 168, 'm', 21));
		assertDoesNotThrow(() -> calcu.basalMetabolicRate(60, 168, 'w', 21));
		assertDoesNotThrow(() -> calcu.basalMetabolicRate(60, 168, 'W', 21));
	}
	@Test //7
	@DisplayName("Test mujer promedio BMR")
	public void testWomanBMR() throws Exception{
		float BMR = (float) (10 * 21 + 6.25 * 150 - 5 * 13 - 161);
		assertEquals(BMR, calcu.basalMetabolicRate(21, 150, 'w', 13));

		BMR = (float) (10 * 65 + 6.25 * 167 - 5 * 22 - 161);
		assertEquals(BMR, calcu.basalMetabolicRate(65, 167, 'w', 22));

		BMR = (float) (10 * 80 + 6.25 * 170 - 5 * 55 - 161);
		assertEquals(BMR, calcu.basalMetabolicRate(80, 170, 'w', 55));
	}
	@Test //8
	@DisplayName("Test hombre promedio BMR")
	public void testMenBMR() throws Exception{
		float BMR = (float) (10 * 21 + 6.25 * 150 - 5 * 13 + 5);
		assertEquals(BMR, calcu.basalMetabolicRate(21, 150, 'M', 13));

		BMR = (float) (10 * 65 + 6.25 * 167 - 5 * 22 + 5);
		assertEquals(BMR, calcu.basalMetabolicRate(65, 167, 'M', 22));

		BMR = (float) (10 * 80 + 6.25 * 170 - 5 * 55 + 5);
		assertEquals(BMR, calcu.basalMetabolicRate(80, 170, 'M', 55));
	}
	@Test //9 usando calculadora para contrastar la formula
	@DisplayName("Test mujer Externa BMR")
	public void testWomanExternaBMR() throws Exception{
		assertEquals(1390.25, calcu.basalMetabolicRate(60, 169, 'W', 21));
		
	}
	// 11
	@Test
	@DisplayName("Test hombre Externo BMR")
	public void testMenExternoBMR() throws Exception{
		assertEquals(1556.25, (calcu.basalMetabolicRate(60, 169, 'M', 21)));
	}
	
	@Test // 12
	@DisplayName("Comprobación de que adapter funciona correctamente BMR")
	public void testAdapterBMR() throws Exception {
		float BMR = (float) (10 * 21 + 6.25 * 150 - 5 * 13 - 161);
		assertEquals(BMR, adapterCalcu.bmr('w', 13, 1.5f, 21000));
		
		BMR = (float) (10 * 80 + 6.25 * 170 - 5 * 55 + 5);
		assertEquals(BMR, adapterCalcu.bmr('m', 55, 1.7f, 80000));
	}
	
	@Test // 13
	@DisplayName("Comprobación de que proxy funciona correctamente BMR")
	public void testProxyBMR() throws Exception {
		double BMR = statsCalcu.bmr('m', 13, 1.5f, 21000);
		assertEquals(statsCalcu.edadMedia(), 13);	
		BMR = statsCalcu.bmr('m', 17, 1.5f, 21000);
		assertEquals(statsCalcu.edadMedia(), 15);
		assertEquals(statsCalcu.numSexoH(), 2);
	}
	

    Castellano_Mensaje mensaje= new Castellano_Mensaje(statsCalcu);

    America_Version_HealthCalc calcu_americana= new America_Version_HealthCalc(mensaje);
    Europa_Version_HealthCalc calcu_Europa= new Europa_Version_HealthCalc(mensaje);
	@Test // 14
	@DisplayName("Comprobación de que decorador funciona correctamente")
	public void testDecoradorBMR() throws Exception {
		System.out.println("Mensaje en Español:");
		double BMR = calcu_americana.bmr('m', 20,  6.57f, 222);
		BMR = calcu_Europa.bmr('m', 22,  1.68f, 65000);
		System.out.println(" ");
	}
	
    Ingles_Mensaje message= new Ingles_Mensaje(statsCalcu);

    America_Version_HealthCalc calcu_americana2= new America_Version_HealthCalc(message);
    Europa_Version_HealthCalc calcu_Europa2= new Europa_Version_HealthCalc(message);
	@Test // 15
	@DisplayName("Comprobación de que el mensaje en inglés funciona correctamente")
	public void testDecoradorBMR_INGLES() throws Exception {
		System.out.println("Mensaje en Inglés:");
		System.out.print("Versión americana:");
		double BMR = calcu_americana2.bmr('m', 20,  6.57f, 222);
		System.out.print("Versión Europa:");
		BMR = calcu_Europa2.bmr('m', 22,  1.68f, 65000);
	}
}
