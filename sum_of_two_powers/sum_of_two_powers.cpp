# https://app.codesignal.com/challenge/TnnSSXh97pX5ypbaJ

bool isRoot(int n, int k) {
    int b = round(pow(n, 1./k));
    return pow(b,k) == n;
}

vector<vector<int>> sumOfTwoPowers(int n, int k) {
    vector<vector<int>> res;
    int maxBase = round(pow(n, 1./k));
    
    for(int i=maxBase; pow(i,k) >= n/2; i--) {
        int p = pow(i,k);
        int r = n-p;
        if(isRoot(r,k)) {
            vector<int> v = { r, p };
            res.push_back(v);
        }
    }
    
    return res;
}
