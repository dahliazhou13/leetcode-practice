class divide {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        int negative = 2;

        if (dividend > 0) {
            negative--;
            dividend = -dividend;
        }

        if (divisor > 0) {
            negative--;
            divisor = -divisor;
        }

        int quotient = 0;
        while (divisor >= dividend) {
            int power = -1;
            int val = divisor;
            while (val >= -1073741824 && val + val >= dividend) {
                val += val;
                power += power;
            }

            quotient += power;
            dividend -= val;
        }

        return negative == 1 ? quotient : -quotient;
    }
}
