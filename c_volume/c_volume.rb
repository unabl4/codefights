# https://codefights.com/challenge/5KoJvjuBKSeBwWe54
# solution: the main idea is to subtract the area of the triangle (second term)
# from the area of the sector (first term)

def cVolume r,l,m
  return 0 if r == 0
  z = r-m
  l*(r*r * Math.acos(z/r)-z*(2*r*m - m*m)**0.5)
end
