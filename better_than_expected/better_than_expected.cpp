# https://app.codesignal.com/challenge/yX8h8gm3QYrnqPNEb

class frac{
  private:
    int n;  // numberator
    int d;  // denumerator
    
  public:
    // unity
    frac() {
      n = 0;
      d = 1;
    }
    frac(int a, int b) {
      n = a;
      d = b;
    }
    
    // ---
    
    // override
    friend bool operator >(const frac &lhs, const frac &rhs) {
      // common denominator -> then check numerators
      int common_d = lhs.d * rhs.d;
      int new_n1 = common_d / lhs.d * lhs.n;
      int new_n2 = common_d / rhs.d * rhs.n;
      return new_n1 > new_n2;
    }
    
    friend frac operator +=(frac &lhs, frac &rhs) {
      // common denominator
      int common_d = lhs.d * rhs.d;
      int new_n1 = common_d / lhs.d * lhs.n;
      int new_n2 = common_d / rhs.d * rhs.n;
      int new_n = new_n1 + new_n2;
      lhs.n = new_n;
      lhs.d = common_d;
      return lhs;
    }
    
    friend frac operator *=(frac &lhs, frac &rhs) {
      int a = lhs.n * rhs.n;  // new numerator
      int b = lhs.d * rhs.d;  // new denominator
      lhs.n = a;
      lhs.d = b;
      return lhs;
    }
};

bool betterThanExpected(vector <int> numerators, vector <int> denominators) {
  int cnt = 0;
  frac ans, half(1, 2);
  for (size_t i = 0; i < numerators.size(); i++) {
    frac cur(numerators[i], denominators[i]);
    if (cur > half) {
      ans += cur;
      cnt++;
    }
  }
  frac av(1, cnt), expectedAverage(3, 4);
  ans *= av;
  return ans > expectedAverage;
}

