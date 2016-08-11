package com.mvp.view;

/**
 * View层的接口
 */
public interface IUserView {
	int getID();

	String getFristName();

	String getLastName();
	void setID(String id);
	void setFirstName(String firstName);

	void setLastName(String lastName);

}
