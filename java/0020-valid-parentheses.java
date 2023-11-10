class Solution {
    public boolean isValid(String s) {
        Stack<Character> bracket = new Stack<>();
        
        for (char c : s.toCharArray()){
             if (c == '(' || c == '[' || c == '{'  ){ 
                 bracket.push(c);
             }
            boolean isRightBracket = (c == ']' || c == '}' || c == ')');
             if (isRightBracket && !bracket.isEmpty() ){  
                 if (bracket.peek() == '[' && c != ']'){
                     return false;
                 } else if (bracket.peek() == '(' && c != ')'){
                     return false;
                 } else if (bracket.peek() == '{' && c != '}') {
                     return false;
                 }else{
                     bracket.pop();
                 }
             }else if (isRightBracket && bracket.isEmpty()) {
                 return false;
             }
        }
        if (bracket.isEmpty()){
            return true;
        }
        return false;
    }
}