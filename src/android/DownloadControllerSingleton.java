/*
	CordovaPlugin (Android): Download Manager (Notification Bar Support)
*/

package org.apache.cordova.plugins.DownloadManager;

import java.util.ArrayList;

public class DownloadControllerSingleton {
	
	private ArrayList<String> ids = new ArrayList<String>();
	
	protected DownloadControllerSingleton() {}
	
	private static class SingletonHolder { 
		private final static DownloadControllerSingleton INSTANCE = new DownloadControllerSingleton();
	}
	
	public static DownloadControllerSingleton getInstance() {
		return SingletonHolder.INSTANCE;
	}
	
	public void add(String id) {
		this.ids.add(id);
	}
	public void del(String id) {
		try {
			this.ids.remove(this.ids.indexOf(id));
		} catch (Exception e) {
			// TODO: ...
		}
	}
	public void remove(int pos) {
		try {
			this.ids.remove(pos);
		} catch (Exception e) {
			// TODO: ...
		}
	}
	public boolean isId(String id) {
		try {
			if (this.ids.indexOf(id) != -1) return true;
		} catch (Exception e) {
			// TODO: ...
		}
		return false;
	}
	
	
}
