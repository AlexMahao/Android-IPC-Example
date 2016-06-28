package com.example.ipc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SocketService extends Service {

	/**
	 * 连接的状态
	 */
	private boolean isConnState = true;
	
	
	@Override
	public void onCreate() {
		super.onCreate();

		// 启动TCP 服务
		new Thread(new TCPServer()).start();
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	
	@Override
	public void onDestroy() {
		// 结束TCP 服务
		isConnState = false;
		super.onDestroy();
	}
	
	/**
	 * 服务端TCP 服务，相当于服务器，接受Socket 连接
	 * @author MH
	 *
	 */
	class TCPServer implements Runnable{

		@Override
		public void run() {
			
			try {
				// 监听本地的12345 端口
				ServerSocket ss = new ServerSocket(12345);
				
				while(isConnState){
					
					// 获取客户端的Socket 对象
					Socket socket = ss.accept();
					
					// 获取输入流  --- 
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					// 通过输入流读取客户端的消息
					//String line = br.readLine();
					// 输出流
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					// 通过输出流向客户端发送消息
					//bw.write("....");
					// 关闭连接
					socket.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
