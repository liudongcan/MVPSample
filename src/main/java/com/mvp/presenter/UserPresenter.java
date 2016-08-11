package com.mvp.presenter;

import com.mvp.bean.UserBean;
import com.mvp.model.IUserModel;
import com.mvp.model.UserModel;
import com.mvp.view.IUserView;

/**
 * P层持有View的接口对象，和Model层的接口对象
 */
public class UserPresenter {
	private IUserView mUserView;
	private IUserModel mUserModel;

	/**
	 * 获得View层的对象
	 * 并且new一个M层的对象
	 * @param view
	 */
	public UserPresenter(IUserView view) {
		mUserView = view;
		//创建一个V层接口的实现类的接口引用类型对象
		mUserModel = new UserModel();
	}

	/**
	 * 当V层调用这个方法的时候，其实是通过P层去调用M层的方法，传递数据给M层
	 * @param id
	 * @param firstName
	 * @param lastName
	 */
	public void saveUser(int id, String firstName, String lastName) {
		mUserModel.setID(id);
		mUserModel.setFirstName(firstName);
		mUserModel.setLastName(lastName);
	}

	/**
	 * 当V层调用这个方法的时候，其实是通过P层去调用M层的方法，从M层中获取数据，
	 * 然后调用V层实现类的对象中的方法，对View的视图进行改变
	 * @param id
	 */
	public void loadUser(int id) {
		UserBean user = mUserModel.load(id);
		mUserView.setID(""+id);
		mUserView.setFirstName(user.getFirstName());
		mUserView.setLastName(user.getLastName());
	}
}
