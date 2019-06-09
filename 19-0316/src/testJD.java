/**
 * @author week
 * @Title: testJD
 * @ProjectName 19-0316
 * @Description: TODO
 * @date 2019/4/1419:44
 */

import java.util.*;

public class testJD {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            strings[i] = s;
        }
        String tar = scanner.nextLine();
        StringBuilder sb = new StringBuilder(tar);
        Arrays.sort(strings, (s1, s2) -> {
            return s1.length() - s2.length();
        });
        int time = 0;
        for (String s : strings) {
            int start = sb.indexOf(s);
            for (; start != -1; ) {
                sb.delete(start, start + s.length());
                sb.insert(start, ',');
                time++;
                start = sb.indexOf(s);
            }
        }
        System.out.println(time);
    }
}
