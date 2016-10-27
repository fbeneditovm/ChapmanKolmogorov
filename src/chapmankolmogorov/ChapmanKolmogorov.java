/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapmankolmogorov;
import java.math.BigDecimal;

/**
 * Used to calculate a specific probability
 * by applying the ChapmanKolmogorov formula
 * @author fbeneditovm
 */
public class ChapmanKolmogorov {
    
    BigDecimal[][] matrix;
    
    
    /**
     * Constructor
     * @param matrix the transition matrix
     */
    public ChapmanKolmogorov(BigDecimal[][] matrix){
        this.matrix = matrix;
    }
    
    /**
     * Calculates a specific probability (Pij)^n
     * @param i the line
     * @param j the column
     * @param n the number of iterations
     * @return (Pij)^n
     */
    public BigDecimal calculateP(int i, int j, int n){
        
        if(n==1)
            return matrix[i][j];  
        
        BigDecimal P = new BigDecimal("0");
        
        for(int k=0; k<matrix.length; k++){
            P = P.add(matrix[i][k].multiply(calculateP(k, j, n-1)));
        }
        return P;
    }
}
