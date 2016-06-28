package com.example.ipc.aidl;

import com.example.ipc.aidl.BookAidl;

interface IBookManager{
	List<BookAidl> getBookList();
	void addBook(in BookAidl book);
}

