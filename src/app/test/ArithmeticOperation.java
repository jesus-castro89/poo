package app.test;

public enum ArithmeticOperation {

    ADDITION("Addition") {
        @Override
        public void doOperation(double a, double b) {
            System.out.println("Result: " + (a + b));
        }
    },
    SUBTRACTION("Subtraction") {
        @Override
        public void doOperation(double a, double b) {
            System.out.println("Result: " + (a - b));
        }
    },
    MULTIPLICATION("Multiplication") {
        @Override
        public void doOperation(double a, double b) {
            System.out.println("Result: " + (a * b));
        }
    },
    DIVISION("Division") {
        @Override
        public void doOperation(double a, double b) {
            if (b != 0) {
                System.out.println("Result: " + (a / b));
            } else {
                System.out.println("Error: Division by zero");
            }
        }
    };

    private final String description;

    ArithmeticOperation(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    public abstract void doOperation(double a, double b);
}
