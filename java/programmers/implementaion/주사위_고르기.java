import java.util.*;

class Solution {
    private int N;
    private int maxWins = -1;
    private List<Integer> answerDice;
    
    
    public int[] solution(int[][] dice) {
        N = dice.length;
        answerDice = new ArrayList<>();
        boolean[] visited = new boolean[N];
        
        combineDice(0, 0, visited, dice);
        
        return answerDice.stream().mapToInt(i -> i + 1).toArray();
    }

    private void combineDice(int idx, int count, boolean[] visited, int[][] dice) {
        if (count == N / 2) {
            calculateWinningCount(visited, dice);
            return;
        }

        for (int i = idx; i < N; i++) {
            visited[i] = true;
            combineDice(i + 1, count + 1, visited, dice);
            visited[i] = false;
        }
    }

    private void calculateWinningCount(boolean[] visited, int[][] dice) {
        List<Integer> diceA = new ArrayList<>();
        List<Integer> diceB = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                diceA.add(i);
            } 
            else {
                diceB.add(i);
            }
        }

        List<Integer> sumsA = new ArrayList<>();
        List<Integer> sumsB = new ArrayList<>();
        
        generateSums(0, 0, diceA, dice, sumsA);
        generateSums(0, 0, diceB, dice, sumsB);

        Collections.sort(sumsA);
        Collections.sort(sumsB);

        int currentWins = 0;
        
        int sizeB = sumsB.size();
        
        for (int scoreA : sumsA) {
            int count = lowerBound(sumsB, scoreA);
            currentWins += count;
        }

        if (currentWins > maxWins) {
            maxWins = currentWins;
            answerDice = new ArrayList<>(diceA);
            Collections.sort(answerDice);
        }
    }

    private void generateSums(int depth, int currentSum, List<Integer> myDiceIndices, int[][] dice, List<Integer> resultSums) {
        if (depth == N / 2) {
            resultSums.add(currentSum);
            return;
        }

        int diceIndex = myDiceIndices.get(depth);

        for (int val : dice[diceIndex]) {
            generateSums(depth + 1, currentSum + val, myDiceIndices, dice, resultSums);
        }
    }

    private int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
