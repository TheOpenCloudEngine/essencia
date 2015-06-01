package org.uengine.essencia.resource;

public enum ActionKind {
	CREATE("create"), READ("read"), WRITE("write"), DELETE("delete");

	private final String kind;

	public String getKind() {
		return kind;
	}

	ActionKind(String kind) {
		this.kind = kind;
	}
}
