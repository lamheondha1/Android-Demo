package com.framgia.tipcalculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.framgia.tipcalculator.R.id.back_menu;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final String PREF_FILE_NAME = "last_result";
    private final String SAVE_LAST_RESULT = "Save last result";
    private TextView text;
    private TextView kq;
    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;

    private Button btn_cong;
    private Button btn_tru;
    private Button btn_nhan;
    private Button btn_chia;

    private Button btn_pt;
    private Button btn_tp;
    private Button btn_bang;
    private Button btn_ac;
    private Button btn_am;
    private Button btn_del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton();
        setButton();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.back_menu:
                kq.setText("0");
                text.setText(" ");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initButton() {
        text = findViewById(R.id.text);
        kq = findViewById(R.id.kq);
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_tp = findViewById(R.id.btn_tp);
        btn_am= findViewById(R.id.btn_am);
        btn_cong = findViewById(R.id.btn_cong);
        btn_tru = findViewById(R.id.btn_tru);
        btn_nhan = findViewById(R.id.btn_nhan);
        btn_chia = findViewById(R.id.btn_chia);
        btn_pt = findViewById(R.id.btn_pt);
        btn_ac = findViewById(R.id.btn_ac);
        btn_del = findViewById(R.id.btn_del);
        btn_bang = findViewById(R.id.btn_bang);
    }
    public void setButton(){
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_tp.setOnClickListener(this);
        btn_am.setOnClickListener(this);
        btn_pt.setOnClickListener(this);
        btn_cong.setOnClickListener(this);
        btn_tru.setOnClickListener(this);
        btn_nhan.setOnClickListener(this);
        btn_chia.setOnClickListener(this);
        btn_ac.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_bang.setOnClickListener(this);
    }
    public String delete(String num){
        int lenght = num.length();
        String tem = num.substring(0,lenght-1);
        return tem;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_0 :
                text.append("0");
                break;
            case R.id.btn_1 :
                text.append("1");
                break;
            case R.id.btn_2 :
                text.append("2");
                break;
            case R.id.btn_3 :
                text.append("3");
                break;
            case R.id.btn_4 :
                text.append("4");
                break;
            case R.id.btn_5 :
                text.append("5");
                break;
            case R.id.btn_6 :
                text.append("6");
                break;
            case R.id.btn_7 :
                text.append("7");
                break;
            case R.id.btn_8 :
                text.append("8");
                break;
            case R.id.btn_9 :
                text.append("9");
                break;
            case R.id.btn_am :
                text.append("-");
                break;
            case R.id.btn_pt:
                text.append("%");
                break;
            case R.id.btn_tp:
                text.append(".");
                break;
            case R.id.btn_cong :
                text.append("+");
                break;
            case R.id.btn_tru:
                text.append("-");
                break;
            case R.id.btn_nhan:
                text.append("*");
                break;
            case R.id.btn_chia:
                text.append("/");
                break;
            case R.id.btn_bang:
                DecimalFormat df = new DecimalFormat("###.#######");
                double result = 0;
                addPhepTinh(text.getText().toString());
                addSo(text.getText().toString());
                // Thuật toán tính toán biểu thức
                if(pheptinh.size()>=so.size() ||pheptinh.size()<1){
                    kq.setText("Error");
                }else {
                    for (int i = 0; i < (so.size() - 1); i++) {
                        switch (pheptinh.get(i)) {
                            case "+":
                                if (i == 0) {
                                    result = so.get(i) + so.get(i + 1);
                                } else {
                                    result = result + so.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0) {
                                    result = so.get(i) - so.get(i + 1);
                                } else {
                                    result = result - so.get(i + 1);
                                }
                                break;
                            case "*":
                                if (i == 0) {
                                    result = so.get(i) * so.get(i + 1);
                                } else {
                                    result = result * so.get(i + 1);
                                }
                                break;
                            case "/":
                                if (i == 0) {
                                    result = so.get(i) / so.get(i + 1);
                                } else {
                                    result = result / so.get(i + 1);
                                }
                                break;
                            case "%":
                                if (i == 0) {
                                    result = (so.get(i) / so.get(i + 1))*100;
                                } else {
                                    result = result / so.get(i + 1);
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    kq.setText(df.format(result) + "");
                }
                break;
            case R.id.btn_ac:
                text.setText("");
                kq.setText("0");
                break;
            case R.id.btn_del:
                String del = delete(text.getText().toString());
                text.setText(del);
                break;
        }
    }
    ArrayList<String> pheptinh;
    ArrayList<Double> so;


    public int addPhepTinh(String a){
        pheptinh = new ArrayList<>();
        char[] cArray = a.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    pheptinh.add(cArray[i] + "");
                    break;
                case '-':
                    pheptinh.add(cArray[i] + "");
                    break;
                case '*':
                    pheptinh.add(cArray[i] + "");
                    break;
                case '/':
                    pheptinh.add(cArray[i] + "");
                    break;
                case '%':
                    pheptinh.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }
    public void addSo(String stringInput) {
        so = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while(matcher.find()){
            so.add(Double.valueOf(matcher.group(1)));
        }
    }
}
