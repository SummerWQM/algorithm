 public static List<List<Integer>> loop(TreeNode k) {

        List<List<Integer>> ans = new ArrayList<>();

        if (k == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(k);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> item = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    item.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }

            }
            ans.add(item);
        }
        return ans;
    }


    public static TreeNode build(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;

    }


    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int value) {
            val = value;
        }
    }


    public static void main(String[] avg) {

        TreeNode root = build(new int[]{1, 2, 3, 4}, 0, 3);

        List<List<Integer>> re = loop(root);

        System.out.println(Arrays.toString(re.toArray()));
    }
