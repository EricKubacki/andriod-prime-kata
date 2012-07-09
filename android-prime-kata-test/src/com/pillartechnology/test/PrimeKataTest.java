package com.pillartechnology.test;

import android.test.ActivityInstrumentationTestCase2;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pillartechnology.PrimeKata;
import com.pillartechnology.R;

public class PrimeKataTest extends ActivityInstrumentationTestCase2<PrimeKata> {

  private PrimeKata activity;

  public PrimeKataTest() {
    super(PrimeKata.class);
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    activity = getActivity();
  }

  public void testFindingPlaceUserCanTypeNumbersToTakePrimeOf() {
    assertTrue(activity.findViewById(R.id.takePrimeOf) instanceof EditText);
  }

  public void testTakePrimeOf_textSize_is48() {
    assertEquals(48f, ((EditText)activity.findViewById(R.id.takePrimeOf)).getTextSize());
  }

  public void testTakePrimeOf_hasCorrectHint() {
    assertEquals("Primes of this Value", ((EditText)activity.findViewById(R.id.takePrimeOf)).getHint());
  }

  public void testTakePrimeOf_shouldOnlyAllowNumbers() {
    assertEquals(InputType.TYPE_CLASS_NUMBER, ((EditText)activity.findViewById(R.id.takePrimeOf)).getInputType());
  }

  public void testFindingPlaceUserFindsResultsOfGettingPrimes() {
    assertTrue(activity.findViewById(R.id.result) instanceof TextView);
  }

  public void testResult_textSize_is48() {
    assertEquals(48f, ((TextView)activity.findViewById(R.id.result)).getTextSize());
  }

  public void testFindingPlaceUserFindsResultsOfGettingPrimesLabel() {
    assertTrue(activity.findViewById(R.id.resultLabel) instanceof TextView);
  }

  public void testFindingPlaceUserFindsResultsOfGettingPrimesLabel_valueIsResult() {
    assertEquals("Results:", ((TextView)activity.findViewById(R.id.resultLabel)).getText());
  }

  public void testResultLabel_textSize_is48() {
    assertEquals(48f, ((TextView)activity.findViewById(R.id.resultLabel)).getTextSize());
  }

  public void testFindGetValuesButton() {
    assertTrue(activity.findViewById(R.id.getValues) instanceof Button);
  }

  public void testGetValuesButton_shouldHaveCorrectLabel() {
    assertEquals("Get Values", ((Button)activity.findViewById(R.id.getValues)).getText());
  }

  public void testGetValuesButton_shouldHaveAnOnClickListner() {
    assertTrue(((Button)activity.findViewById(R.id.getValues)).hasOnClickListeners());
  }

  public void testFindsPrimesOf_1() {
    TextView editableText = (TextView)activity.findViewById(R.id.result);
    sendKeys(1);
    assertEquals("", editableText.getText().toString());
  }

  public void testFindsPrimesOf_2() {
    TextView editableText = (TextView)activity.findViewById(R.id.result);
    sendKeys(2);

    assertEquals("2", editableText.getText().toString());
  }

  public void testFindsPrimesOf_3() {
    TextView editableText = (TextView)activity.findViewById(R.id.result);
    sendKeys(3);

    assertEquals("3", editableText.getText().toString());
  }

  public void testFindsPrimesOf_4() {
    TextView editableText = (TextView)activity.findViewById(R.id.result);
    sendKeys(4);

    assertEquals("[" + editableText.getText().toString() + "]", "2,2", editableText.getText().toString());
  }

  public void testFindsPrimesOf_6() {
    TextView editableText = (TextView)activity.findViewById(R.id.result);
    sendKeys(6);

    assertEquals("2,3", editableText.getText().toString());
  }

  public void testFindsPrimesOf_8() {
    TextView editableText = (TextView)activity.findViewById(R.id.result);
    sendKeys(8);

    assertEquals("2,2,2", editableText.getText().toString());
  }

  public void testFindsPrimesOf_9() {
    TextView editableText = (TextView)activity.findViewById(R.id.result);
    sendKeys(9);

    assertEquals("3,3", editableText.getText().toString());
  }

  private void sendKeys(int key) {
    sendKeys(key + " ENTER");
    sendKeys("ENTER");
  }
}
