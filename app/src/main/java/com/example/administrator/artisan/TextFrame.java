package com.example.administrator.artisan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/3/31.
 */
public class TextFrame extends Fragment {
    private static final String FRAGMENT_TEXT = "textframe";
    @BindView(R.id.text_frame)
    TextView mTextView;
    private Unbinder bind;

    public static TextFrame newInstance(String text_frame) {
        TextFrame textFrame = new TextFrame();
        Bundle bundle = new Bundle();
        bundle.putString(FRAGMENT_TEXT,text_frame);
        textFrame.setArguments(bundle);
        return textFrame;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text_frame, null);
        bind = ButterKnife.bind(this, view);
        mTextView.setText(getArgumentText());
        return view;
    }
    public String getArgumentText(){
        return getArguments().getString(FRAGMENT_TEXT);
    }

    @Override
    public void onDestroy() {
        if (this.bind!=null){
            this.bind.unbind();
        }
        super.onDestroy();
    }
}
