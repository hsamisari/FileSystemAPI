package com.huseyinsamisari.fstools;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public class FSTreeWalker {
	private FSNode root = new FSNode();
	private FSNodeRepository repository;
	private AtomicInteger tCount = new AtomicInteger(0);

	public FSTreeWalker(FSNodeRepository repository) {
		super();
		this.repository = repository;
		root.setName("root");
		repository.save(root);
	}

	public void initWalk() {
		for (File file : File.listRoots()) {
			FSNode node = saveNode(file, root);
			if (file.isDirectory())
				walk(file, node);
		}
	}

	private FSNode saveNode(File file, FSNode parentNode) {
		FSNode node = new FSNode();
		node.setFullPath(file.getPath());
		node.setName(file.getName());
		node.setParent(parentNode);
		node.setLength(file.length());
		node.setLastModified(file.lastModified());
		node.setType(file.isDirectory() ? FSNodeType.directory : FSNodeType.file);
		repository.save(node);
		return node;
	}

	public void walk(final File parentFile, final FSNode parentNode) {
		if (parentFile.listFiles() == null)
			return;
		for (File file : parentFile.listFiles()) {
			FSNode node = saveNode(file, parentNode);
			if (file.isDirectory())
				if (tCount.incrementAndGet() < 100) {
					new Thread(new Runnable() {
						@Override
						public void run() {
							walk(file, node);
							tCount.decrementAndGet();
						}
					}).start();
				} else {
					tCount.decrementAndGet();
					walk(file, node);
				}
		}
	}

	public FSNode getRoot() {
		return root;
	}

	public void setRoot(FSNode root) {
		this.root = root;
	}
}
