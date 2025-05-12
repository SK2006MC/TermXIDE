package com.termux.termxide.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger {
	private static final String TAG = "FileLogger";
	public final String filePath;
	private BufferedWriter writer;

	public FileLogger(String filePath) {
		this.filePath = filePath;
		File file = new File(filePath);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			this.writer = new BufferedWriter(new FileWriter(file, true));
		} catch (Exception e) {
			Log.e(TAG, "Error initializing FileLogger", e);
			this.writer = null;
		}
	}

	private String getTimestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
	}

	public synchronized void log(String msg) {
		if (writer == null) return;
		try {
			writer.write(getTimestamp() + " " + msg);
			writer.newLine();
			writer.flush();
		} catch (Exception e) {
			Log.d(TAG, "Error writing log", e);
		}
	}

	public synchronized void log(byte[] b) {
		if (writer == null) return;
		try {
			writer.write(getTimestamp() + " " + new String(b));
			writer.newLine();
			writer.flush();
		} catch (Exception e) {
			Log.e(TAG, "Error writing log bytes", e);
		}
	}

	// Call this when shutting down the application
	public synchronized void close() {
		if (writer == null) return;
		try {
			writer.flush();
			writer.close();
		} catch (Exception e) {
			Log.e(TAG, "Error closing log writer", e);
		}
	}
}