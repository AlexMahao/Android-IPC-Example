package com.example.ipc;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Serializable 序列化对象
 * @author MH
 *
 */
public class Book implements Serializable {
	/**
	 *  序列化和反序列的关键
	 */
	private static final long serialVersionUID = 1L;

	
	public int bookId;
	
	public String bookName;

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + "]";
	}

	
	
}
