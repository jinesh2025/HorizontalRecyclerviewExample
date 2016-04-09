package in.techcure.horizontalrecyclerviewexample;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static RecyclerView.Adapter mAdapter;
    private static RecyclerView mRecyclerView;
    static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity=MainActivity.this;

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

        ArrayList<String> lists = new ArrayList<>();
        lists.add("Jinesh");
        lists.add("ZIl");
        lists.add("500");
        lists.add("Jinesh");
        lists.add("ZIl");
        lists.add("500");
        lists.add("Jinesh");
        lists.add("ZIl");
        lists.add("500");

        mAdapter = new MyRecyclerViewAdapter(lists);
        mRecyclerView.setAdapter(mAdapter);
    }

    public static class MyRecyclerViewAdapter extends RecyclerView
            .Adapter<MyRecyclerViewAdapter
            .DataObjectHolder> {
        private String LOG_TAG = "MyRecyclerViewAdapter";
        private ArrayList<String> mDataset;
        private MyClickListener myClickListener;

        public MyRecyclerViewAdapter(ArrayList<String> myDataset) {
            mDataset = myDataset;
        }


        public void setOnItemClickListener(MyClickListener myClickListener) {
            this.myClickListener = myClickListener;
        }

        @Override
        public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recyclerview_product, parent, false);

            DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
            return dataObjectHolder;
        }

        @Override
        public void onBindViewHolder(DataObjectHolder holder, final int position) {
            holder.iv.setColorFilter(Color.RED);
            holder.iv.setImageResource(R.mipmap.ic_launcher);
            holder.count.setText(mDataset.get(position));

        }

        public void addItem(String dataObj, int index) {
            mDataset.add(dataObj);
            notifyItemInserted(index);
        }

        public void deleteItem(int index) {
            mDataset.remove(index);
            notifyItemRemoved(index);
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }

        public interface MyClickListener {
            //public void onItemClick(int position, View v);
        }

        public class DataObjectHolder extends RecyclerView.ViewHolder {
            //TextView label;
            TextView count;
            ImageView iv;

            public DataObjectHolder(View itemView) {
                super(itemView);
                //label = (TextView) itemView.findViewById(R.id.textView);
                count = (TextView) itemView.findViewById(R.id.textView2);
                iv = (ImageView) itemView.findViewById(R.id.iv_product);
                Log.i(LOG_TAG, "Adding Listener");

            }


        }
    }
}
