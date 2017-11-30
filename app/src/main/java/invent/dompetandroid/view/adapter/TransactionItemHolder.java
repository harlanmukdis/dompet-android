package invent.dompetandroid.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import invent.dompetandroid.R;
import invent.dompetandroid.helper.CurrencyHelper;
import invent.dompetandroid.model.Transactions;

public class TransactionItemHolder extends RecyclerView.ViewHolder{

    private Calendar calendar;

    private ImageView icon;
    private TextView title;
    private TextView amount;
    private TextView date;
    private TextView type;

    public TransactionItemHolder(View itemView) {
        super(itemView);
        calendar = Calendar.getInstance();
        icon = (ImageView) itemView.findViewById(R.id.icon_wallet_list);
        title = (TextView) itemView.findViewById(R.id.title);
        amount = (TextView) itemView.findViewById(R.id.amount);
        date = (TextView) itemView.findViewById(R.id.time);
        type = (TextView) itemView.findViewById(R.id.type);
    }

    public void bind(Transactions model) {
        Date dates = new Date(model.getDate());
        calendar.setTime(dates);

        String data_amount = CurrencyHelper.format(model.getAmount());
        title.setText(model.getTitle());
        date.setText(format("EEE, MMM d, yy"));

        if (model.getTransaction_type() == 0){
            icon.setImageResource(R.drawable.wallet_in);
            type.setText("Pemasukan");
            amount.setText("+ " + data_amount);
        }else{
            icon.setImageResource(R.drawable.wallet_out);
            type.setText("Pengeluaran");
            amount.setText("- " + data_amount);
        }
    }

    public String format (String sdfPattern) {
        return new SimpleDateFormat(sdfPattern).format(calendar.getTime());
    }
}
