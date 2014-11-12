package com.example.apuser.listviewexample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

//just a github test
//just a second github test
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.theListView);
        MyAdapter arrayAdapter = new MyAdapter(this,
                R.layout.custom_list_item, generateData());
        listView.setAdapter(arrayAdapter);
    }

    static class Item {
        private String mtext0;
        private String mtext1;
        private String mtext2;

        public Item(String text0, String text1, String text2) {
            mtext0 = text0;
            mtext1 = text1;
            mtext2 = text2;
        }

        public String gettext0() {
            return mtext0;
        }

        public String gettext1() {
            return mtext1;
        }

        public String gettext2() {
            return mtext2;
        }
    }

    private ArrayList<Item> generateData() {
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("01/01", "India", "India"));
        items.add(new Item("02/02", "Pakistan", "Pakistan"));
        items.add(new Item("03/03", "Sri Lanka", "Sri Lanka"));
        items.add(new Item("04/04", "China", "China"));
        items.add(new Item("05/05", "Bangladesh", "Bangladesh"));
        items.add(new Item("06/06", "Afghanistan", "Afghanistan"));
        items.add(new Item("07/07", "North Korea", "North Korea"));
        items.add(new Item("08/08", "South Korea", "South Korea"));
        items.add(new Item("09/09", "Japan", "Japan"));
        return items;
    }

    static class MyAdapter extends ArrayAdapter<Item> {
        private int mResource;
        private LayoutInflater mInflater;
        public MyAdapter(Context context, int resource, ArrayList<Item> itemArrayList) {
            super(context, resource, itemArrayList);
            mResource = resource;
            mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LinearLayout linearLayout;
            linearLayout = (LinearLayout) mInflater.inflate(R.layout.timeaxis_list_item_layout, null);
            TextView tv0 = (TextView) linearLayout.findViewById(R.id.text_time);
            View customView = mInflater.inflate(mResource, linearLayout, true);
            TextView tv1 = (TextView) customView.findViewById(R.id.custom_text1);
            TextView tv2 = (TextView) customView.findViewById(R.id.custom_text2);
            tv0.setText(getItem(position).gettext0());
            tv1.setText(getItem(position).gettext1());
            tv2.setText(getItem(position).gettext2());
            return linearLayout;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
