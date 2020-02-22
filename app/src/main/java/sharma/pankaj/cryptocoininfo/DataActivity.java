package sharma.pankaj.cryptocoininfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Date;

public class DataActivity extends AppCompatActivity {

    TextView lu, pud, pbtc, hvu, mcu, as, ts, ms, ci1h, ci24h, ci7d, name;
    ImageView img;
    String st, Data;
    FetchData fd = new FetchData();
    FloatingActionButton floatingActionButton;
    Spinner spinner;
    String testUrl;
    String country[] = {"CURRENCY", "AUD", "BRL", "CAD", "CHF", "CLP", "CNY", "CZK", "DKK", "EUR", "GBP", "HKD",
            "HUF", "IDR", "ILS", "INR", "JPY", "KRW", "MXN", "MYR", "NOK", "NZD", "PHP",
            "PKR", "PLN", "RUB", "SEK", "SGD", "THB", "TRY", "TWD", "ZAR"};
    IconChecker icr = new IconChecker();

    String coinData, countrycurrency;
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    public static final String coin = "coin1";
    public static final String currency = "currency1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        name = (TextView) findViewById(R.id.cname);
        img = (ImageView) findViewById(R.id.icon);
        lu = (TextView) findViewById(R.id.lu);
        pud = (TextView) findViewById(R.id.pud);
        pbtc = (TextView) findViewById(R.id.pbtc);
        hvu = (TextView) findViewById(R.id.hvu);
        mcu = (TextView) findViewById(R.id.mcu);
        as = (TextView) findViewById(R.id.as);
        ts = (TextView) findViewById(R.id.ts);
        ms = (TextView) findViewById(R.id.ms);
        ci1h = (TextView) findViewById(R.id.ci1h);
        ci24h = (TextView) findViewById(R.id.ci24h);
        ci7d = (TextView) findViewById(R.id.ci7d);
        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(aa);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (country[position].equals("CURRENCY")) {
                } else {
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString(currency, country[position]);
                    editor.apply();
                    new AsyncTaskRunner().execute();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        st = (String) getIntent().getStringExtra("POS");

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(coin, st);

        if (sharedpreferences.contains(currency)) {
            countrycurrency = sharedpreferences.getString(currency, "");
            if (countrycurrency.equals("")) {
                editor.putString(currency, "AUD");
            }
            Toast.makeText(this, "Currency Data " + countrycurrency, Toast.LENGTH_SHORT).show();
        }
        editor.apply();

        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        new AsyncTaskRunner().execute();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTaskRunner().execute();
            }
        });
    }

    protected class AsyncTaskRunner extends AsyncTask<String, String, String> {
        ProgressDialog progressDialog;
        String mUrl;

        @Override
        protected String doInBackground(String... strings) {
            //Log.d("Error", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            try {
                sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
                if (sharedpreferences.contains(coin)) {
                    coinData = sharedpreferences.getString(coin, "");
                }
                if (sharedpreferences.contains(currency)) {
                    countrycurrency = sharedpreferences.getString(currency, "");

                }
                fd.getURLContent("https://api.coinmarketcap.com/v1/ticker/" + coinData + "/?convert=" + countrycurrency + "");
                Data = fd.getString;
            } catch (Exception e) {
                Log.d("Error", "Fetched Data" + e);
            }
            return Data;
        }

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(DataActivity.this, "ProgressDialog", "Wait for seconds");
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            JSONObject data;
            JSONArray js;
            try {
                if (Data != null) {
                    js = new JSONArray(Data);
                    for (int i = 0; i < js.length(); i++) {
                        DateFormat df = DateFormat.getDateTimeInstance();
                        data = js.getJSONObject(i);
                        name.setText(data.getString("name"));
                        lu.setText("" + df.format(new Date(data.getLong("last_updated") * 1000)));
                        pud.setText(data.getString("price_usd"));
                        pbtc.setText(data.getString("price_btc"));
                        hvu.setText(data.getString("24h_volume_usd"));
                        mcu.setText(data.getString("market_cap_usd"));
                        as.setText(data.getString("available_supply"));
                        ts.setText(data.getString("total_supply"));
                        ms.setText(data.getString("max_supply"));
                        ci1h.setText(data.getString("percent_change_1h"));
                        ci24h.setText(data.getString("percent_change_24h"));
                        ci7d.setText(data.getString("percent_change_7d"));
                        icr.getIconCurrency(data.getString("id").toUpperCase());
                        img.setImageDrawable(ContextCompat.getDrawable(DataActivity.this, icr.iconLocation));

                        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
                        if (sharedpreferences.contains(coin)) {
                            coinData = sharedpreferences.getString(coin, "");
                        }
                        if (sharedpreferences.contains(currency)) {
                            countrycurrency = sharedpreferences.getString(currency, "");

                        }
                        Toast.makeText(DataActivity.this, "" + coinData + "  " + countrycurrency, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DataActivity.this, "Check Your Internet Connetion", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception r) {
                Toast.makeText(DataActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
