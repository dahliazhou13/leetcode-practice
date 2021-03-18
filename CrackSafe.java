/**
 * Description:
 * There is a box protected by a password. The password is a sequence of n digits where each
 *  digit can be one of the first k digits 0, 1, ..., k-1.
 * While entering a password, the last n digits entered will automatically be matched 
 * against the correct password.
 * 
 * For example, assuming the correct password is "345", if you type "012345", the box will 
 * open because the correct password matches the suffix of the entered password.
 * Return any password of minimum length that is guaranteed to open the box at some point 
 * of entering it.


 */

public class CrackSafe{
    Set<String> seen;
    StringBuilder ans;

    public String crackSafe(int n, int k) {
        if (n == 1 && k == 1) return "0";
        seen = new HashSet();
        ans = new StringBuilder();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n-1; ++i)
            sb.append("0");
        String start = sb.toString();

        dfs(start, k);
        ans.append(start);
        return new String(ans);
    }

    public void dfs(String node, int k) {
        for (int x = 0; x < k; ++x) {
            String nei = node + x;
            if (!seen.contains(nei)) {
                seen.add(nei);
                dfs(nei.substring(1), k);
                ans.append(x);
            }
        }
    }
}