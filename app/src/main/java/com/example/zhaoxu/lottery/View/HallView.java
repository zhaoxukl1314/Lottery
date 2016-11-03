package com.example.zhaoxu.lottery.View;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhaoxu.lottery.Contant.ConstantValue;
import com.example.zhaoxu.lottery.Engine.CommonInfoEngine;
import com.example.zhaoxu.lottery.Net.protocal.Element;
import com.example.zhaoxu.lottery.Net.protocal.Message;
import com.example.zhaoxu.lottery.Net.protocal.element.CurrentIssueElement;
import com.example.zhaoxu.lottery.Net.protocal.element.Oelement;
import com.example.zhaoxu.lottery.R;
import com.example.zhaoxu.lottery.Utils.BeanFactory;
import com.example.zhaoxu.lottery.Utils.NetUtils;
import com.example.zhaoxu.lottery.Utils.PromptManager;
import com.example.zhaoxu.lottery.View.manager.MiddleManager;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by zhaoxukl1314 on 16/10/31.
 */

public class HallView extends BaseUI {

    private TextView mSsqIssue;
    private ImageView mSsqBet;
    private int[] logoResIds = new int[] {R.mipmap.id_ssq,R.mipmap.id_3d,R.mipmap.id_qlc};
    private int[] titleResIds = new int[] {R.string.is_hall_ssq_title, R.string.is_hall_3d_title, R.string.is_hall_qlc_title};

    public HallView(Context mContext) {
        super(mContext);

    }

    protected void setListener() {
        mSsqBet.setOnClickListener(this);
    }

    protected void initView() {
        mMiddleHall = (LinearLayout) View.inflate(mContext, R.layout.il_hall1, null);

        ListView categoryList = new ListView(mContext);

        mSsqIssue = (TextView) findViewById(R.id.ii_hall_ssq_summary);
        mSsqBet = (ImageView) findViewById(R.id.ii_hall_ssq_bet);
    }

    @Override
    public int getId() {
        return ConstantValue.VIEW_HALL;
    }

    @Override
    public void onClick(View v) {

    }

    public void getCurrentIssueInfo() {
        new MyHttpTask<Integer>() {

            @Override
            protected Message doInBackground(Integer... params) {
                CommonInfoEngine engine = BeanFactory.getImpl(CommonInfoEngine.class);
                return engine.getCurrentIssueInfo(params[0]);
            }

            @Override
            protected void onPostExecute(Message message) {
                if (message != null) {
                    Oelement oelement = message.getBody().getOelement();
                    if (ConstantValue.SUCCESS.equals(oelement.getErrorcode())) {
                        changeNotice(message.getBody().getElements().get(0));
                    } else {
                        PromptManager
                                .showToast(mContext, oelement.getErrormsg());
                    }
                } else {
                    PromptManager.showToast(mContext,"服务器忙,请稍后重试");
                }
                super.onPostExecute(message);
            }
        }.executeProxy(ConstantValue.SSQ);
    }

    /**
     * 修改界面提示信息
     *
     * @param element
     */
    protected void changeNotice(Element element) {
        CurrentIssueElement currentIssueElement = (CurrentIssueElement) element;
        String issue = "aa";
        String lasttime = "bb";
        // 第ISSUE期 还有TIME停售
        String text = mContext.getResources().getString(
                R.string.is_hall_common_summary);
        text = StringUtils.replaceEach(text, new String[] { "ISSUE", "TIME" },
                new String[] { issue, lasttime });

        mSsqIssue.setText(text);

    }

    /**
     * 将秒时间转换成日时分格式
     *
     * @param lasttime
     * @return
     */
    public String getLasttime(String lasttime) {
        StringBuffer result = new StringBuffer();
        if (StringUtils.isNumericSpace(lasttime)) {
            int time = Integer.parseInt(lasttime);
            int day = time / (24 * 60 * 60);
            result.append(day).append("天");
            if (day > 0) {
                time = time - day * 24 * 60 * 60;
            }
            int hour = time / 3600;
            result.append(hour).append("时");
            if (hour > 0) {
                time = time - hour * 60 * 60;
            }
            int minute = time / 60;
            result.append(minute).append("分");
        }
        return result.toString();
    }

    private class CategoryAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(mContext,R.layout.il_hall_lottery_item,null);
                holder.logo = (ImageView) convertView.findViewById(R.id.ii_hall_lottery_logo);
                holder.title = (TextView) convertView.findViewById(R.id.ii_hall_lottery_title);
                holder.summary = (TextView) convertView.findViewById(R.id.ii_hall_lottery_summary);
                holder.bet = (ImageView) convertView.findViewById(R.id.ii_hall_lottery_bet);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.logo.setImageResource(logoResIds[position]);
            holder.title.setText(titleResIds[position]);
            holder.summary.setTag(position);
            holder.bet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position == 0) {
                    }
                }
            });
            return null;
        }
    }

    private class ViewHolder {
        ImageView logo;
        TextView title;
        TextView summary;
        ImageView bet;
    }
}
