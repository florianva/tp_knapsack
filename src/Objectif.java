import java.io.FileNotFoundException;
import java.io.IOException;

public class Objectif {
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		String fileInName = "ks_1000.txt";
		String fileOutName = "hc.csv";
		int nbEval;
		float profitmax = 0;
		int repetitions = 20;
		File f = new File();
		
		int[] tabNbEval = {100, 200, 300, 400, 500};
		
		for(int nb=0 ; nb<tabNbEval.length; nb++){
			nbEval = tabNbEval[nb];
			//Nombre de fois à executer le programme
			for (int x=0;x<repetitions;x++){
				
				//Lancement de l'algorithme aleatoire
				//Aleatoire a = new Aleatoire();
				//MarcheAleatoire a = new MarcheAleatoire();
				HillClimber a = new HillClimber();
				
				profitmax = a.getProfitMax(fileInName,nbEval);
	
				//Ecriture de la ligne dans le fichier csv
				String line = nbEval+";"+profitmax;
				f.write(fileOutName, line);		
			}
		}		
	}
	
	
		
}
