package com.example.ipc;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.ipc.aidl.BookAidl;
import com.example.ipc.aidl.IBookManager;

public class BookService extends Service {

	/**
	 * 支持线程同步，因为其存在多个客户端同时连接的情况
	 */
	private CopyOnWriteArrayList<BookAidl> list = new CopyOnWriteArrayList<>();

	
	/**
	 * 构造 aidl中声明的接口的Stub对象，并实现所声明的方法
	 */
	private Binder mBinder = new IBookManager.Stub() {

		@Override
		public List<BookAidl> getBookList() throws RemoteException {
			return list;
		}

		@Override
		public void addBook(BookAidl book) throws RemoteException {
			list.add(book);
			Log.i("aidl", "服务端添加了一本书"+book.toString());
		}
	};
	
	@Override
	public void onCreate() {
		super.onCreate();
		//加点书
		list.add(new BookAidl(1, "java"));
		list.add(new BookAidl(2, "android"));

	}

	@Override
	public IBinder onBind(Intent intent) {
		// 返回给客户端的Binder对象
		return mBinder;
	}
}
