package lang.jdk8.basics.interfaces;

import java.util.Collection;

public interface SampleInterface extends Collection<String>, Comparable<String> {

	public String COLOUR = "RED";
	public String NAME = "CIRCLE";
	String privateStr = "newPrivateString";

	public void methodOne(int ID, String Name);

	public void methodTwo(String colour);
}
