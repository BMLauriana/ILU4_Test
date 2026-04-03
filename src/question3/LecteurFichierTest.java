package question3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LecteurFichierTest {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Entrez le nom du fichier de sortie : ");
	        String fichierSortie = scanner.nextLine();
	        
	        String fichier = "tests_triangle.txt";
	        
	        int nbpass = 0;
	        int nbfail = 0;
	        System.out.println("Chargement");
	        try {
	            BufferedReader reader = new BufferedReader(new FileReader(fichier));
	            BufferedWriter writer = new BufferedWriter(new FileWriter("mutant/" + fichierSortie));
	            String ligne;

	            while ((ligne = reader.readLine()) != null) {

	                // découper la ligne
	                String[] parts = ligne.split(" ");

	                int a = Integer.parseInt(parts[0]);
	                int b = Integer.parseInt(parts[1]);
	                int c = Integer.parseInt(parts[2]);
	                int attendu = Integer.parseInt(parts[3]);

	                int resultat = TriangleClassifier.TypeTriangle(a, b, c);

	                if (resultat == attendu) {
	                	 writer.write(ligne + " -> PASS");
	                	 nbpass++;
	                	 
	                } else {
	                	writer.write(ligne + " -> FAIL (obtenu: " + resultat + ")");
	                	nbfail++;
	                }
	                writer.newLine();
	            }
	            writer.write("Résumé");
	            writer.newLine();
	            writer.write("PASS = "+nbpass);
	            writer.newLine();
	            writer.write("FAIL = "+nbfail);
	            
	            
	            reader.close();
	            writer.close();
	            System.out.println("\n Terminé");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	}