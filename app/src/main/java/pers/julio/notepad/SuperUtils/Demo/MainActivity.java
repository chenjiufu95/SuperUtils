package pers.julio.notepad.SuperUtils.Demo;

import androidx.appcompat.app.AppCompatActivity;
import pers.julio.notepad.SuperUtils.SpUtils;
import pers.julio.notepad.SuperUtils.ToastUtils;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToastUtils.showToast(this, "测试");
        SpUtils.getInt(this, "3", 5);
    }
}
