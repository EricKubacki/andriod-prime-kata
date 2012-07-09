package com.pillartechnology;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PrimeKata extends Activity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    Button getValues = (Button) findViewById(R.id.getValues);
    getValues.setOnClickListener(new Primes());

  }

  private class Primes implements OnClickListener {

    @Override
    public void onClick(View view) {
      View rootView = view.getRootView();
      Integer value = getValueToCalculatePrimesOf(rootView);
      List<Integer> primes = caculatePrimes(value);
      printValues(rootView, primes);
    }

    private Integer getValueToCalculatePrimesOf(View rootView) {
      EditText getPrimesOf = (EditText) rootView.findViewById(R.id.takePrimeOf);
      return Integer.valueOf(getPrimesOf.getText().toString());
    }

    private void printValues(View rootView, List<Integer> primes) {
      TextView results= (TextView)rootView.findViewById(R.id.result);
      StringBuffer output = new StringBuffer("");
      for (Integer primeValue : primes) {
        output.append(primeValue).append(",");
      }
      if(output.lastIndexOf(",") != -1) {
        output.replace(output.lastIndexOf(","), output.length(), "");
      }
      results.setText(output);
    }

    private List<Integer> caculatePrimes(Integer value) {
      List<Integer> primes = new ArrayList<Integer>();

      for (int candidate = 2; value > 1; candidate++) {
        for (; value%candidate == 0; value /=candidate) {
          primes.add(candidate);
        }
      }
      return primes;
    }
  }
}
