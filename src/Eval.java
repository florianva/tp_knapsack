public class Eval {
	
//Attributes
	
	private static float z;
	private static float weight;
	private static float r;
	private static float m;
	

//Methods

	//Calcul du profit selon une possibilité d'objets à emporter
	public static float profit(int n, String[] p, String[] w, boolean[] b, int c, float beta){
		
		//Initialisation
		setZ(0);
		setWeight(0);
		
		//Pour chaque objet dans le sac
		for(int i=0; i<n; i++){
			if(b[i]){
				//Calcule du poids et du profit
				setWeight((float)getWeight()+new Integer(w[i]));
				setZ((float)getZ()+new Integer(p[i]));
				
				//Si le poids dépasse la contrainte
				if(getWeight() > c){
					//On recalcule le profit avec la pénalité
					setZ((float)getZ()-beta*(getWeight()-c));
				}			
			}
		}
		return getZ();
		
	}
	



	//Calcule de la pénalité en fonction des profits et des poids des objets
	public static float Beta(int n, String[] p, String[] w){
		
		//Initialisation
		setR(0);
		setM(0);
		
		//On récupère le p/w le plus élevé
		for(int i=0; i<n; i++){
			setR((float) new Integer(p[i]) / new Integer(w[i]));
			if (getR()>getM()){
				setM(getR());
			}
		}
		return getM();
	}
	
	
//Getters and Setters

	//Z
	public static float getZ() {
		return z;
	}
	public static void setZ(float z) {
		Eval.z = z;
	}
	
	//Weight
	public static float getWeight() {
		return weight;
	}
	public static void setWeight(float weight) {
		Eval.weight = weight;
	}
	
	//R
	public static float getR() {
		return r;
	}
	public static void setR(float r) {
		Eval.r = r;
	}

	//M
	public static float getM() {
		return m;
	}
	public static void setM(float m) {
		Eval.m = m;
	}
	
}
