public class intToRoman {
    public String intToRoman(int num) {
        // /*
        // I 1
        // V 5
        // X 10
        // L 50
        // C 100
        // D 500
        // M 1000
        // */
        // My solution:
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        StringBuilder sb = new StringBuilder("");
        while (num > 0) {
            for (int i = 0; i < values.length; i++) {
                if (values[i] <= num) {
                    num -= values[i];
                    sb.append(map.get(values[i]));
                    break;
                }
            }
        }
        return sb.toString();
    }
    // Leetcode's solution
    // private static final String[] thousands = { "", "M", "MM", "MMM" };
    // private static final String[] hundreds = { "", "C", "CC", "CCC", "CD", "D",
    // "DC", "DCC", "DCCC", "CM" };
    // private static final String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX",
    // "LXX", "LXXX", "XC" };
    // private static final String[] ones = { "", "I", "II", "III", "IV", "V", "VI",
    // "VII", "VIII", "IX" };

    // public String intToRoman(int num) {
    // return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 /
    // 10] + ones[num % 10];
    // }
}
