package org.uengine.essencia.model.coverage;

public class State {
	private String name;
	private boolean involved;
	
	public State(){
		
	}
	public State(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isInvolved() {
		return involved;
	}
	public void setInvolved(boolean involved) {
		this.involved = involved;
	}
	
	
}
