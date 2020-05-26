// https://app.codesignal.com/challenge/m9h5ZGE4xKnvDwLcb

int arrayMaxConsecutiveSum2(int[] nums) {
    int currentSum = 0;
    int bestSum = Integer.MIN_VALUE;

    for (int element : nums) {
        currentSum = Math.max(element, currentSum + element);
        bestSum = Math.max(bestSum, currentSum);
    }

    return bestSum;
}
