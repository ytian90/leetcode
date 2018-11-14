package mj.linkedin;
/*
Question:
看括号是否是闭合的
)()()()    ---->   true
(+1^$#)(#$)  ----> true
)(   ----->false
(()#%33  ----->false

 */
public class ValidParenthese_Modified {

    public static boolean isValid(String input) {
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid(")()()()"));
        System.out.println(isValid("(+1^$#)(#$)"));
        System.out.println(isValid(")("));
        System.out.println(isValid("(()#%33"));
    }
}
