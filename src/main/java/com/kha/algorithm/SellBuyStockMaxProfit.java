package main.java.com.kha.algorithm;

import java.util.ArrayList;

/**
 * Created by Mohammad.Ansari1 on 28-09-2017.
 */
public class SellBuyStockMaxProfit {
    public static void maxProfit(int[] input){
        int indexLowestPriceSoFar = 0;
        int indexMaxProfitBuy = 0;
        int indexMaxProfitSell = 0;
        for(int i=0;i<input.length;i++){
            if(input[indexMaxProfitSell]-input[indexMaxProfitBuy] < input[i]-input[indexLowestPriceSoFar]){
                indexMaxProfitBuy = indexLowestPriceSoFar;
                indexMaxProfitSell = i;
            }
            if(input[indexLowestPriceSoFar] > input[i] && i<input.length-1){
                indexLowestPriceSoFar = i;
            }
        }
        System.out.println("startI: " + indexMaxProfitBuy+", endI: "+ indexMaxProfitSell+", maxProfit:"+ (input[indexMaxProfitSell]-input[indexMaxProfitBuy]));
    }


    public static void main(String[] args) {
        int[] input = new int[]{5,10,15,20,19,30};
        maxProfit(input);

    }
}
