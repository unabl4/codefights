# https://app.codesignal.com/challenge/fPbGBrBHieQD532uh

import heapq as hq
# optimized
def modeScores(scores):
    n = len(scores)
    z = [0] * n
    f = {} # freq (global)
    h = [] # heap
    for i in range(n):
        s = scores[i]
        f[s] = f.get(s,0)+1 # freq counter
        hq.heappush(h,(-f[s],-s)) # min -> max heap conversion (negation)
        _, max_score = h[0] # get the max (negated min) value
        z[i] = -max_score
    return z
                


# did not work :)
# def modeScoresNaive(scores):
#     n = len(scores)
#     z = [0] * n
#     f = {} # freq (global)
#     for i in range(n):
#         s = scores[i]
#         f[s] = f.get(s,0)+1 # freq counter
        
#         max_score = max_freq = None
#         for k,v in f.items():
#             if max_freq is None or (v > max_freq or (v == max_freq and k > max_score)):
#                 max_score = k
#                 max_freq  = v
        
#         z[i] = max_score
#     return z
