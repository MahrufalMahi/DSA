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

            public int precedence(char operator){

                switch (operator) {
                    case '+':
                    case '-':
                    return 1;
                        
                    case '/':
                    case '*':
                    return 2;
                
                    default:
                        return -1;
                }
            }

            public String inFixToPostFix(String exp){

                Stack myStack = new Stack(exp.length());
                String postFixStr = "";

                for(int i = 0; i < exp.length(); i++){

                    if (Character.isLetterOrDigit(exp.charAt(i))) {
                        postFixStr += exp.charAt(i);
                    }else if(exp.charAt(i) =='('){

                        myStack.push(exp.charAt(i));
                    }else if(exp.charAt(i) == ')'){

                        if(myStack.isEmpty()){

                            return "Expression is unbalanced";
                        }
                        while(myStack.arr[myStack.top] != '(') {
                            
                            char poppedItem = myStack.pop();
                            postFixStr += poppedItem;
                        }
                        myStack.pop();
                    }else if(exp.charAt(i) == '*' || exp.charAt(i) == '+' || exp.charAt(i) == '-' || exp.charAt(i) == '/'){


                        while(!myStack.isEmpty() && precedence(exp.charAt(i)) <= precedence(myStack.arr[myStack.top])){

                            char poppedItem = myStack.pop();
                            postFixStr += poppedItem;

                        }

                        myStack.push(exp.charAt(i));
                    }
                }

                if(!myStack.isEmpty()){

                    while (!myStack.isEmpty()) {
                        
                        char poppedItem = myStack.pop();
                        postFixStr += poppedItem;
                    }
                }

                return postFixStr;


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
            
                System.out.println("\nTesting multiLevelIsBalanced method:");
                for (String expression : multiLevelExpressions) {
                    if (sp.new Stack(expression.length()).multiLevelIsBalanced(expression)) {
                        System.out.println("Expression: \"" + expression + "\" is balanced.");
                    } else {
                        System.out.println("Expression: \"" + expression + "\" is not balanced.");
                    }
                }
            
                // Test cases for inFixToPostFix method
                String[] infixExpressions = {
                    "a+b*c",        // Postfix: abc*+
                    "(a+b)*c",      // Postfix: ab+c*
                    "((a-b)/c)",    // Postfix: ab-c/
                    "a*(b+c)-d",    // Postfix: abc+*d-
                };
            
                System.out.println("\nTesting inFixToPostFix method:");
                for (String expression : infixExpressions) {
                    String postFix = sp.inFixToPostFix(expression); // Use the instance to call the method
                    System.out.println("Infix: \"" + expression + "\" => Postfix: " + postFix);
                }
            }
            
            
            

        

            
            
        }
