package com.huseyinsamisari.fstools;

import org.springframework.data.annotation.Id;

public class FSNode {
	@Id
	private String fullPath;
	private String name;
	private FSNodeType type;
	private FSNode parent;
	private long length;
	private long lastModified;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FSNodeType getType() {
		return type;
	}

	public void setType(FSNodeType type) {
		this.type = type;
	}

	public FSNode getParent() {
		return parent;
	}

	public void setParent(FSNode parent) {
		this.parent = parent;
	}

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public long getLastModified() {
		return lastModified;
	}

	public void setLastModified(long lastModified) {
		this.lastModified = lastModified;
	}

}
