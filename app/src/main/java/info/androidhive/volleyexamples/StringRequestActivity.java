package info.androidhive.volleyexamples;

import info.androidhive.volleyexamples.app.AppController;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class StringRequestActivity extends Activity {

	private String TAG = StringRequestActivity.class.getSimpleName();
	private Button btnStringReq;
	private TextView msgResponse;
	private ProgressDialog pDialog;

	// This tag will be used to cancel the request
	private String tag_string_req = "string_req";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_string);
		btnStringReq = (Button) findViewById(R.id.btnStringReq);
		msgResponse = (TextView) findViewById(R.id.msgResponse);
		pDialog = new ProgressDialog(this);
		pDialog.setMessage("Loading...");
		pDialog.setCancelable(false);
		btnStringReq.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
                String[] Url = new String[]{
                        "https://abcnews.go.com"
                        , "http://www.abc.net.au/news"
                        , "https://www.aftenposten.no"
                        , "http://www.aljazeera.com"
                        , "http://www.ansa.it"
                        , "http://www.argaam.com"
                        , "http://arstechnica.com"
                        , "https://arynews.tv/ud/"
                        , "https://apnews.com/"
                        , "http://www.afr.com"
                        , "https://www.axios.com"
                        , "http://www.bbc.co.uk/news"
                        , "http://www.bbc.co.uk/sport"
                        , "http://www.bild.de"
                        , "https://br.blastingnews.com"
                        , "http://www.bleacherreport.com"
                        , "http://www.bloomberg.com"
                        , "http://www.breitbart.com"
                        , "http://www.businessinsider.com"
                        , "http://uk.businessinsider.com"
                        , "http://www.abc.net.au/news"
                        , "https://www.aftenposten.no"
                        , "http://www.aljazeera.com"
                        , "http://www.ansa.it"
                        , "http://www.argaam.com"
                        , "http://arstechnica.com"
                        , "https://arynews.tv/ud/"
                        , "https://apnews.com/"
                        , "http://www.afr.com"
                        , "https://www.axios.com"
                        , "http://www.bbc.co.uk/news"
                        , "http://www.bbc.co.uk/sport"
                        , "http://www.bild.de"
                        , "https://br.blastingnews.com"
                        , "http://www.bleacherreport.com"
                        , "http://www.bloomberg.com"
                        , "http://www.breitbart.com"
                        , "http://www.businessinsider.com"
                        , "http://uk.businessinsider.com"
                        , "http://www.abc.net.au/news"
                        , "https://www.aftenposten.no"
                        , "http://www.aljazeera.com"
                        , "http://www.ansa.it"
                        , "http://www.argaam.com"
                        , "http://arstechnica.com"
                        , "https://arynews.tv/ud/"
                        , "https://apnews.com/"
                        , "http://www.afr.com"
                        , "https://www.axios.com"
                        , "http://www.bbc.co.uk/news"
                        , "http://www.bbc.co.uk/sport"
                        , "http://www.bild.de"
                        , "https://br.blastingnews.com"
                        , "http://www.bleacherreport.com"
                        , "http://www.bloomberg.com"
                        , "http://www.breitbart.com"
                        , "http://www.businessinsider.com"
                        , "http://uk.businessinsider.com"
                        , "http://www.abc.net.au/news"
                        , "https://www.aftenposten.no"
                        , "http://www.aljazeera.com"
                        , "http://www.ansa.it"
                        , "http://www.argaam.com"
                        , "http://arstechnica.com"
                        , "https://arynews.tv/ud/"
                        , "https://apnews.com/"
                        , "http://www.afr.com"
                        , "https://www.axios.com"
                        , "http://www.bbc.co.uk/news"
                        , "http://www.bbc.co.uk/sport"
                        , "http://www.bild.de"
                        , "https://br.blastingnews.com"
                        , "http://www.bleacherreport.com"
                        , "http://www.bloomberg.com"
                        , "http://www.breitbart.com"
                        , "http://www.businessinsider.com"
                        , "http://uk.businessinsider.com"
                        , "http://www.abc.net.au/news"
                        , "https://www.aftenposten.no"
                        , "http://www.aljazeera.com"
                        , "http://www.ansa.it"
                        , "http://www.argaam.com"
                        , "http://arstechnica.com"
                        , "https://arynews.tv/ud/"
                        , "https://apnews.com/"
                        , "http://www.afr.com"
                        , "https://www.axios.com"
                        , "http://www.bbc.co.uk/news"
                        , "http://www.bbc.co.uk/sport"
                        , "http://www.bild.de"
                        , "https://br.blastingnews.com"
                        , "http://www.bleacherreport.com"
                        , "http://www.bloomberg.com"
                        , "http://www.breitbart.com"
                        , "http://www.businessinsider.com"
                        , "http://uk.businessinsider.com"
                        , "http://www.abc.net.au/news"
                        , "https://www.aftenposten.no"
                        , "http://www.aljazeera.com"
                        , "http://www.ansa.it"
                        , "http://www.argaam.com"
                        , "http://arstechnica.com"
                        , "https://arynews.tv/ud/"
                        , "https://apnews.com/"
                        , "http://www.afr.com"
                        , "https://www.axios.com"
                        , "http://www.bbc.co.uk/news"
                        , "http://www.bbc.co.uk/sport"
                        , "http://www.bild.de"
                        , "https://br.blastingnews.com"
                        , "http://www.bleacherreport.com"
                        , "http://www.bloomberg.com"
                        , "http://www.breitbart.com"
                        , "http://www.businessinsider.com"
                        , "http://uk.businessinsider.com"
                        , "http://www.abc.net.au/news"
                        , "https://www.aftenposten.no"
                        , "http://www.aljazeera.com"
                        , "http://www.ansa.it"
                        , "http://www.argaam.com"
                        , "http://arstechnica.com"
                        , "https://arynews.tv/ud/"
                        , "https://apnews.com/"
                        , "http://www.afr.com"
                        , "https://www.axios.com"
                        , "http://www.bbc.co.uk/news"
                        , "http://www.bbc.co.uk/sport"
                        , "http://www.bild.de"
                        , "https://br.blastingnews.com"
                        , "http://www.bleacherreport.com"
                        , "http://www.bloomberg.com"
                        , "http://www.breitbart.com"
                        , "http://www.businessinsider.com"
                        , "http://uk.businessinsider.com"
                        , "http://www.abc.net.au/news"
                        , "https://www.aftenposten.no"
                        , "http://www.aljazeera.com"
                        , "http://www.ansa.it"
                        , "http://www.argaam.com"
                        , "http://arstechnica.com"
                        , "https://arynews.tv/ud/"
                        , "https://apnews.com/"
                        , "http://www.afr.com"
                        , "https://www.axios.com"
                        , "http://www.bbc.co.uk/news"
                        , "http://www.bbc.co.uk/sport"
                        , "http://www.bild.de"
                        , "https://br.blastingnews.com"
                        , "http://www.bleacherreport.com"
                        , "http://www.bloomberg.com"
                        , "http://www.breitbart.com"
                        , "http://www.businessinsider.com"
                        , "http://uk.businessinsider.com"
                        , "http://www.abc.net.au/news"
                        , "https://www.aftenposten.no"
                        , "http://www.aljazeera.com"
                        , "http://www.ansa.it"
                        , "http://www.argaam.com"
                        , "http://arstechnica.com"
                        , "https://arynews.tv/ud/"
                        , "https://apnews.com/"
                        , "http://www.afr.com"
                        , "https://www.axios.com"
                        , "http://www.bbc.co.uk/news"
                        , "http://www.bbc.co.uk/sport"
                        , "http://www.bild.de"
                        , "https://br.blastingnews.com"
                        , "http://www.bleacherreport.com"
                        , "http://www.bloomberg.com"
                        , "http://www.breitbart.com"
                        , "http://www.businessinsider.com"
                        , "http://uk.businessinsider.com"
                        , "http://www.abc.net.au/news"
                        , "https://www.aftenposten.no"
                        , "http://www.aljazeera.com"
                        , "http://www.ansa.it"
                        , "http://www.argaam.com"
                        , "http://arstechnica.com"
                        , "https://arynews.tv/ud/"
                        , "https://apnews.com/"
                        , "http://www.afr.com"
                        , "https://www.axios.com"
                        , "http://www.bbc.co.uk/news"
                        , "http://www.bbc.co.uk/sport"
                        , "http://www.bild.de"
                        , "https://br.blastingnews.com"
                        , "http://www.bleacherreport.com"
                        , "http://www.bloomberg.com"
                        , "http://www.breitbart.com"
                        , "http://www.businessinsider.com"
                        , "http://uk.businessinsider.com"
                        , "http://www.abc.net.au/news"
                        , "https://www.aftenposten.no"
                        , "http://www.aljazeera.com"
                        , "http://www.ansa.it"
                        , "http://www.argaam.com"
                        , "http://arstechnica.com"
                        , "https://arynews.tv/ud/"
                        , "https://apnews.com/"
                        , "http://www.afr.com"
                        , "https://www.axios.com"
                        , "http://www.bbc.co.uk/news"
                        , "http://www.bbc.co.uk/sport"
                        , "http://www.bild.de"
                        , "https://br.blastingnews.com"
                        , "http://www.bleacherreport.com"
                        , "http://www.bloomberg.com"
                        , "http://www.breitbart.com"
                        , "http://www.businessinsider.com"
                        , "http://uk.businessinsider.com"
                        , "http://www.abc.net.au/news"
                        , "https://www.aftenposten.no"
                        , "http://www.aljazeera.com"
                        , "http://www.ansa.it"
                        , "http://www.argaam.com"
                        , "http://arstechnica.com"
                        , "https://arynews.tv/ud/"
                        , "https://apnews.com/"
                        , "http://www.afr.com"
                        , "https://www.axios.com"
                        , "http://www.bbc.co.uk/news"
                        , "http://www.bbc.co.uk/sport"
                        , "http://www.bild.de"
                        , "https://br.blastingnews.com"
                        , "http://www.bleacherreport.com"
                        , "http://www.bloomberg.com"
                        , "http://www.breitbart.com"
                        , "http://www.businessinsider.com"
                        , "http://uk.businessinsider.com"
                        , "http://www.abc.net.au/news"
                        , "https://www.aftenposten.no"
                        , "http://www.aljazeera.com"
                        , "http://www.ansa.it"
                        , "http://www.argaam.com"
                        , "http://arstechnica.com"
                        , "https://arynews.tv/ud/"
                        , "https://apnews.com/"
                        , "http://www.afr.com"
                        , "https://www.axios.com"
                        , "http://www.bbc.co.uk/news"
                        , "http://www.bbc.co.uk/sport"
                        , "http://www.bild.de"
                        , "https://br.blastingnews.com"
                        , "http://www.bleacherreport.com"
                        , "http://www.bloomberg.com"
                        , "http://www.breitbart.com"
                        , "http://www.businessinsider.com"
                        , "http://uk.businessinsider.com"
                        , "http://www.abc.net.au/news"
                        , "https://www.aftenposten.no"
                        , "http://www.aljazeera.com"
                        , "http://www.ansa.it"
                        , "http://www.argaam.com"
                        , "http://arstechnica.com"
                        , "https://arynews.tv/ud/"
                        , "https://apnews.com/"
                        , "http://www.afr.com"
                        , "https://www.axios.com"
                        , "http://www.bbc.co.uk/news"
                        , "http://www.bbc.co.uk/sport"
                        , "http://www.bild.de"
                        , "https://br.blastingnews.com"
                        , "http://www.bleacherreport.com"
                        , "http://www.bloomberg.com"
                        , "http://www.breitbart.com"
                        , "http://www.businessinsider.com"
                        , "http://uk.businessinsider.com"
                };
                 // mMyTask = new DownloadTask().execute(URLS);
                 // makeStringReq("https://abcnews.go.com");

                Log.i("GetLength: ", "" + Url.length);
                String test ="";
                for (int i = 0; i < Url.length; i++) {
                   test =GetDocument0(Url[i].toString());
                    Log.i("Get_0 : ", "" + GetDocument0(Url[i]).toString());
                   // System.out.println(Arrays.deepToString(new String[]{Url[i]}));
                    Log.i("GetI: ", "" + i);
                }
			  //makeStringReq();
			}
		});
	 }

	private void showProgressDialog(){
		if (!pDialog.isShowing())
			pDialog.show();
	}

	private void hideProgressDialog(){
		if (pDialog.isShowing())
			pDialog.hide();
	}

    public String GetDocument0(String site) {
        final String[] items = {""};
        return String.valueOf(new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... voids) {
                String insideString = voids[0];

                StringBuffer buffer = new StringBuffer();
                try {
                    Document doc1 = Jsoup.connect(insideString).get();
                    //Elements img = doc1.getElementsByTag("img");
                    Elements img2 = doc1.getElementsByTag("meta");
                    for (Element element : img2) {
                        if ("og:image".equals(element.attr("property"))) {
                            // System.out.println(element.attr("content"));
                             //Log.i("trace : ", "" + element.attr("content"));
                            items[0] = element.attr("content");
                        }
                    }
                   } catch (IOException e) {
                }
                return items[0];
            }
        }.execute(site));
    }










    /////////
    private void makeStringReq(String s){
        showProgressDialog();
        StringRequest strReq = new StringRequest(Method.GET , s, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
              /*
              try{
                 Document doc = Jsoup.connect("https://abcnews.go.com").get();
                  Elements links = doc.getElementsByTag("meta");
                   for(Element link : links) {
                      if("og:image".equals(link.attr("property"))) {
                       String src = link.attr("content");
                        Log.i("getUrlImage0:", ""+src);
                         }
                     }
                 } catch (IOException e) {
              }
              */
                // Log.i("lOGaHMED", response.toString());
                //  msgResponse.setText(response.toString());
                hideProgressDialog();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error00: " + error.getMessage());
                hideProgressDialog();
            }
        });
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq , tag_string_req);
    }


    private static RequestQueue myRequestQueue = null;
    //https://stackoverflow.com/questions/35674580/how-to-use-jsoup-with-volley/35695852#35695852
    public Document GetDocument(String site) throws Exception {
        final Document[] doc = new Document[1];
        //final CountDownLatch cdl = new CountDownLatch(1);

        StringRequest documentRequest = new StringRequest( Request.Method.GET, site, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                doc[0] = (Document) Jsoup.connect(response);
                //  cdl.countDown();
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error",""+error);
                // System.out.println("Houston we have a problem ... !");
                // error.printStackTrace();
            }
        } //
        );
        if (myRequestQueue == null) {
            myRequestQueue = Volley.newRequestQueue(this);
        }
        // Add the request to the queue...
        myRequestQueue.add(documentRequest);
        // ... and wait for the document.
        // NOTE: Be aware of user experience here. We don't want to freeze the app...
        // cdl.await();
        return doc[0];
    }


	 /*
	private void makeStringReq(){
	 showProgressDialog();
		StringRequest strReq = new StringRequest(Method.GET , Const.URL_STRING_REQ , new Response.Listener<String>() {
		@Override
		public void onResponse(String response) {
			 Log.i("lOGaHMED", response.toString());
				msgResponse.setText(response.toString());
				hideProgressDialog();
			  }
			}, new Response.ErrorListener() {
				@Override
				public void onErrorResponse(VolleyError error) {
				 VolleyLog.d(TAG, "Error00: " + error.getMessage());
				 hideProgressDialog();
				}
			});
		// Adding request to request queue
	 AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
	}
	*/

}

