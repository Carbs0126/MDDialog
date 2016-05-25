package cn.carbs.android.mddialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.carbs.android.library.MDDialog;

public class ActivityMain extends AppCompatActivity {

    Button button1;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        final String[] messages = new String[]{"两个黄鹂鸣翠柳，一行白鹭上青天。",
                "窗含西岭千秋雪，门泊东吴万里船。",
                "君不见，黄河之水天上来，奔流到海不复回；君不见，高堂明镜悲白发，朝如青丝暮如雪。"};
        button1 = (Button)this.findViewById(R.id.button1);
        button2 = (Button)this.findViewById(R.id.button2);

        /*final LinearLayout ll = new LinearLayout(this);
        LayoutInflater.from(this).inflate(R.layout.content, ll);*/

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new MDDialog.Builder(ActivityMain.this)
//				        .setContentView(ll)
                        .setContentView(R.layout.content_dialog)
                        .setContentViewOperator(new MDDialog.ContentViewOperator() {
                            @Override
                            public void operate(View contentView) {
                                EditText et = (EditText)contentView.findViewById(R.id.edit0);
                                et.setHint("hint set in operator");
                            }
                        })
//                      .setMessages(messages)
                        .setTitle("添加")
                        .setNegativeButton(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                            }
                        })
                        .setPositiveButton(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        })
                        .setPositiveButtonMultiListener(new MDDialog.OnMultiClickListener() {

                            @Override
                            public void onClick(View clickedView, View contentView) {
                                EditText et = (EditText)contentView.findViewById(R.id.edit0);
                                Toast.makeText(getApplicationContext(), "edittext 0 : " + et.getText(), Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButtonMultiListener(new MDDialog.OnMultiClickListener() {

                            @Override
                            public void onClick(View clickedView, View contentView) {
                                EditText et = (EditText)contentView.findViewById(R.id.edit1);
                                Toast.makeText(getApplicationContext(), "edittext 1 : " + et.getText(), Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setOnItemClickListener(new MDDialog.OnItemClickListener() {
                            @Override
                            public void onItemClicked(int index) {
                                if (index == 0) {
                                    Toast.makeText(getApplicationContext(), "index 0", Toast.LENGTH_SHORT).show();
                                } else if (index == 1) {
                                    Toast.makeText(getApplicationContext(), "index 1", Toast.LENGTH_SHORT).show();
                                } else if (index ==2 ){
                                    Toast.makeText(getApplicationContext(), "index 2", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setWidthMaxDp(600)
//                      .setShowTitle(false)
                        .setShowButtons(true)
                        .create()
                        .show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new MDDialog.Builder(ActivityMain.this)
                        .setMessages(messages)
                        .setTitle("一首古诗")
                        .setNegativeButton(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                            }
                        })
                        .setPositiveButton(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getApplicationContext(), "positive", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setOnItemClickListener(new MDDialog.OnItemClickListener() {
                            @Override
                            public void onItemClicked(int index) {
                                Toast.makeText(getApplicationContext(), messages[index], Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setWidthMaxDp(600)
                        .setShowTitle(false)
                        .setShowButtons(true)
                        .create()
                        .show();
            }
        });
    }
}
