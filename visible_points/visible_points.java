// https://app.codesignal.com/challenge/yqYypnpwvMowXfueS

int visiblePoints(int[][] points) {
    int L = points.length;
    List<Double> m = new ArrayList<>();
    
    for(int[] p: points) {
        double angle = pointAngle(p[0], p[1]);
        m.add(angle);
    }
    
    Collections.sort(m);    // O(N*log(N))
    // System.out.println(m); 
    
    int w=1; // at bare minimum we see at least one (1) point always
    for(int i=0,j=0; i < L-1; i++) {
        double startAngle = m.get(i);   // current angle
        double endAngle = startAngle + (Math.PI/4);
        
        while(j+1 < L && m.get(j+1) <= endAngle) j++;
        // i=0
        // j=5
        
//         System.out.print("STOP: ");
//         System.out.println(j);
//         System.out.println();
        
//         System.out.print("MAX: ");
//         System.out.print(w);
//         System.out.print(" vs ");
//         System.out.println(j-i+1);
        
        w = Math.max(w,j-i+1);
    }
    
    // System.out.println(w);
    
    return w;
}

// ---

// absolute angle (in radians) value relative to Oy (vertical)
double pointAngle(double x, double y) {  
    // we are guaranteed not to have (0,0) points
    double deg = (y == 0) ? (x > 0 ? Math.PI/2 : Math.PI) : Math.abs(Math.atan(x/y));    // radians
    if(x < 0 && y < 0) {
        // 3rd Q
        deg += Math.PI; // + 180deg
    } else if(x > 0 && y < 0) {
        // 2nd Q
        deg += Math.PI/2.0;   // +90 deg
    } else if(x < 0 && y > 0) {
        // 4th Q
        deg += 3*Math.PI/2.0; // +270 deg
    }
    
    // System.out.print("X: ");
    // System.out.print(x);
    // System.out.print(", Y: ");
    // System.out.print(y);
    // System.out.print(", Ang: ");
    // System.out.println(deg);
    
    // ---
    
    return deg;
}
