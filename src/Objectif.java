import java.io.FileNotFoundException;
import java.io.IOException;

public class Objectif {
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		String fileInName = "ks_1000.txt";
		String fileOutName = "result.csv";
		int nbEval = 1000;
		float profitmax = 0;
		int repetitions = 200;
		File f = new File();
		
		//Nombre de fois à executer le programme
		for (int x=0;x<repetitions;x++){
			
			//Lancement de l'algorithme aleatoire
			Aleatoire a = new Aleatoire();
			profitmax = a.getProfitMax(fileInName,nbEval);

			//Ecriture de la ligne dans le fichier csv
			String line = nbEval+";"+profitmax;
			f.write(fileOutName, line);
			
		}
		
			
		}
	
	
		
}
