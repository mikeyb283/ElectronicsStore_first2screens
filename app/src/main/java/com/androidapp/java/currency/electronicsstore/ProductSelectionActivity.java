package com.androidapp.java.currency.electronicsstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class ProductSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_selection);
        final Spinner tabletQty = (Spinner) findViewById(R.id.tabletSpinner);
        final Spinner phoneQty = (Spinner) findViewById(R.id.phoneSpinner);
        final Button nextButton = (Button) findViewById(R.id.nextButton);

        float tabletOrder = Integer.parseInt(tabletQty.getSelectedItem().toString());
        float phoneOrder = Integer.parseInt(phoneQty.getSelectedItem().toString());
        float orderTotal = tabletOrder + phoneOrder;

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductSelectionActivity.this, ConfigureDeviceActivity.class));
            }
        });

    }
}
