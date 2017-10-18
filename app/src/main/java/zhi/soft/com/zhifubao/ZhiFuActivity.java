package zhi.soft.com.zhifubao;

import android.annotation.TargetApi;
import android.content.Intent;
import android.icu.math.BigDecimal;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

import zhi.soft.com.zhifubao.util.DialogUtils;

public class ZhiFuActivity extends AppCompatActivity {

    private TextView desc, price, sure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhi_fu);

        desc = (TextView) findViewById(R.id.zhi_desc);
        price = (TextView) findViewById(R.id.zhi_price);
        sure = (TextView) findViewById(R.id.main_sure);

        Intent intent = getIntent();
        String price = intent.getStringExtra("price");
        String name = intent.getStringExtra("name");

        desc.setText(name+"已收到你的转账");
        setSpannableSize(price);

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DialogUtils(ZhiFuActivity.this, new DialogUtils.SureOnClickListener() {
                    @Override
                    public void OnClick() {
                        finish();
                    }
                });
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.N)
    public void setSpannableSize(String ss) {
        BigDecimal big = new BigDecimal(ss);
        DecimalFormat df = new DecimalFormat("#0.00");
        String str = df.format(big)+"元" ;
        price.setText(str);
    }
}
