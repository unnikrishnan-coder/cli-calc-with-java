import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);
        int firstNum,secondNum,op;
        double result =0;
        boolean err = false;
        System.out.println("-----Calculator------");
        while (true){
            System.out.println("Select the operation you want to perform");
            System.out.println("1.Addition\n2.Subtraction\n3.Multiplication\n4.Division\n5.Exit");
            System.out.print("Enter the number corresponding to the operation: ");
            op = sc.nextInt();
            if(op==5){
                System.out.println("Exiting");
                break;
            }
            System.out.print("Enter the first number: ");
            firstNum = sc.nextInt();
            System.out.print("Enter the second number: ");
            secondNum = sc.nextInt();
            try {
                result = calc.calculate(firstNum,secondNum,op);
            } catch (Exception e) {
                err = true;
                System.out.println(e.getMessage());
            }
            if(!err) calc.display(result,op,err);
            System.out.println("\n");
        }
    }
}

class Calculator{
    public double calculate(int firstNum,int secondNum,int op) throws Exception{
        int result = 0;
        boolean err = false;
        switch (op){
            case 1:
                result = firstNum + secondNum;
                break;
            case 2:
                result = firstNum - secondNum;
                break;
            case 3:
                result = firstNum * secondNum;
                break;
            case 4:
                try {
                    result = firstNum / secondNum;
                } catch (ArithmeticException e) {
                    err = true;
                    System.out.println("Division by zero is not allowed!!!");
                }
                break;
            default:
                System.out.println("Invalid Operation!!!!");
                err = true;
                break;
        }
        if(err){
            throw new Exception("Something went wrong");
        }
        return result;

    }

    public void display(double result,int op,boolean err){
        String[] operations = {"Addition","Subtraction","Multiplication","Division"};
        if(!err) System.out.println("The result of " + operations[op-1] + " is: " + result);
    }

}