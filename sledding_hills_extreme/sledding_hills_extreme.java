# https://app.codesignal.com/challenge/LxnQG73ppitjERCdn

int sleddingHillsExtreme(int[] enjoyability, int maxRuns) {
    int m = 1000000007;
    PriorityQueue<Integer> nums = new PriorityQueue<>(Collections.reverseOrder());
    
    // enqueue part
    for (int num : enjoyability) {
        nums.add(num);
    }
    
    // dequeue part
    int maxEnjoyment = 0;
    while(maxRuns > 0) {
        int maxValue = nums.remove();
        if(maxValue <= 0) { break; }
        maxEnjoyment = (maxEnjoyment+maxValue) % m;
        nums.add(maxValue-1);    // decrement the enjoyability
        maxRuns--;
    }
    
    return maxEnjoyment;
}
