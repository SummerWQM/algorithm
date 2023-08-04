//       int[] arr = new int[128];
//        String s = "abccbefgabc";
//        int cnt = 0, res = 0;
//        int r = 0, l = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (++arr[s.charAt(i)] == 1) cnt++;
//
//            while (l < r && cnt < r - l + 1) {
//                if (--arr[s.charAt(l)] == 0) cnt--;
//                l++;
//            }
//
//            res = Math.max(cnt, res);
//            r++;
//        }
//        System.out.println(res);
//
//
//
//    public static void main(String[] args) {
//        String s = "abcca";
//
//        int n = s.length();
//
//        Map<Character, Integer> map = new HashMap<>();
//        int res = 0;
//        for (int start = 0, end = 0; end < n; end++) {
//
//            if (map.containsKey(s.charAt(end))) {
//
//                // a \b  c  c a , 定位左边界的位置。
//                start = Math.max(map.get(s.charAt(end)) + 1, start);
//            }
//
//            res = Math.max(res, end - start + 1);
//
//            map.put(s.charAt(end), end);
//        }
//        System.out.println(res);
//    }
//
//
