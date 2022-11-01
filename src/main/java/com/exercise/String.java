
    public static void main(String[] avg) {

        String s = "3 + 5 * 2";

        char preSign = '+';
        int num = 0, index = 0;
        Stack<Integer> stack = new Stack<>();
        while (index < s.length()) {

            if (Character.isDigit(s.charAt(index))) {
                num = num * 10 + (s.charAt(index) - '0');
            }
            if (!Character.isDigit(s.charAt(index)) && s.charAt(index) != ' ' || index == s.length() - 1) {

                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(index);
                num = 0;

            }
            index++;

        }

        int re = 0;
        while(!stack.isEmpty()) {
            re += stack.pop();
        }
        System.out.println(re);

    }
