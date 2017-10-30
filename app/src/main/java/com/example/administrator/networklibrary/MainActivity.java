package com.example.administrator.networklibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.Button;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

@Fullscreen
@EActivity(R.layout.activity_main) // onCreate 생성
@WindowFeature(Window.FEATURE_NO_TITLE)
// 매니페스트에서 이름 바꿔줘야 한다!!
public class MainActivity extends AppCompatActivity {

//    // 뷰s
//    @BindViews({R.id.button, R.id.button2})
//    List<Button> btn_list;
//
//    // 뷰
//    @BindView(R.id.button)
//    Button button1;
//
//     클릭
//    @OnClick(R.id.button)
//    public void click(){
//
//    }

    // AndroidAnnotations
    @ViewById
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // 뷰가 모두 호출된 후 호출출
    @AfterViews
    public void init() {
        run();
    }

    // 서브스레드에서 실행
    @Background
    public void run(){
        for (int i = 0; i < 10; i++) {
            setName();
        }
    }

    // 메인 스레드에서 실행
    @UiThread
    public void setName(){

    }

}
