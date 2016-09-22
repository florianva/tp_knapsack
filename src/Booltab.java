import java.util.Random;


public class Booltab {

	Random random = new Random();
	
	//Calcul aléatoire d'un tableau de booléens de taille n
	public boolean[] init(int n){
		boolean[] b = new boolean[n] ;
		for(int i=0; i<n;i++){
			b[i]=random.nextBoolean();
		}
		
		return b;
		
	}
	
}
