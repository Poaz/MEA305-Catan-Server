package com.company;

    import java.io.*;
    import java.net.InetAddress;
    import java.net.Socket;

    public class NewClientTry {

        public static void main(String args[]) throws IOException{


            InetAddress address=InetAddress.getLocalHost();
            Socket sock=null;
            String line=null;
            BufferedReader br=null;
            BufferedReader is=null;
            PrintWriter os=null;
           // PrintWriter nickName;

            try {
                sock=new Socket(address, 4445); // You can use static final constant PORT_NUM
                br= new BufferedReader(new InputStreamReader(System.in));
                is=new BufferedReader(new InputStreamReader(sock.getInputStream()));
                os= new PrintWriter(sock.getOutputStream());
                //nickName = new PrintWriter(sock.getOutputStream());
                //nickName.println("Thomesh");

            }
            catch (IOException e){
                e.printStackTrace();
                System.err.print("IO Exception");
            }

            System.out.println("Client Address : "+address);

            String response=null;
            try{
                line=br.readLine();
                while(true){
                    os.println(line);
                    os.flush();
                    response=is.readLine();
                    System.out.println("Server Response : "+response);
                    line=br.readLine();

                }



            }
            catch(IOException e){
                e.printStackTrace();
                System.out.println("Socket read Error");
            }
            finally{

                is.close();os.close();br.close();sock.close();
                System.out.println("Connection Closed");

            }

        }
    }

