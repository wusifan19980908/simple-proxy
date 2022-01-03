package com.jilin.simpleproxy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class SimpleProxyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SimpleProxyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(10040);
        System.out.println("监听8081");
        while (true){
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while (true){
               int length =  inputStream.read(bytes);
               if (length==-1){
                   break;
               }
                baos.write(bytes,0,length);
               if (length!= bytes.length){
                   break;
               }

            }
            socket.close();
            System.out.println("接受到数据："+baos.toString("utf-8"));
        }
    }
}
