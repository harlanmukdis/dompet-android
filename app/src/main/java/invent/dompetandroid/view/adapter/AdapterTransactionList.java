package invent.dompetandroid.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import invent.dompetandroid.R;
import invent.dompetandroid.model.Transactions;

public abstract class AdapterTransactionList extends RecyclerView.Adapter<TransactionItemHolder>{
    private List<Transactions> data;

    public AdapterTransactionList(List<Transactions> data) {
        this.data = data;
    }

    @Override public TransactionItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wallet_list, parent, false);
        return new TransactionItemHolder(view);
    }

    @Override public void onBindViewHolder(TransactionItemHolder holder, int position) {
        bindHolder(holder, data.get(position));
    }

    protected abstract void bindHolder(TransactionItemHolder holder, Transactions model);

    @Override public int getItemCount() {
        return data.size();
    }
}
