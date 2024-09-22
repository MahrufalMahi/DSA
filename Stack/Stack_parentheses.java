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

            public char pop(){

                if(isEmpty() == true){

                    System.out.println("Stack empty");
                    return '\0';
                }
                char temp = arr[this.top];
                arr[this.top] = '\0';
                this.top--;
                return temp;
            }

            public boolean isEmpty(){

                if(this.top == -1){
                    return true;
                }

                return false;
            }

            public boolean multiLevelIsBalanced(String exp){

                Stack myStack = new Stack(exp.length());

                for(int i = 0; i < exp.length(); i++){

                    if(exp.charAt(i) == '(' || exp.charAt(i) == '{' || exp.charAt(i) == '['){

                        myStack.push(exp.charAt(i));

                    }else if(exp.charAt(i) == ')' || exp.charAt(i) == '}' || exp.charAt(i) == ']'){

                        if(myStack.isEmpty() == false){

                            char poppedItem = myStack.pop();
                            if ((exp.charAt(i) == ')' && poppedItem != '(') ||
                                (exp.charAt(i) == '}' && poppedItem != '{') ||
                                (exp.charAt(i) == ']' && poppedItem != '[')) {
                
                                    return false; // Mismatched brackets
                       }
                        }

                    }

                }

                return myStack.isEmpty();
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
        
            // Test cases for isBalanced method
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
            System.out.println("Testing isBalanced method:");
            for (String expression : testExpressions) {
                if (sp.new Stack(expression.length()).isBalanced(expression)) {
                    System.out.println("Expression: \"" + expression + "\" is balanced.");
                } else {
                    System.out.println("Expression: \"" + expression + "\" is not balanced.");
                }
            }
        
            // Additional test cases for multiLevelIsBalanced method
            String[] multiLevelExpressions = {
                "[{()}]",      // Balanced
                "[(])",        // Not balanced
                "{[()()]}",    // Balanced
                "{[(])}",      // Not balanced
                "((({{{[]}}}))", // Not balanced
                "{}",          // Balanced
                "[(]){",       // Not balanced
                "[]{}()",      // Balanced
                "[{]}",        // Not balanced
                "[](){}",      // Balanced
            };
        
            // Test each expression for multiLevelIsBalanced
            System.out.println("\nTesting multiLevelIsBalanced method:");
            for (String expression : multiLevelExpressions) {
                if (sp.new Stack(expression.length()).multiLevelIsBalanced(expression)) {
                    System.out.println("Expression: \"" + expression + "\" is balanced.");
                } else {
                    System.out.println("Expression: \"" + expression + "\" is not balanced.");
                }
            }
        }
        

    

        
        
    }
