    /* package Stack;
    */
    public class Stack_parentheses {

        public class Stack{

            int size;
            char[] arr;
            int top;

            public Stack(int size){

                this.size = size;
                this.arr = new char[size];
                this.top = -1;
            }

            public void push(char data){

                
                if(this.top == size-1){

                    System.out.println("Stack is full");
                    return;

                }

                this.top++;
                arr[this.top] = data;

            }

            public void pop(){

                if(isEmpty() == true){

                    System.out.println("Stack empty");
                    return;
                }

                arr[this.top] = '\0';
                this.top--;
            }

            public boolean isEmpty(){

                if(this.top == -1){
                    return true;
                }

                return false;
            }

            public boolean isBalanced(String exp){

                Stack myStack = new Stack(exp.length());
                for(int i = 0; i < exp.length(); i++){
        
                    if(exp.charAt(i) == '('){

                        myStack.push('(');

                    }else if(exp.charAt(i) == ')'){

                        if(myStack.isEmpty() == false){

                            myStack.pop();
                        }else{

                            return false;
                        }


                    }
        
                }

                if(myStack.isEmpty() == true){ return true;}

                return false;
        
            }


        }
            
        public static void main(String[] args) {
            Stack_parentheses sp = new Stack_parentheses();
        
            // Test cases
            String[] testExpressions = {
                "(())",        // Balanced
                "()",          // Balanced
                "(()())",      // Balanced
                "((()))",      // Balanced
                "(()",         // Not balanced
                ")(",          // Not balanced
                "())(",        // Not balanced
                "(()))",       // Not balanced
                "()",          // Balanced
                "((())",       // Not balanced
                "((()))()",    // Balanced
            };
        
            // Test each expression and print whether it's balanced
            for (String expression : testExpressions) {
                // Create a new stack for each expression to avoid state retention
                Stack_parentheses.Stack stack = sp.new Stack(expression.length());
        
                if (stack.isBalanced(expression)) {
                    System.out.println("Expression: \"" + expression + "\" is balanced.");
                } else {
                    System.out.println("Expression: \"" + expression + "\" is not balanced.");
                }
            }
        }
        

    

        
        
    }
