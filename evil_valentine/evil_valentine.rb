# https://codefights.com/challenge/S7D6TQsx8bvhdqyau

# Solution: the main idea is to find the angle between the tower and horizon.
# Knowing the angle and the radius of the sphere will allow to calculate the
# length of the arc or the the "distance" from the tower to the flower.
# Basic trigonometry is enough.

def evilValentine h,r
  (r * Math.acos(r/(r+h))).round(4)
end
