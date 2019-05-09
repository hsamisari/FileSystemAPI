package com.huseyinsamisari.fstools;

import java.io.File;

public abstract class FSNodeAction {
	private File file;

	public FSNodeAction(File file) {
		super();
		setFile(file);
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	};

	public abstract void run();
}
