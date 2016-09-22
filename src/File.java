import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class File {
	
//Attributes
	
	private Integer n, c;
	private String p[],w[];
	
//Methods
	
	//Récupération d'une ligne dans un fichier
	public static String getLineNumber(String file, int n) throws IOException{
		String r = Files.readAllLines(Paths.get(file)).get(n);
		return r;
	}
	
	//Lecture de fichier chaques lignes du fichier 
	public void read(String fileName) throws NumberFormatException, IOException{
		setN(new Integer(getLineNumber(fileName,0)));
		setP(getLineNumber(fileName,1).split(" "));
		setW(getLineNumber(fileName,2).split(" "));
		setC(new Integer(getLineNumber(fileName,3)));
	}
	
	//Ecriture d'une nouvelle ligne dans un fichier
	public void write(String fileName, String line) throws IOException{
		java.io.FileWriter outfile = new java.io.FileWriter(fileName, true); //true = append
		outfile.write(line+"\n");
		outfile.close();
	}
	

//Getters and Setters
	
	//N
	public Integer getN() {
		return n;
	}
	public void setN(Integer n) {
		this.n = n;
	}
	
	//C
	public Integer getC() {
		return c;
	}
	public void setC(Integer c) {
		this.c = c;
	}

	//P
	public String[] getP() {
		return p;
	}
	public void setP(String[] p) {
		this.p = p;
	}
	
	//W
	public String[] getW() {
		return w;
	}
	public void setW(String[] w) {
		this.w = w;
	}
		
}
