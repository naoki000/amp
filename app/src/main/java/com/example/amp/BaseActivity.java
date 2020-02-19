package com.example.amp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class BaseActivity extends AppCompatActivity
        implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected ItemButton initializeButton(int buttonId, String title) {
        Button button = findViewById(buttonId);
        button.setText(title);
        button.setOnClickListener(this);
        button.setTag(buttonId);

        ItemButton itemView = new ItemButton();
        itemView.button= button;
        itemView.title = title;
        itemView.tag = buttonId;

        return itemView;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        // should call super
    }


    /**
     * All views class for settings_item_xxx.xml.
     */
    public class ItemButton {
        public Button button;
        public String  title;
        public int tag = -1;
    }

}
