# Dependency Injection

- 외부에서 의존성을 추가해준다

## ButterKnife

```
compile 'com.jakewharton:butterknife:8.8.1'
annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.1'
```

```java
// 뷰s
@BindViews({R.id.button, R.id.button2})
List<Button> btn_list;

// 뷰
@BindView(R.id.button)
Button button1;

// 클릭
@OnClick(R.id.button)
public void click(){

}
```

## AndroidAnnotations

#### Dependency 변수 설정

```
def AAVersion = "4.+" 
```
#### Dependency 추가
```
annotationProcessor "org.androidannotations:androidannotations:$AAVersion"
compile "org.androidannotations:androidannotations-api:$AAVersion"
```
#### Manifest 설정
```java
<activity android:name=".MainActivity_"> // <-여기 .MainActivity_로 바꿔줘야 함
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />

        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
</activity>
```
#### 화면 설정
```java
@Fullscreen
@EActivity(R.layout.activity_main) // onCreate 생성
@WindowFeature(Window.FEATURE_NO_TITLE)
public class MainActivity extends AppCompatActivity { ... }
```
#### 뷰, 스레드 설정
```java
@ViewById
Button button;

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
```
