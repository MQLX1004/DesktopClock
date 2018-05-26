package clock.com.mql.www.desktopclock;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

public class activity_setting extends AppCompatActivity {
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton12;
    private RadioButton mRadioButton24;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initView();
        setDefaultButton();
        initClick();
    }
    private void initView(){
        mRadioGroup = (RadioGroup)findViewById(R.id.Set_RG_set_time_form);
        mRadioButton12 = (RadioButton)findViewById(R.id.Set_RB_form12);
        mRadioButton24 = (RadioButton)findViewById(R.id.Set_RB_form24);
    }
    private void initClick(){
        mRadioButton12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    new Thread() {
                        @Override
                        public void run() {
                            //发送事件
                            EventBus.getDefault().post(Integer.valueOf(0));
                        }
                    }.run();
                    Toast.makeText(activity_setting.this,"12",Toast.LENGTH_SHORT).show();
                }
            }
        });
        mRadioButton24.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    new Thread() {
                        @Override
                        public void run() {
                            //发送事件
                            EventBus.getDefault().post(Integer.valueOf(1));
                        }
                    }.run();
                    Toast.makeText(activity_setting.this,"24",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void setDefaultButton(){
        if (MainActivity.mPresentTimeForm == 1){
            mRadioButton24.setChecked(true);
        }else if(MainActivity.mPresentTimeForm == 0){
            mRadioButton12.setChecked(true);
        }
    }
}
