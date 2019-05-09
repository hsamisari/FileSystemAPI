package com.huseyinsamisari.fstools;

import java.io.File;
import java.util.stream.Stream;

public class FSWalkerNodeAction {
	private FSNodeAction action;
	private File currentFile;

	public FSWalkerNodeAction(File root, FSNodeAction action) {
		this.currentFile = root;
		this.action = action;
	}

	public void walk() {
		if (currentFile != null) {
			action.setFile(currentFile);
			action.run();
			if (currentFile.isDirectory() && currentFile.listFiles() != null) {
				Stream.of(currentFile.listFiles()).forEachOrdered(f -> {
					currentFile = f;
					walk();
				});
			}
		}
	}
}
