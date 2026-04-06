// Exam: 2255 GCIS 124, Mid Term Exam #3, Question 2
// Filename: KnockKnockServer.java (inside knockknock package)

package mte3.knockknock;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import mte3.knockknock2.Server;

public class KnockKnockServer extends Thread {
    public static int PORT = 54322;
    private static String name = "";

    public static void receiveAndSend(Scanner scanner,String message,PrintWriter writer,boolean concat) {
        String output = scanner.nextLine();
        System.out.println("Recieved: " + output);
        if (concat) {
            name = output;
            writer.println(name + message);
        } else {
            writer.println(message);
        }
        writer.flush();
        System.out.println("Sent: " + message);


    } // receiveAndSend() method closed
    
    public static void main(String args[]) throws IOException, InterruptedException {
        ServerSocket server = new ServerSocket(PORT);
        Socket connection = server.accept();
            receiveAndSend(new Scanner(connection.getInputStream()), "Who's there", new PrintWriter(connection.getOutputStream()), false);
            receiveAndSend(new Scanner(connection.getInputStream()), " who?" , new PrintWriter(connection.getOutputStream()), true);
            receiveAndSend(new Scanner(connection.getInputStream()), "LOL" , new PrintWriter(connection.getOutputStream()), false);
        connection.close();
        server.close();
    } // main() method closed
}