package com.example.ipc;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.ipc.aidl.BookAidl;
import com.example.ipc.aidl.IBookManager;

/**
 * Boo
 * @author MH
 *
 */
public class BookActivity extends AppCompatActivity{
	
	/**
	 * 接口对象
	 */
	private IBookManager mService;
	
	/**
	 * 绑定服务的回调
	 */
	private ServiceConnection conn = new ServiceConnection(){

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			
			// 获取到书籍管理的对象
			mService = IBookManager.Stub.asInterface(service);
			
			Log.i("aidl", "连接到服务端，获取IBookManager的对象");
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	};
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_book);
	
		// 启动服务
		Intent intent = new Intent(this,BookService.class);
		bindService(intent, conn, BIND_AUTO_CREATE);
		
	}

	
	/**
	 * 获取服务端书籍列表
	 * @param view
	 */
	public void getBookList(View view){
		
		try {
			Log.i("aidl","客户端查询书籍"+mService.getBookList().toString());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 添加书籍
	 */
	public void add(View view){
		
		try {
			// 调用服务端添加书籍
			mService.addBook(new BookAidl(3,"ios"));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
