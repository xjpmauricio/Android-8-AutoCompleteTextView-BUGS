package net.gottsolutions.android8tests.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import net.gottsolutions.android8tests.R;
import net.gottsolutions.android8tests.models.GenericDataSourceItem;

import java.util.ArrayList;
import java.util.List;

public class ComboAdapter extends ArrayAdapter<GenericDataSourceItem> {

    private final List<GenericDataSourceItem> mValues;
    private final List<GenericDataSourceItem> mValues_All;
    private final List<GenericDataSourceItem> mValues_Suggestions;
    private Context mContext;

    public ComboAdapter(Context context, List<GenericDataSourceItem> values) {
        super(context, 0, values);

        mContext = context;

        this.mValues = new ArrayList<>(values);
        this.mValues_All = new ArrayList<>(values);
        this.mValues_Suggestions = new ArrayList<>();
    }

    public int getCount() {
        return mValues.size();
    }

    public GenericDataSourceItem getItem(int position) {
        return mValues.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.simple_dropdown_item_1line, parent, false);
        }

        if (convertView != null && convertView instanceof TextView) {
            GenericDataSourceItem item = getItem(position);
            ((TextView) convertView).setText(item.getKey());
        }

        return convertView;
    }

    @Override
    public Filter getFilter() {

        return new Filter() {

            @Override
            public String convertResultToString(Object resultValue) {

                return ((GenericDataSourceItem) resultValue).getKey();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                if (constraint != null) {

                    mValues_Suggestions.clear();

                    for (GenericDataSourceItem station : mValues_All) {

                        if (station.getKey().toLowerCase().contains(constraint.toString().toLowerCase())) {

                            mValues_Suggestions.add(station);
                        }
                    }

                    FilterResults filterResults = new FilterResults();
                    filterResults.values = mValues_Suggestions;
                    filterResults.count = mValues_Suggestions.size();

                    return filterResults;

                } else {

                    return new FilterResults();
                }
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                mValues.clear();

                if (results != null && results.count > 0) {

                    List<?> result = (List<?>) results.values;
                    for (Object object : result) {
                        if (object instanceof GenericDataSourceItem) {
                            mValues.add((GenericDataSourceItem) object);
                        }
                    }

                } else if (constraint == null) {

                    // no filter, add entire original list back in
                    mValues.addAll(mValues_All);
                }

                notifyDataSetChanged();
            }
        };
    }


}
