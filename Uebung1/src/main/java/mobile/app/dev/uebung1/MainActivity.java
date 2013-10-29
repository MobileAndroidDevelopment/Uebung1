package mobile.app.dev.uebung1;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;

public class MainActivity extends Activity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.button_0:
                textView.append("0"); break;
            case R.id.button_1:
                textView.append("1"); break;
            case R.id.button_2:
                textView.append("2"); break;
            case R.id.button_3:
                textView.append("3"); break;
            case R.id.button_4:
                textView.append("4"); break;
            case R.id.button_5:
                textView.append("5"); break;
            case R.id.button_6:
                textView.append("6"); break;
            case R.id.button_7:
                textView.append("7"); break;
            case R.id.button_8:
                textView.append("8"); break;
            case R.id.button_9:
                textView.append("9"); break;
            case R.id.button_add:
                textView.append("+"); break;
            case R.id.button_mult:
                textView.append("*"); break;
            case R.id.button_sub:
                textView.append("-"); break;
            case R.id.button_back:
                if(textView.length()>0){
                    textView.setText(textView.getText().subSequence(0, textView.getText().length()-1));
                }
                break;
            case R.id.button_div:
                textView.append("/"); break;
            case R.id.button_dot:
                textView.append("."); break;
            case R.id.button_eq:
                try{
                    String expression = textView.getText().toString();
                    Calculable calc = new ExpressionBuilder(expression).build();
                    String result =  calc.calculate()+"";
                    textView.setText(result);
                } catch (Exception e){
                    Log.d("Tag", "ohn weh");
                }
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
