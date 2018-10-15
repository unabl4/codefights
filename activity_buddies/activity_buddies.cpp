# https://app.codesignal.com/challenge/N3kuMLSbc8jChix8K

bool isCorrectAllocation(vector<int> booths) {
    for(auto b: booths) {
        if(b < 2) {
            return false;
        }
    }
    
    return true;
}

std::vector<int> activityBuddies(std::vector<std::vector<int>> ratings) {
    int l = ratings.size();
    int w = ratings[0].size();
    vector<int> booths(w, 0);
    map<int, int> assignments;
    map<int, int> maxScores;
    
    // step 1: naive distribution
    for(int i=0; i < l; i++) {
        vector<int> row = ratings[i];
        int boothId = max_element(row.begin(), row.end()) - row.begin();
        
        booths[boothId]++;
        assignments[i] = boothId;       // assign student 'i' to booth 'boothId'
        maxScores[i] = row[boothId];    // write down the max score of the student to the selected booth
    }
    
//     for (auto b : booths)
//         cout << b << ' ';
    
//     cout << endl;
    
//     for (const auto &p : assignments) {
//         std::cout << "assignments[" << p.first << "] = " << p.second << endl;
//     }
    
//     cout << endl;
    
    // step 2: re-distribute to keep len(booth[i]) > 2
    int p = 0;
    set<int> movedAround;   // students    
    while(!isCorrectAllocation(booths)) {
        int i = p % w;
        if(booths[i] < 2) {
            // find a student with MIN dist between the assigned booth and the current booth, where assigned booth != current booth
            int currentDistance;
            int minDistance = -1;
            int transferStudentId = - 1;
            // otherScoreGiven?
            for(int s=0; s < l; s++) {
                if(assignments[s] == i) {
                    continue;   // ignore, because it is the same booth
                }
                
                if(movedAround.count(s)) {
                    continue;   // this student has already been moved    
                }   
                
                // if(booths[assignments[s]] == 2) {
                //     continue;   // cannot take from the booth that has exactly 2 students
                // }
                
                vector<int> row = ratings[s];   // get students scores
                currentDistance = abs(maxScores[s]-row[i]);
                if(minDistance == -1 || currentDistance < minDistance) {
                    minDistance = currentDistance;
                    transferStudentId = s;
                }
            }
            
            // ---
            
            // cout << "we need to transfer " << transferStudentId << " from " << assignments[transferStudentId] << " to " << i << endl;
            booths[assignments[transferStudentId]]--;
            booths[i]++;
            assignments[transferStudentId] = i; // re-assign
            movedAround.insert(transferStudentId);
        }
        
        p++;
    }   // end while
    
//     for (const auto &p : assignments) {
//         std::cout << "assignments[" << p.first << "] = " << p.second << endl;
//     }
    
//     cout << endl;
    
    return booths;
}
