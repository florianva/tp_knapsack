import java.io.IOException;

public class MarcheAleatoire {

	//Récupération du profit maximum en fonction d'un nombre d'évaluations à réaliser
	public float getProfitMax(String fileName,int nbEval) throws NumberFormatException, IOException{
	
		float profitmax =0;
		float profit=0;
		boolean[] b = null ;
		
		
		//Récupération des données du fichier
		File f = new File();
		f.read(fileName);
		int n=f.getN();
		String p[] =f.getP();
		String w[]=f.getW();
		int c=f.getC();
		
		
		//Récupération de la pénalité
		float beta = Eval.Beta(n,p,w);
		
		//On génère aléatoirement un nouveau tableau de booléen
		Booltab bool = new Booltab();
		b = bool.init(n);
		
		//Pour chaque évaluation
		for(int i=0; i<nbEval;i++){
			
			b = bool.voisin(n,b);
			
			//On récupère le profit de ce tableau
			profit = Eval.profit(n,p,w,b,c, beta);
			
			//Si le profit est le plus important sur le nombre d'évaluations réalisés, cela devient le profit maximum
			if (profit>profitmax){
				profitmax = profit;
			}
		}
	return profitmax;
	}
}
