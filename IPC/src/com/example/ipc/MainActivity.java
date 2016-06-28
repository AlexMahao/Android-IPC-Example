package com.example.ipc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

	public static String PATH = Environment.getExternalStorageDirectory()
			.getAbsolutePath() + "/tt.txt";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		File file = new File(PATH);

		System.out.println(Environment.getExternalStorageState());
		
		System.out.println(file.exists());
		
		
		wirte();
	}
 
	
	/**
	 * 写入序列化对象
	 */
	public void wirte() {
		Book book = new Book();
		book.bookId = 1;
		book.bookName = "si";
		try {
			
			// 构造序列化输出字节流
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(PATH));
			// 序列化对象
			oos.writeObject(book);
			// 关闭流
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(book);

	}

	public void startSecond(View view) {
		Intent intent = new Intent(this, SecondActivity.class);
		startActivity(intent);
	}
}
