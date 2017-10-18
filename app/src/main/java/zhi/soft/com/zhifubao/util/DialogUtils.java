package zhi.soft.com.zhifubao.util;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import zhi.soft.com.zhifubao.R;


/**
 * Description:弹出统一对话框
 * <p>
 * Author: Kosmos
 * Time: 2016/10/10 0010 17:41
 * Email:ZeroProject@foxmail.com
 */
public class DialogUtils {
    private Context c;
    private Dialog upDialog;


    public DialogUtils(Context c, SureOnClickListener lis) {
        this.c = c;
        this.listener = lis;
        inits();
    }

    public interface SureOnClickListener {
        void OnClick();
    }

    private SureOnClickListener listener;

    private Button cancel, sure;

    private void inits() {
        LayoutInflater inflater = LayoutInflater.from(c);
        View view = inflater.inflate(R.layout.dialog_simple, null);
        upDialog = showAlertDialogMap(view);
        upDialog.setCanceledOnTouchOutside(false);
        upDialog.setCancelable(false);
        cancel = (Button) view.findViewById(R.id.dia_simple_cancel);
        sure = (Button) view.findViewById(R.id.dia_simple_sure);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cancel.getText().equals("我忏悔")) {
                    listener.OnClick();
                } else {
                    cancel.setText("我忏悔");
                    sure.setText("我没错");
                }
            }
        });
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sure.getText().equals("我忏悔")) {
                    listener.OnClick();
                } else {
                    cancel.setText("我没错");
                    sure.setText("我忏悔");
                }
            }
        });
        upDialog.show();
    }

    private Dialog showAlertDialogMap(View view) {
        Dialog dlg = new Dialog(c, R.style.MyDialog);
        dlg.setCancelable(true);
        dlg.show();
        dlg.setContentView(view);
        dlg.getWindow().setBackgroundDrawableResource(R.color.transparent);
        return dlg;
    }

}
