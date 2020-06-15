// https://app.codesignal.com/challenge/MKiw354rr2YAnDdgW

int treeLevelSum(String T, int k) {
    int a = 0;
    int b = T.length()-1;
    
    int s = 0;  // end sum
    
    Queue<Integer[]> q = new LinkedList<>();    // parse queue
    q.add(new Integer[] { a,b,0 });   // start
    
    while(true) {
        // step 1: parse the number
        Integer[] y = q.poll();
        
        // System.out.println("---");
        
        if(y == null) break;
        if(y[2] > k) break; // early term
        
        // System.out.println(y[0]);
        // System.out.println(y[1]);
        // System.out.println(y[2]);
        
        int l = y[0]+1;
        
        if(y[1]-y[0] <= 1) continue;    // "()"
        
        StringBuilder numStringBuilder = new StringBuilder();   // number
        while(T.charAt(l) != '(') {   // until the first opening
            numStringBuilder.append(T.charAt(l));
            l++;
        }
        
        int leftBeginning = l;
        
        if(y[2] == k && numStringBuilder.length() > 0) {
            // number is required
            s += Integer.parseInt(numStringBuilder.toString());
        }
        
        // step 2:
        // get left subtree
        
        l+=1;
        int PB = 1;
        
        while(true) {            
            if(T.charAt(l) == '(')  {
                PB += 1;
            } else if(T.charAt(l) == ')') {
                PB -= 1;
            }   // else - ignore completely
            
            if(PB == 0) break;
            
            l++;    // move on
        }
        
        q.add(new Integer[] { leftBeginning,l,y[2]+1 });
        
        // step 3:
        // get right subtree
        l += 1;
        int rightBeginning = l;
        
        PB = 1; // reset
        while(true) {
            if(T.charAt(l) == '(')  {
                PB += 1;
            } else if(T.charAt(l) == ')') {
                PB -= 1;
            }   // else - ignore completely
            
            if(PB == 0) break;
            
            l++;    // move on
        }
        
        q.add(new Integer[] { rightBeginning,l-1,y[2]+1 });
    }
    
    return s;
}
