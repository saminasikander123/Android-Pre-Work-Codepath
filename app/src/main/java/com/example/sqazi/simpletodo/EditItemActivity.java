package com.example.sqazi.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    private EditText etEditedItemText;
    private Integer itemPosInArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etEditedItemText = (EditText) findViewById(R.id.etMultiEditText);
        String itemText = getIntent().getStringExtra("itemText");
        itemPosInArray = getIntent().getIntExtra("itemPosition", 0);

        etEditedItemText.setText(itemText);
        etEditedItemText.setSelection(itemText.length());
    }

    public void onSaveItem(View v) {
        Intent i = new Intent();
        i.putExtra("itemText", etEditedItemText.getText().toString());
        i.putExtra("itemPosition", itemPosInArray);
        setResult(RESULT_OK, i);
        finish();
    }

}
