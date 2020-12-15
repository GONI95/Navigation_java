package com.example.navigation_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

//https://developer.android.com/guide/navigation/navigation-ui?hl=ko#java
public class MainActivity extends AppCompatActivity {
    AppBarConfiguration appBarConfiguration;
    // 1-2. navigationUI는 AppBar.. 객체를 사용해 앱바에 대한 동작, 표시 등을 관리하는데
    // 위 객체에 의해 뒤로가기 버튼이 자동으로 생성됩니다. 하지만
    // 최고 수준의 루트 대상(activity)에는 뒤로가기 버튼이 당연히 생성안되도록 구현되어있고
    // drawerLayout을 사용하면 메뉴 버튼도 생성 가능합니다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        // 1-3. activity_main : navigation 라이브러리 안에 있는 navhostfragment를
        // 사용하는데 이 것에는 navconctroller가 내장이 되어있고 컨트롤러를 찾아야
        // 필요로 하는 navigation에 대한 기능을 수행할 수 있다.

        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        // 1-4. AppBar... 객체를 만들어 해당하는 Navigation Graph에 전달하여 연결해줌
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        // 1-5. 해당 Activity에 컨트롤러와 AppBar 객체를 담아 setupAction.. 메소드를 호출하면
        // 이 메서드에 의해 화면(즉 대상)이 변경될 때 제목(label)이 자동으로 변경된다.
    }

    @Override
    public boolean onSupportNavigateUp() {
        // 2-1 위에서 설명했듯이 뒤로가기 버튼이 자동으로 생성되지만 해당 버튼에 탐색을 처리할 수 있는
        // 코드가 없어서 당연히 동작이 없다. navcontroller를 사용하여 버튼이 탐색할 수 있도록 해주면 된다.
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}