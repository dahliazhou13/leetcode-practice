class numberToWords {
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        int billion = num / 1000000000;
        int million = (num - billion * 1000000000) / 1000000;
        int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
        int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;

        String result = "";
        if (billion != 0)
            result = getThree(billion) + " Billion";
        if (million != 0) {
            if (!result.isEmpty())
                result += " ";
            result += getThree(million) + " Million";
        }
        if (thousand != 0) {
            if (!result.isEmpty())
                result += " ";
            result += getThree(thousand) + " Thousand";
        }
        if (rest != 0) {
            if (!result.isEmpty())
                result += " ";
            result += getThree(rest);
        }
        return result;
    }

    private String getThree(int num) {

        String[] digits = { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" };
        String[] ten = { "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
                "Nineteen", "Twenty" };
        String[] tenth = { "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

        int hundreds = num / 100;
        int rem = num % 100;
        StringBuilder sb = new StringBuilder();
        if (hundreds != 0) {
            sb.append(digits[hundreds - 1]);
            sb.append(" Hundred");
            if (rem != 0)
                sb.append(" ");
        }
        if (rem == 0)
            sb.append("");
        else if (rem <= 10)
            sb.append(digits[rem - 1]);
        else if (rem <= 20)
            sb.append(ten[rem - 10 - 1]);
        else {
            sb.append(tenth[rem / 10 - 2]);
            if (rem % 10 != 0) {
                sb.append(" ");
                sb.append(digits[rem % 10 - 1]);
            }

        }
        return sb.toString();
    }
}
