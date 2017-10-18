package zhi.soft.com.zhifubao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import zhi.soft.com.zhifubao.util.StringTools;
import zhi.soft.com.zhifubao.util.ToastUtil;

public class MainActivity extends AppCompatActivity {

    private EditText price, name;
    private TextView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        price = (EditText) findViewById(R.id.main_price);
        name = (EditText) findViewById(R.id.main_name);
        next = (TextView) findViewById(R.id.main_next);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (StringTools.isEmpty(name.getText().toString())) {
                    ToastUtil.showCustomToastShort("总要告诉我收款人的名字吧...");
                    return;
                }
                if (StringTools.isEmpty(price.getText().toString())) {
                    ToastUtil.showCustomToastShort("没有金额，怎么接着搞事？！");
                    return;
                }
                Intent intent = new Intent(MainActivity.this, ZhiFuActivity.class);
                intent.putExtra("price", price.getText().toString());
                intent.putExtra("name", name.getText().toString());
                startActivity(intent);
            }
        });

    }


}
