package com.example.ipc;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		read();
	}

	public void startThird(View view) {
		Intent intent = new Intent(this, ThirdActivity.class);
		startActivity(intent);

	}

	public void read() {
		Book book = null;
		try {
			// 创建序列化读取字节流
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					MainActivity.PATH));
			// 反序列化（读取）对象
			book = (Book) ois.readObject();
			// 关闭流
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(book);
	}
}
