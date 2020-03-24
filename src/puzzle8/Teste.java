/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle8;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
/**
 *
 * @author Sahra Flor
 */
public class Teste {
    
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	try {	
                System.out.println("Informe o tamanho da matriz:");
		int N =   Integer.parseInt(br.readLine());
		 int[][] tiles = new int[N][N];
                 System.out.println("Informe os valores da matriz separando todos com ENTER:");
		   for (int i = 0; i < N; i++) {
		       for (int j = 0; j < N; j++) {
		          tiles[i][j] = Integer.parseInt(br.readLine());
                          //System.out.println(tiles[i][j]);
		       }
		   }
		    Puzzle8 initial = new Puzzle8(tiles);
		    Resolver resolver = new Resolver(initial);
		    Iterator<Puzzle8> solution = resolver.solution(); 
		    while(solution.hasNext())
		       System.out.println(solution.next());
		    if (!resolver.isSolvable()) System.out.println("Não tem solução possível");
		    else System.out.println("Número mínimo de movimentos = " + resolver.moves());
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}