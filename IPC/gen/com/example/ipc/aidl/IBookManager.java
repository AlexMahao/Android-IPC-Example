/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: E:\\adt-bundle-windows-x86_64-20140702\\code\\IPC\\src\\com\\example\\ipc\\aidl\\IBookManager.aidl
 */
package com.example.ipc.aidl;
public interface IBookManager extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.ipc.aidl.IBookManager
{
private static final java.lang.String DESCRIPTOR = "com.example.ipc.aidl.IBookManager";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.ipc.aidl.IBookManager interface,
 * generating a proxy if needed.
 */
public static com.example.ipc.aidl.IBookManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.ipc.aidl.IBookManager))) {
return ((com.example.ipc.aidl.IBookManager)iin);
}
return new com.example.ipc.aidl.IBookManager.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getBookList:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<com.example.ipc.aidl.BookAidl> _result = this.getBookList();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_addBook:
{
data.enforceInterface(DESCRIPTOR);
com.example.ipc.aidl.BookAidl _arg0;
if ((0!=data.readInt())) {
_arg0 = com.example.ipc.aidl.BookAidl.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.addBook(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.ipc.aidl.IBookManager
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public java.util.List<com.example.ipc.aidl.BookAidl> getBookList() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.example.ipc.aidl.BookAidl> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getBookList, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.example.ipc.aidl.BookAidl.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void addBook(com.example.ipc.aidl.BookAidl book) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((book!=null)) {
_data.writeInt(1);
book.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addBook, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_getBookList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_addBook = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
public java.util.List<com.example.ipc.aidl.BookAidl> getBookList() throws android.os.RemoteException;
public void addBook(com.example.ipc.aidl.BookAidl book) throws android.os.RemoteException;
}
