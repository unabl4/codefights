// https://app.codesignal.com/challenge/x7heKGPZsaR3oKrc3

boolean containsCloseNums(int[] nums, int k) {
    HashMap<Integer, Integer> h = new HashMap<>();  // int -> index map
    
    for(int i=0; i < nums.length; i++) {
        if(!h.containsKey(nums[i])) {
            h.put(nums[i],i);
        } else {
            if(i-h.get(nums[i]) <= k) {
                return true;
            } else {
                h.put(nums[i],i);   // update
            }
        }
    }
    
    return false;
}

