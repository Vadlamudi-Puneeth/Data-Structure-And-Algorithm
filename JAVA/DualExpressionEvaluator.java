import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class DualExpressionEvaluator {

    public static String[] processDualContainerOperations(int n, String[] operations, int[] values) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder results = new StringBuilder();
        
        List<String> outputLines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String op = operations[i];
            int value = values[i];

            switch (op) {
                case "PUSH":
                    stack.push(value);
                    break;
                case "ENQUEUE":
                    queue.add(value);
                    break;
                case "POP":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case "DEQUEUE":
                    if (!queue.isEmpty()) {
                        queue.remove();
                    }
                    break;
                case "ADD":
                case "SUB":
                case "MUL":
                case "DIV":
                    int stackVal = stack.pop();
                    int queueVal = queue.remove();
                    int result = 0;

                    switch (op) {
                        case "ADD":
                            result = stackVal + queueVal;
                            break;
                        case "SUB":
                            result = stackVal - queueVal;
                            break;
                        case "MUL":
                            result = stackVal * queueVal;
                            break;
                        case "DIV":
                            result = stackVal / queueVal; // Integer division
                            break;
                    }

                    results.append(result).append(" ");
                    stack.push(result);
                    queue.add(result);
                    break;
            }
        }

        // Line 1: Intermediate results
        outputLines.add(results.toString().trim());

        // Line 2: Final stack contents (top to bottom)
        StringBuilder stackContents = new StringBuilder();
        while (!stack.isEmpty()) {
            stackContents.append(stack.pop()).append(" ");
        }
        outputLines.add(stackContents.toString().trim());

        // Line 3: Final queue contents (front to back)
        StringBuilder queueContents = new StringBuilder();
        while (!queue.isEmpty()) {
            queueContents.append(queue.remove()).append(" ");
        }
        outputLines.add(queueContents.toString().trim());

        return outputLines.toArray(new String[0]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] operations = br.readLine().split(" ");
        String[] valueStrings = br.readLine().split(" ");
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(valueStrings[i]);
        }

        String[] output = processDualContainerOperations(n, operations, values);
        for (String line : output) {
            System.out.println(line);
        }
    }
}