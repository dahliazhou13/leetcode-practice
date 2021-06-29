import javax.xml.validation.ValidatorHandler;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

class validIPAddress {

    // Validate
    // import java.net.*;
    // class Solution {
    //   public String validIPAddress(String IP) {
    //     try {
    //       return (InetAddress.getByName(IP) instanceof Inet6Address) ? "IPv6": "IPv4";
    //     } catch(Exception e) {}
    //     return "Neither";
    //   }
    // }


   // Regex
// import java.util.regex.Pattern;

// class Solution {
//     String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
//     Pattern pattenIPv4 = Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

//     String chunkIPv6 = "([0-9a-fA-F]{1,4})";
//     Pattern pattenIPv6 = Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");

//     public String validIPAddress(String IP) {
//         if (pattenIPv4.matcher(IP).matches())
//             return "IPv4";
//         return (pattenIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
//     }

// }

    public String validIPAddress(String IP) {
        String[] splits = IP.split("\\.");
        if (splits.length == 4) {
            // 4 case
            // check value
            for (int i = 0; i < 4; i++) {
                if (!splits[i].matches("-?\\d+"))
                    return "Neither";
                if (splits[i].length() > 1 && splits[i].charAt(0) == '0')
                    return "Neither";
                try {
                    int value = Integer.parseInt(splits[i]);
                    if (value < 0 || value > 255)
                        return "Neither";
                } catch (Exception e) {
                    return "Neither";
                }

            }
            if (IP.charAt(IP.length() - 1) != '.')
                return "IPv4";

        } /// [0-9a-f]+/i
        splits = IP.split("\\:");
        if (splits.length == 8) {
            for (int i = 0; i < 8; i++) {
                if (!splits[i].matches("-?[0-9a-fA-F]+") || splits[i].length() > 4)
                    return "Neither";

            }
            if (IP.charAt(IP.length() - 1) != ':')
                return "IPv6";
        }
        return "Neither";
    }
}
