# https://app.codesignal.com/challenge/q5WHJQTyiL4XERsBL

def symmetricalMatrix(n,m):
    for i in range(n):
        for j in range(n):
            if m[i][j] != m[j][i]:
                return False
    
    return True
