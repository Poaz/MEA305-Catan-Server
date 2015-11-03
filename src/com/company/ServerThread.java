package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Zilen on 03/11/2015.
 */
class ServerThread extends Thread{

    String line=null;
    BufferedReader is = null;
    PrintWriter os=null;
    //PrintWriter nickName=null;
    Socket sock=null;

    public ServerThread(Socket s){
        this.sock=s;
    }

    public void run() {
        try{
            is= new BufferedReader(new InputStreamReader(sock.getInputStream()));
            os=new PrintWriter(sock.getOutputStream());
            //nickName=new PrintWriter(sock.getOutputStream());
            //nickName.println("Dinesh");

        }catch(IOException e){
            System.out.println("IO error in server thread");
        }

        try {
            line=is.readLine();
            while(true){

                os.println(line);
                os.flush();
                System.out.println("Response from blabla  :  "+line);
                line=is.readLine();
            }
        } catch (IOException e) {

            line=this.getName(); //reused String line for getting thread name
            System.out.println("IO Error/ Client "+line+" terminated abruptly");
        }
        catch(NullPointerException e){
            line=this.getName(); //reused String line for getting thread name
            System.out.println("Client "+line+" Closed");
        }
    }
}
