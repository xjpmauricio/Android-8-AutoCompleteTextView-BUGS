package net.gottsolutions.android8tests;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;

import net.gottsolutions.android8tests.adapters.ComboAdapter;
import net.gottsolutions.android8tests.models.GenericDataSourceItem;
import net.gottsolutions.android8tests.widgets.CustomAutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView0;
    AutoCompleteTextView autoCompleteTextView1;
    AutoCompleteTextView autoCompleteTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set window to adjustPan
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        autoCompleteTextView0 = findViewById(R.id.autocompletetextview0);
        autoCompleteTextView1 = findViewById(R.id.autocompletetextview1);
        autoCompleteTextView2 = findViewById(R.id.autocompletetextview2);

        // Create the data source items
        List<GenericDataSourceItem> items = new ArrayList<>();
        for (int n = 0; n < 3; n++) {
            GenericDataSourceItem item = new GenericDataSourceItem();
            item.setValue(n);
            item.setKey("item " + n);
            items.add(item);
        }

        bindCombo(autoCompleteTextView0, items);
        bindCombo(autoCompleteTextView1, items);
        bindCombo(autoCompleteTextView2, items);
    }

    private void bindCombo(final AutoCompleteTextView autoCompleteTextView, List<GenericDataSourceItem> items) {
        try {

            autoCompleteTextView.setThreshold(1);

            ComboAdapter mComboAdapter = new ComboAdapter(this, items);
            autoCompleteTextView.setAdapter(mComboAdapter);

            autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    if (parent.getItemAtPosition(position) instanceof GenericDataSourceItem) {

                        GenericDataSourceItem item = (GenericDataSourceItem) parent.getItemAtPosition(position);

                        if (item != null) {

                        }
                    }
                }
            });

            TextWatcher mTextWatcher = new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {

                    String str = autoCompleteTextView.getText().toString();

                    if (str != null) {

                    }
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }
            };

            autoCompleteTextView.addTextChangedListener(mTextWatcher);


        } catch (Exception ex) {
            if (ex != null) {

            }
        }
    }


}
