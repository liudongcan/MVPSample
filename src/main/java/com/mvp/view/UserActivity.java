package com.mvp.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mvp.presenter.UserPresenter;
import com.samplemvp.R;

/**
 * View层的接口的实现类，传递数据给P层，以及从P层中获取数据
 */
public class UserActivity extends Activity implements OnClickListener,
        IUserView {

    private EditText mFirstNameEditText, mLastNameEditText, mIdEditText;
    private Button mSaveButton, mLoadButton;
    private UserPresenter mUserPresenter;
    private TextView mTextViewID, mTextViewFirst, mTextViewLast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化View,查找控件
        initView();
        /**获得P层的对象--mUserPresenter
         * 并且把实现了IUserView接口的实现类UserActivity传递给P层
         * new UserPresenter(this)；
         * 这样在P层中就可以通过这个对象
         * 调用UserActivity中的方法了；
         * */
        mUserPresenter = new UserPresenter(this);
        mSaveButton.setOnClickListener(this);
        mLoadButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.saveButton:
                /**通过P层的对象，调用P层中的方法*/
                mUserPresenter.saveUser(getID(), getFristName(),
                        getLastName());
                break;
            case R.id.loadButton:
                mUserPresenter.loadUser(getID());
                break;
            default:
                break;
        }
    }

    /**
     *下面的方法为com.mvp.view.IUserView接口的方法
     */
    /**
     * -------------------------start--------------------------
     */
    @Override
    public void setID(String id) {
        mTextViewID.setText(id);
    }

    @Override
    public void setFirstName(String firstName) {
        mTextViewFirst.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        mTextViewLast.setText(lastName);
    }

    @Override
    public int getID() {
        return Integer.parseInt(mIdEditText.getText().toString());
    }

    @Override
    public String getFristName() {
        return mFirstNameEditText.getText().toString();
    }

    @Override
    public String getLastName() {
        return mLastNameEditText.getText().toString();
    }


    /**-------------------------end--------------------------*/
    /**
     * 初始化，查找View
     */
    public void initView() {
        mFirstNameEditText = (EditText) findViewById(R.id.first_name_edt);
        mLastNameEditText = (EditText) findViewById(R.id.last_name_edt);
        mIdEditText = (EditText) findViewById(R.id.id_edt);
        mTextViewID = (TextView) findViewById(R.id.show_id_txv);
        mTextViewFirst = (TextView) findViewById(R.id.show_firstname_txv);
        mTextViewLast = (TextView) findViewById(R.id.show_lastname_txv);
        mSaveButton = (Button) findViewById(R.id.saveButton);
        mLoadButton = (Button) findViewById(R.id.loadButton);
    }
}
