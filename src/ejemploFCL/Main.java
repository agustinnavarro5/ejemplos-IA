package ejemploFCL;

import java.util.Scanner;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Main {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String fileName = "flc/tipper.fcl";
		
		FIS fis = FIS.load(fileName);
		
		if (fis == null) {
			System.err.println("El archivo "+fileName+" no se pudo cargar.");
			return;
		}

		JFuzzyChart.get().chart(fis);
		
		int ica = setVariable(0, 100, "ICA");
		
		
		fis.setVariable("ica", ica);

		int water_temperature = setVariable(0, 50, "Water Temperature");
		
		fis.setVariable("water_temperature", water_temperature);


		System.out.println("Procesando...");
		fis.evaluate();
		
		Variable probabilityVariable = fis.getVariable("probability");

		System.out.println("Resultado "+probabilityVariable.getValue());
		
		JFuzzyChart.get().chart(probabilityVariable, probabilityVariable.getDefuzzifier(), true);

	}


	private static float getProbability(float ica, float water_temperature){
		String fileName = "flc/tipper.fcl";
		
		FIS fis = FIS.load(fileName);
		
		if (fis == null) {
			return null;
		}
		
		if (0 > ica || ica > 100 || 0 > water_temperature || water_temperature > 50) {
				return null;
		}
		
		fis.setVariable("ica", ica);
		fis.setVariable("water_temperature", water_temperature);

		fis.evaluate();
		
		return fis.getVariable("probability").getValue();
	}

	
	private static int setVariable(
			int limit0,
			int limit1,
			String variable
			)
	{
		int result;
		boolean retry = true;
		do {
			System.out.println("Por favor, ingrese un valor entre "+limit0+" y "+limit1+" para "+variable+".");
			result = sc.nextInt();
						
			if (limit0 <= result && result <= limit1) {
				retry = false;
			}

		} while(retry);

		return result;
	}
}
