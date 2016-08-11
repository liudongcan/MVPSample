package com.mvp.model;

import android.util.SparseArray;

import com.mvp.bean.UserBean;

/**
 * M层接口的实现类，保存P层传递的数据，获取返回数据给P层，
 * 通过P层再传递给V层
 */
public class UserModel implements IUserModel {

	private String mFristName;
	private String mLastName;
	private int mID;
	private SparseArray<UserBean> mUsererArray = new SparseArray<UserBean>();
    /**保存P层传递的数据*/
	/**-------------------------start--------------------------*/
	@Override
	public void setID(int id) {
		mID = id;
	}

	@Override
	public void setFirstName(String firstName) {
		mFristName = firstName;
	}

	@Override
	public void setLastName(String lastName) {
		mLastName = lastName;
		UserBean UserBean = new UserBean(mFristName, mLastName);
		mUsererArray.append(mID, UserBean);
	}
	/**-------------------------end--------------------------*/
	/**返回数据给P层*/
	@Override
	public UserBean load(int id) {
		mID = id;
		UserBean userBean = mUsererArray.get(mID, new UserBean("not found",
				"not found"));
		return userBean;

	}

}
