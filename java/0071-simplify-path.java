class Solution {
    public String simplifyPath(String path) {
        List<String> parts = Arrays.asList(path.split("/"));
        Deque<String> stack = new ArrayDeque<>();
        
        for(String part : parts){
            if (part.isEmpty() || part.equals(".")) continue;
            else if (part.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }
        
        // Read out the stack in reverse order
        String out = "";
        while(stack.size() > 0){
            out += "/" + stack.removeLast();
        }
        if(out == "") return "/";
        return out;
        
    }
}


/*
If we see multiple / or we see single . just remove those

Then what we really need to solve for is do we nee a .. or are we just back where we started

/../

/var/log/../
/var/

.. . ... 



if . ignore
if .. then pop the stack

Stack Top
log
var
Stack Bottom

//

put the stack back together 

*/