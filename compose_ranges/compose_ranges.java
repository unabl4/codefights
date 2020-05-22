// https://app.codesignal.com/challenge/AqMPGdc8r9ry4qykm

ArrayList<String> composeRanges(int[] nums) {
    int L = nums.length;
    ArrayList<String> R = new ArrayList<>();

    for(int i=0; i < L; i++) {
        int j = i;
        while(j+1 < L && nums[j+1]-nums[j] == 1) j++;   // find the ending of the range

        StringBuilder sb = new StringBuilder(Integer.toString(nums[i]));
        if(j != i) sb.append("->" + Integer.toString(nums[j]));

        R.add(sb.toString());
        i = j;
    }

    return R;
}

