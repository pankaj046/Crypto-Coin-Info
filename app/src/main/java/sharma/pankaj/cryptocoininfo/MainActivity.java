package sharma.pankaj.cryptocoininfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView mAuto;
    RecyclerView mRecyclerView;

    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    ArrayList<String> almName;
    ArrayList<String> almPrice;
    ArrayList<String> almlupdate;
    ArrayList<Integer> alImage;
    ArrayList<String> alId;
    FetchData fd = new FetchData();
    String limiturl;
    String Data;

    boolean dataurl = true;
    String currency;
    int a = 0, x = 0;

    IconChecker icr = new IconChecker();
    String[] CoinId = {"BITCOIN", "ETHEREUM", "RIPPLE", "BITCOIN-CASH", "LITECOIN", "CARDANO", "NEO",
            "STELLAR", "EOS", "IOTA", "DASH", "NEM", "MONERO", "LISK", "TRON", "ETHEREUM-CLASSIC",
            "VECHAIN", "QTUM", "BITCOIN-GOLD", "TETHER", "ICON", "OMISEGO", "ZCASH", "RAIBLOCKS",
            "VERGE", "BINANCE-COIN", "STEEM", "POPULOUS", "BYTECOIN-BCN", "SIACOIN", "STRATIS",
            "RCHAIN", "STATUS", "DOGECOIN", "WAVES", "BITSHARES", "MAKER", "WALTON", "0X", "UCASH",
            "DECRED", "AETERNITY", "AUGUR", "VERITASEUM", "HSHARE", "KOMODO", "ZCLASSIC",
            "ELECTRONEUM", "KUCOIN-SHARES", "ARDOR", "DIGIBYTE", "REVAIN", "ARK", "DIGIXDAO", "DRAGONCHAIN",
            "GAS", "BASIC-ATTENTION-TOKEN", "BYTEBALL", "ZILLIQA", "LOOPRING", "GOLEM-NETWORK-TOKENS", "BYTOM",
            "KYBER-NETWORK", "MONACOIN", "SYSCOIN", "PIVX", "AELF", "QASH", "CRYPTONEX", "DENTACOIN",
            "AION", "BITCORE", "NEBULAS-TOKEN", "IOSTOKEN", "ETHOS", "FACTOM", "POWER-LEDGER",
            "GXSHARES", "PILLAR", "SALT", "FUNFAIR", "DENT", "KIN", "CINDICATOR", "NXT", "ZCOIN",
            "ENIGMA-PROJECT", "POLYMATH-NETWORK", "CHAINLINK", "REDDCOIN", "NEBLIO", "MAIDSAFECOIN",
            "REQUEST-NETWORK", "PARTICL", "BANCOR", "QUANTSTAMP", "TENX", "WAX", "SMARTCASH", "BLOCKNET"};


    ImageButton imageButton;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuto = (AutoCompleteTextView) findViewById(R.id.auto);
        //new AsyncTaskRunner().execute();
        String[] cuntrycode = getResources().getStringArray(R.array.currency_code);
        mAuto.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, cuntrycode));

        mRecyclerView = (RecyclerView) findViewById(R.id.recycle);
        mRecyclerView.setHasFixedSize(true);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        imageButton = findViewById(R.id.imageButton);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1 = mAuto.getText().toString().trim();
                int m = -1;
                for (int i = 0; i < CoinId.length; i++) {
                    if (value1.equals(CoinId[i])) {
                        m = i;
                    }
                }
                if (m != -1) {
                    Intent intent = new Intent(MainActivity.this, DataActivity.class);
                    intent.putExtra("POS", CoinId[m]);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Please Choose Suggested Value ", Toast.LENGTH_SHORT).show();
                }


            }
        });
        new AsyncTaskRunner().execute();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = 1;
                new AsyncTaskRunner().execute();
            }
        });
    }

    protected class AsyncTaskRunner extends AsyncTask<String, String, String> {
        ProgressDialog progressDialog;
        String mUrl;

        @Override
        protected String doInBackground(String... strings) {
            try {
                //https://api.coinmarketcap.com/v1/ticker/
                fd.getURLContent("https://api.coinmarketcap.com/v1/ticker/");
                Data = fd.getString;
                a = 1;
                Toast.makeText(MainActivity.this, ""+Data, Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Log.d("Error", "Fetched Data" + e);
            }
            return Data;
        }

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(MainActivity.this, "ProgressDialog", "Wait for seconds");
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();

            almName = new ArrayList<>();
            almPrice = new ArrayList<>();
            almlupdate = new ArrayList<>();
            alImage = new ArrayList<Integer>();
            alId = new ArrayList<>();
            JSONObject data;
            JSONArray js;
            try {
                if (Data != null) {
                    js = new JSONArray(Data);
                    for (int i = 0; i < js.length(); i++) {
                        DateFormat df = DateFormat.getDateTimeInstance();
                        data = js.getJSONObject(i);
                        alId.add(data.getString("id"));
                        almName.add(data.getString("name"));
                        almPrice.add(data.getString("price_usd"));
                        String updatedOn = df.format(new Date(data.getLong("last_updated") * 1000));
                        almlupdate.add(updatedOn);
                        icr.getIconCurrency(data.getString("id").toUpperCase().trim());
                        alImage.add(icr.iconLocation);
                    }
                    System.out.println("" + alId);
                } else {
                    Toast.makeText(MainActivity.this, "Check Your Internet Connetion", Toast.LENGTH_SHORT).show();
                }

            } catch (Exception e) {
                Log.d("Error", "Fetched Data" + e);
            }
            mAdapter = new HLVAdapter(MainActivity.this, almName, almPrice, almlupdate, alImage, alId);
            mRecyclerView.setAdapter(mAdapter);
        }
    }
}
