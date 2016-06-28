package com.example.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/**
 * Messenger 的使用 服务端
 * 
 * @author MH
 * 
 */
public class MessengerService extends Service {

	/**
	 * 构建handler 对象
	 */
	public static Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			// 接受客户端发送的消息

			String msgClient = msg.getData().getString("msg");

			Log.i("messenger", "接收到客户端的消息--" + msgClient);

			// 获取客户端Messenger 对象

			Messenger messengetClient = msg.replyTo;

			// 向客户端发送消息
			Message message = Message.obtain();

			Bundle data = new Bundle();

			data.putString("msg", "ccccc");

			message.setData(data);

			try {
				// 发送消息
				messengetClient.send(message);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
	};

	// 通过handler 构建Mesenger 对象
	private final Messenger messenger = new Messenger(handler);

	@Override
	public IBinder onBind(Intent intent) {
		// 返回binder 对象
		return messenger.getBinder();
	}
}
