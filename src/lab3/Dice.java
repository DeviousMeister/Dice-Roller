package lab3;

import support.cse131.ArgsProcessor;

public class Dice {
    public static void main(String[] args) {
        ArgsProcessor ap = new ArgsProcessor(args);
        int numOfDice = ap.nextInt("How many dice will be used?");
        int timesThrown = ap.nextInt("How many times will they be thrown?");
        int[][] diceTable = new int[timesThrown][numOfDice];
        int[] sumsOfDice = new int[timesThrown];
        int[] possibleSumCounter = new int[(numOfDice*6)+1];
        int yahtzee = 0;
        for (int i = 0; i < timesThrown; ++i) {
            System.out.print("Throw " + (i + 1) + ":" + "  ");
            for (int j = 0; j < numOfDice; ++j) {
                int diceNumber = (int) ((Math.random() * 6) + 1);
                diceTable[i][j] = diceNumber;
                System.out.print(diceTable[i][j] + "  ");
                sumsOfDice[i] = sumsOfDice[i] + diceNumber;
            }
            possibleSumCounter[sumsOfDice[i]] = possibleSumCounter[sumsOfDice[i]] + 1;
            System.out.print("= " + sumsOfDice[i]);
            System.out.println();
        }
        for (int i = 0; i < timesThrown; ++i) {
            int pairDice = 0;
            for (int j = 0; j < (numOfDice - 1); ++j) {
                if (diceTable[i][j] == diceTable[i][j + 1]) {
                    pairDice = pairDice + 1;
                }
            }
            if (pairDice == (numOfDice - 1)) {
                yahtzee = yahtzee + 1;
            }
        }
        double yahtzeePercent = ((double) yahtzee / (double) timesThrown) * 1000;
        double yahtzeePercentRound = Math.round(yahtzeePercent) / 10.0;
        System.out.println("Of the " + timesThrown + " throws, " + yahtzee + " showed the same value on all of the dice which is " + yahtzeePercentRound + "%" + " of all throws. ");
        for (int i = numOfDice; i <= (numOfDice*6); i++){
            double percentOfSums = ((double) possibleSumCounter[i]/(double) timesThrown) * 1000;
            double percentOfSumsRounded = Math.round(percentOfSums)/10.0;
            System.out.println("The sum " + i + " appeared " + possibleSumCounter[i]  + " times, which is " + percentOfSumsRounded + "%" + " of all throws.");
        }

    }
}
