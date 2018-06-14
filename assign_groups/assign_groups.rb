# https://codefights.com/challenge/ogcRDybjWMDEbph8W

def assignGroups(timeEstimates, groupSize)
    n = timeEstimates.size
    times = timeEstimates.sort.reverse
    0.step(n-1, groupSize).sum { |x| times[x] }
end
