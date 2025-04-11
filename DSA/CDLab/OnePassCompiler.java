package CDLab;

import java.util.*;


public class OnePassCompiler {
    static Map<String, String> symbolTable = new HashMap<>(); // var -> type
    static List<String> intermediateCode = new ArrayList<>();
    static int tempCount = 1;

    public static void main(String[] args) {
        // Sample input: simulating a mini source code
        List<String> code = Arrays.asList(
            "int a;",
            "int b;",
            "a = 5;",
            "b = a + 3;",
            "c = b + 1;" // undeclared variable error
        );

        for (String line : code) {
            line = line.replace(";", "").trim();

            if (line.startsWith("int ")) {
                handleDeclaration(line);
            } else {
                handleAssignment(line);
            }
        }

        // Output symbol table and generated code
        System.out.println("Symbol Table:");
        symbolTable.forEach((var, type) -> System.out.println(var + " : " + type));

        System.out.println("\nGenerated Intermediate Code:");
        intermediateCode.forEach(System.out::println);
    }

    static void handleDeclaration(String line) {
        String[] parts = line.split(" ");
        if (parts.length == 2) {
            String var = parts[1];
            if (symbolTable.containsKey(var)) {
                System.out.println("Error: Variable '" + var + "' already declared");
            } else {
                symbolTable.put(var, "int");
            }
        } else {
            System.out.println("Invalid declaration: " + line);
        }
    }

    static void handleAssignment(String line) {
        String[] parts = line.split("=");
        if (parts.length != 2) {
            System.out.println("Invalid assignment: " + line);
            return;
        }

        String lhs = parts[0].trim();
        String rhs = parts[1].trim();

        if (!symbolTable.containsKey(lhs)) {
            System.out.println("Error: Variable '" + lhs + "' not declared");
            return;
        }

        if (rhs.contains("+")) {
            String[] operands = rhs.split("\\+");
            String op1 = operands[0].trim();
            String op2 = operands[1].trim();

            if (!isValidOperand(op1) || !isValidOperand(op2)) return;

            String temp = "t" + tempCount++;
            intermediateCode.add(temp + " = " + op1 + " + " + op2);
            intermediateCode.add(lhs + " = " + temp);
        } else {
            if (!isValidOperand(rhs)) return;
            intermediateCode.add(lhs + " = " + rhs);
        }
    }

    static boolean isValidOperand(String operand) {
        if (operand.matches("\\d+")) return true;
        if (symbolTable.containsKey(operand)) return true;

        System.out.println("Error: Operand '" + operand + "' not declared");
        return false;
    }
}
