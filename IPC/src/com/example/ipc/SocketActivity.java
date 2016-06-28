package com.example.ipc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class SocketActivity extends AppCompatActivity {
	
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}
	
	public void conn(){
		try {
			Socket s = new Socket("localhost", 12345);
			
			// ----- 和服务端类似
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			//String line = br.readLine();
			// 输出流
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			//bw.write("....");
			// 关闭连接
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
