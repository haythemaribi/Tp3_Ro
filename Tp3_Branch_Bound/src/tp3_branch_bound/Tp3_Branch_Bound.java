/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_branch_bound;


public class Tp3_Branch_Bound {

  int Calcule_solution_optimale(int[] poids, int[] c, int n, int poids_total) {
    if (n <= 0 || poids_total <= 0) {
        return 0;
    }

    int[][] m = new int[n + 1][poids_total + 1];
    for (int j = 0; j <= poids_total; j++) {
        m[0][j] = 0;
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= poids_total; j++) { 
            if (poids[i - 1] > j) {
                m[i][j] = m[i - 1][j];
            } else {
                m[i][j] = Math.max(
                  m[i - 1][j], 
                  m[i - 1][j - poids[i - 1]] + c[i - 1]);
            }
        }
    }
    return m[n][poids_total];
}
    public static void main(String[] args) {
       Tp3_Branch_Bound tp3=new Tp3_Branch_Bound();
       int []podis={3,7,9,6,3,5};
       int []c={8,16,20,12,6,9};
      int rsualt= tp3.Calcule_solution_optimale(podis, c, 6, 17);
        System.out.println("Les Souliton optimale Z = "+rsualt);
    }
    
}
