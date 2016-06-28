package com.example.ipc.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class BookAidl implements Parcelable {

	public int bookId;

	public String bookName;

	public BookAidl() {
		super();
		
	}
	
	public BookAidl(int bookId, String bookName) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(bookId);
		dest.writeString(bookName);
	}

	public static final Parcelable.Creator<BookAidl> CREATOR = new Creator<BookAidl>() {

		@Override
		public BookAidl[] newArray(int size) {
			return new BookAidl[size];
		}

		@Override
		public BookAidl createFromParcel(Parcel source) {

			BookAidl book = new BookAidl();
			book.bookId = source.readInt();
			book.bookName = source.readString();
			return book;
		}
	};

	@Override
	public String toString() {
		return "BookAidl [bookId=" + bookId + ", bookName=" + bookName + "]";
	}

}
