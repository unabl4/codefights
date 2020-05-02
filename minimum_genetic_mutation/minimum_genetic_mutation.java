// https://app.codesignal.com/challenge/H2ow66hvFsZ9yT9Tp

class Entry {
    String name;
    Integer distance;
}

int minimumGeneticMutation(String startStr, String endStr, String[] bank) {
    Map<String, List<String>> G = new HashMap<>();
    // process bank entires
    int B = bank.length;
    if(B <= 0) return -1;

    for(int i=0; i < B; i++) {
        for(int j=i+1; j < B; j++) {
            int d = geneDistance(bank[i], bank[j]);
            if(d != 1) continue;    // there must be a single-char mutation   

            if(!G.containsKey(bank[i])) G.put(bank[i], new ArrayList<>());
            if(!G.containsKey(bank[j])) G.put(bank[j], new ArrayList<>());

            G.get(bank[i]).add(bank[j]);
            G.get(bank[j]).add(bank[i]);
        }
    }

    for(int i=0; i < B; i++) {
        int d = geneDistance(startStr, bank[i]);
        if(d != 1) continue;

        if(!G.containsKey(startStr)) G.put(startStr, new ArrayList<>());
        if(!G.containsKey(bank[i])) G.put(bank[i], new ArrayList<>());

        G.get(startStr).add(bank[i]);
        G.get(bank[i]).add(startStr);
    }

    System.out.println(G);

    // traverse
    Set<String> V = new HashSet<>();    // visisted
    Queue<Entry> Q = new LinkedList<>();

    Entry e = new Entry();
    e.name = startStr;
    e.distance = 0;
    Q.add(e);

    while(!Q.isEmpty()) {
        Entry currentNodeEntry = Q.poll();  // pop
        String nodeName  = currentNodeEntry.name;
        Integer nodeDist = currentNodeEntry.distance;
        V.add(nodeName); // mark as visited

        if(nodeName.equals(endStr)) {
            return nodeDist;
        }

        for(String n: G.get(nodeName)) { // neighbour
            if(V.contains(n)) continue; // already visited? -> skip

            Entry eNew = new Entry();
            eNew.name = n;
            eNew.distance = nodeDist+1;
            Q.add(eNew);   // increment the distance
        }
    }

    return -1;  // no path exists
}

int geneDistance(String a, String b) {
    int c = 0;
    for(int i=0; i < 8; i++) {
        if(a.charAt(i) != b.charAt(i)) c++;
    }

    return c;
}

