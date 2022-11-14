package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();
        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        while(!command.equals("print")){
            if(command.equals("cancel")){
                String cancelFile = printerQueue.poll();
                if (cancelFile == null){
                    System.out.println("Printer is on standby");
                }else{
                    System.out.println("Canceled " + cancelFile);
                }
            }else{
                printerQueue.offer(command);
            }
            command = sc.nextLine();
        }

        while(printerQueue.size() > 0){
            System.out.println(printerQueue.pop());
        }
    }
}
