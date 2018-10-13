# https://app.codesignal.com/challenge/oZruRcHWDW5CzCFSN

int quantumLabCorrection(std::vector<std::vector<int>> friends, int first, int k) {
    int n = friends.size();
    
    queue<int> q;
    vector<int> v;
    vector<bool> o (n, false);
    
    v.push_back(first);
    q.push(first);
        
    while(!q.empty()) {
        if(v.size() > k) {
            break;
        }
        
        int f = q.front();
        q.pop();  // remove the value
        o[f] = false;   // unblock
        
        for(int i=0; i < friends[f].size(); i++) {
            if(friends[f][i] && !o[i]) {
                q.push(i);
                v.push_back(i);
                o[i] = true;    // block
            }
        } 
    }
    
    // ---
    
    if(k < v.size()) {
        return v[k];
    } else {
        return -1;
    }
}
