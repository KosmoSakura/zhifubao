package zhi.soft.com.zhifubao.util;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.TextAppearanceSpan;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Description:字符统一处理工具类
 * <p>
 * Author: Kosmos
 * Time: 2017/2/28 002816:14
 * Email:ZeroProject@foxmail.com
 * Events:
 */
public class TxtTools {

    /**
     * @param bodyHTML 富文本字符
     *                 function：格式化字符，显示字符为浅灰色
     */
    public static String getHtmlData(String bodyHTML) {

        String head = "<head>" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> " +
            "<style>img{max-width: 100%; width:auto; height:auto;}</style>" +
            "</head>";
        return "<html>" + head + "<body>" + bodyHTML + "</body></html>";
    }

    public static void setSpannableSize(BigDecimal big, TextView tv) {
        DecimalFormat df = new DecimalFormat("#0.00");
        String str = "¥\b" + df.format(big);
        int lengh = str.length();
        if (lengh - 2 < 0) {
            return;
        }

        int size = (int) tv.getTextSize()-8;

        SpannableString styledText = new SpannableString(str);
        styledText.setSpan(new TextAppearanceSpan(null, 0, size, tv.getTextColors(), null), lengh - 2, lengh, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        tv.setText(styledText);
    }
}
