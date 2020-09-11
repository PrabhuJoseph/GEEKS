package algorithms;

import java.util.LinkedList;

public class Scorer {

    private static int getTotalScore(String[] blocks) {
        LinkedList<Integer> prevScores = new LinkedList<>();
        int totalScore = 0;
        for (String curBlock : blocks) {
            int curScore = 0;
            if (curBlock.equals("Z")) {
                if (prevScores.size() > 0) {
                    curScore = - (prevScores.removeLast());
                }
            } else if (curBlock.equals("X")) {
                if (prevScores.size() > 0) {
                    curScore = prevScores.getLast() * 2;
                }
                prevScores.addLast(curScore);
            } else if (curBlock.equals("+")) {
                int prevA=0, prevB=0;
                int size = prevScores.size();
                if (size > 0) {
                    prevA = prevScores.getLast();
                }
                if (size > 1) {
                    prevB = prevScores.get(size - 2);
                }
                curScore = prevA + prevB;
                prevScores.addLast(curScore);
            } else {
                curScore = Integer.parseInt(curBlock);
                prevScores.addLast(curScore);
            }
            totalScore += curScore;
        }
        return totalScore;
    }

    public static void main(String[] args) {
        String[] blocks = {"5","-2", "4", "Z", "X", "9", "+", "+"};
        int result = getTotalScore(blocks);
        System.out.println("TOTAL SCORE: " + result);
    }
}
