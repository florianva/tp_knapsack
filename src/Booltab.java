import java.util.Random;


public class Booltab {

	Random random = new Random();
	float profitmax =0;
	float profit=0;
	boolean[] bMax;
	
	
	//Calcul aléatoire d'un tableau de booléens de taille n
	public boolean[] init(int n){
		boolean[] b = new boolean[n] ;
		for(int i=0; i<n;i++){
			b[i]=random.nextBoolean();
		}
		
		return b;
		
	}
	
	//Calcul aléatoire d'un tableau de booléens de taille n
		public boolean[] voisin(int n, boolean[] b){
			int i = 0 + (int)(Math.random() * n-1); 
			if (b[i] == false){
				b[i]=true;
			}else{
				b[i]=false;
			}
			return b;
			
		}
		
	//Calcul aléatoire d'un tableau de booléens de taille n
		public boolean[] hillClimber(int n, boolean[] b, String[] p, String[] w, int c, float beta, String fileName){
			
			
			//int i = 0 + (int)(Math.random() * n-1); 
			for(int i=0;i<n;i++){
				if (b[i] == false){
					b[i]=true;
				}else{
					b[i]=false;
				}
				profit = Eval.profit(n,p,w,b,c, beta);
				
				//Si le profit est le plus important sur le nombre d'évaluations réalisés, cela devient le profit maximum
				if (profit>profitmax){
					profitmax = profit;
					bMax=b;
				}
				if (b[i] == false){//A corriger
					b[i]=true;
				}else{
					b[i]=false;
				}
			}
			return bMax;
		}
	
	
}
