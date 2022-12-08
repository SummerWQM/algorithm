
// 子集，多集合，迭代算法。

    public static void main(String[] avg) {

        List<Integer> arr1 = Arrays.asList(1);
        List<Integer> arr11 = Arrays.asList(8);

        List<Integer> arr2 = Arrays.asList(4);

        List<Integer> arr3 = Arrays.asList(6);

        List<Integer> arr4 = Arrays.asList(11);

        List<Integer> arr44 = Arrays.asList(13);

        List<List<Integer>> comb1 = Arrays.asList(arr1, arr11);
        List<List<Integer>> comb2 = Arrays.asList(arr2, arr3);

        List<List<Integer>> comb3 = Arrays.asList(arr4, arr44);

        List<List<List<Integer>>> combArr = Arrays.asList(comb1, comb2, comb3);
        List<List<Integer>> com = combination(combArr);

        System.out.println(Arrays.toString(com.toArray()));
    }

    public static List<List<Integer>> combination(List<List<List<Integer>>> combinationArr) {
        //活动数量
        int size = combinationArr.size();
        int[] index = new int[size];
        List<List<Integer>> re = new ArrayList<>();
        do {
            List<Integer> discountRuleList = Lists.newArrayList();
            for (int i = 0; i < size; i++) {
                List<Integer> list = combinationArr.get(i).get(index[i]);
                discountRuleList.addAll(list);
            }
            
            re.add(discountRuleList);

        } while (changeIndex(index, combinationArr));

        return re;
    }

    public static boolean changeIndex(int[] index, List<List<List<Integer>>> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (index[i] == list.get(i).size() - 1) {
                index[i] = 0;
            } else {
                index[i]++;
                return true;
            }
        }
        return false;
    }
