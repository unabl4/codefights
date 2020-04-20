// https://app.codesignal.com/challenge/bZo3n8ccnZwYFu8Pr


int H(int a, int b) {
    return b*b + a;
}

boolean pairOfShoes(int[][] shoes) {
    HashMap<Integer, Integer> h = new HashMap<>();

    for(int[] shoe: shoes) {
        int t = shoe[0];    // type
        int s = shoe[1];    // size

        int z = (t+1)%2;   // counter-party (right -> left, left -> right)

        // hashes
        int a = H(t,s);
        int b = H(z,s); // cp

        if(h.containsKey(b)) {
            h.put(b, h.get(b)-1);
        } else {
            h.put(a, h.getOrDefault(a,0)+1);
        }
    }

    for (Map.Entry<Integer, Integer> e : h.entrySet()) {
        if(e.getValue() != 0) return false;
    }

    return true;
}

