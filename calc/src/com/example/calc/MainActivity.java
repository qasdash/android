package com.example.calc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	
	TextView tvText; 
/*TextView logs;*/
	Button button_C, button_div, button_mul, button_minus, button_plus, button_result, button_point; 
	Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9;
	String STR = "  ";
	double Result = 0;
	Boolean count1operand, pointflag=false;
	String operand1, operand2; 
	int operation;
	final int MENU_RESET_ID = 1;
	final int MENU_QUIT_ID = 2;

//* / = 1
//* * = 2
//* - = 3
//*	+ = 4
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
/*		logs = (TextView) findViewById(R.id.logs);*/

		tvText = (TextView) findViewById(R.id.text);
		tvText.setText(0 + STR);
		count1operand = true;
		operand1 ="0";
		operand2 ="0";
		
		button_C = (Button) findViewById(R.id.button_C);
		button_div = (Button) findViewById(R.id.button_div);
		button_mul = (Button) findViewById(R.id.button_mul);
		button_minus = (Button) findViewById(R.id.button_minus);
		button_plus = (Button) findViewById(R.id.button_plus);
		button_result = (Button) findViewById(R.id.button_result);
		button_point = (Button) findViewById(R.id.button_point);
		
		button_C.setOnClickListener(this);
		button_div.setOnClickListener(this);
		button_mul.setOnClickListener(this);
		button_minus.setOnClickListener(this);
		button_plus.setOnClickListener(this);
		button_result.setOnClickListener(this);
		button_point.setOnClickListener(this);
		
		button_0 = (Button) findViewById(R.id.button_0);
		button_1 = (Button) findViewById(R.id.button_1);
		button_2 = (Button) findViewById(R.id.button_2);
		button_3 = (Button) findViewById(R.id.button_3);
		button_4 = (Button) findViewById(R.id.button_4);
		button_5 = (Button) findViewById(R.id.button_5);
		button_6 = (Button) findViewById(R.id.button_6);
		button_7 = (Button) findViewById(R.id.button_7);
		button_8 = (Button) findViewById(R.id.button_8);
		button_9 = (Button) findViewById(R.id.button_9);
		
		button_0.setOnClickListener(this);
		button_1.setOnClickListener(this);
		button_2.setOnClickListener(this);
		button_3.setOnClickListener(this);
		button_4.setOnClickListener(this);
		button_5.setOnClickListener(this);
		button_6.setOnClickListener(this);
		button_7.setOnClickListener(this);
		button_8.setOnClickListener(this);
		button_9.setOnClickListener(this);
	
/*		logs.setText("Op1:"+operand1+", Op2:"+operand2+", func:"+operation+", count:"+count1operand );*/

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
		case R.id.button_C:
			clear();
/*			logs.setText("Op1:"+operand1+", Op2:"+operand2+", func:"+operation+", count:"+count1operand );*/

		break;
		
		case R.id.button_div:
			count1operand = false;
			pointflag = false;
			operation = 1;
/*			logs.setText("Op1:"+operand1+", Op2:"+operand2+", func:"+operation+", count:"+count1operand );*/
		break;
		
		case R.id.button_mul:
			count1operand = false;
			pointflag = false;
			operation = 2;
/*			logs.setText("Op1:"+operand1+", Op2:"+operand2+", func:"+operation+", count:"+count1operand );*/
		break;
		
		case R.id.button_minus:
			count1operand = false;
			pointflag = false;
			operation = 3;
/*			logs.setText("Op1:"+operand1+", Op2:"+operand2+", func:"+operation+", count:"+count1operand );*/
		break;	
		
		case R.id.button_plus:
			count1operand = false;
			pointflag = false;
			operation = 4;
/*			logs.setText("Op1:"+operand1+", Op2:"+operand2+", func:"+operation+", count:"+count1operand );*/
		break;		
		
		case R.id.button_result:
/*		logs.setText("Op1:"+operand1+", Op2:"+operand2+", func:"+operation+", count:"+count1operand );*/
			pointflag=false;
			double op1 = 0,op2 = 0;
			if (operand1 == "") operand1="0";
			if (operand2 == "") operand2="0";
			op1 = Double.parseDouble(operand1);
			op2 = Double.parseDouble(operand2);

			switch (operation){
			case 1:
				if (op2 == 0 ) {tvText.setText("Деление на ноль!"+STR);}
				else{
				Result = op1/op2;
					if (Result%1 == 0) { tvText.setText((long)Result+STR); }
					else tvText.setText(Result+STR);
					}
				operand1 = Double.toString(Result);
				operand2 = "0";
			break;
			case 2:
				Result = op1*op2;
				if (Result%1 == 0) { tvText.setText((long)Result+STR);}
				else tvText.setText(Result+STR);
				operand1 = Double.toString(Result);
				operand2 = "0";
			break;
			case 3:
				Result = op1-op2;
				if (Result%1 == 0) { tvText.setText((long)Result+STR);}
				else tvText.setText(Result+STR);
				operand1 = Double.toString(Result);
				operand2 = "0";
			break;
			case 4:
				Result = op1 + op2;
				if (Result%1 == 0) { tvText.setText((long)Result+STR);}
				else tvText.setText(Result+STR);
				operand1 = Double.toString(Result);
				operand2 = "0";
			break;
			}
		break;	
		
		case R.id.button_point:
			if (pointflag == true) break;
			else {
					if (count1operand == true) {
	/*					if (operand1 == "") operand1="0";*/
					operand1 = operand1 + ".";
					tvText.setText(operand1+STR);
					pointflag = true;
				}
				else {
						if (operand2 == "") operand2="0";
					operand2 = operand2 + ".";
					tvText.setText(operand2+STR);
					pointflag = true;
				}
/*			logs.setText("Op1:"+operand1+", Op2:"+operand2+", func:"+operation+", count:"+count1operand );*/
			}
		break;
		
		case R.id.button_0:
			if (count1operand == true) {
				if (Double.valueOf(operand1)==0 && pointflag==false) operand1="";
				operand1 = operand1 + "0";
				tvText.setText(operand1+STR);
			}
			else {
				if (Double.valueOf(operand2)==0 && pointflag==false) operand2="";
				operand2 = operand2 + "0";
				tvText.setText(operand2+STR);
			}
/*			logs.setText("Op1:"+operand1+", Op2:"+operand2+", func:"+operation+", count:"+count1operand );*/
		break;	

		case R.id.button_1:
			if (count1operand == true) {
				if (Double.valueOf(operand1)==0 && pointflag==false) operand1="";
				operand1 = operand1 + "1";
				tvText.setText(operand1+STR);
			}
			else {
				if (Double.valueOf(operand2)==0 && pointflag==false) operand2="";
				operand2 = operand2 + "1";
				tvText.setText(operand2+STR);
			}
/*			logs.setText("Op1:"+operand1+", Op2:"+operand2+", func:"+operation+", count:"+count1operand );*/
		break;
		
		case R.id.button_2:
			if (count1operand == true) {
				if (Double.valueOf(operand1)==0 && pointflag==false) operand1="";
				operand1 = operand1 + "2";
				tvText.setText(operand1+STR);
			}
			else {
				if (Double.valueOf(operand2)==0 && pointflag==false) operand2="";
				operand2 = operand2 + "2";
				tvText.setText(operand2+STR);
			}
/*			logs.setText("Op1:"+operand1+", Op2:"+operand2+", func:"+operation+", count:"+count1operand );*/
		break;
		
		case R.id.button_3:
			if (count1operand == true) {
				if (Double.valueOf(operand1)==0 && pointflag==false) operand1="";
				operand1 = operand1 + "3";
				tvText.setText(operand1+STR);
			}
			else {
				if (Double.valueOf(operand2)==0 && pointflag==false) operand2="";
				operand2 = operand2 + "3";
				tvText.setText(operand2+STR);
			}
/*			logs.setText("Op1:"+operand1+", Op2:"+operand2+", func:"+operation+", count:"+count1operand );*/
		break;
		
		case R.id.button_4:
			if (count1operand == true) {
				if (Double.valueOf(operand1)==0 && pointflag==false) operand1="";
				operand1 = operand1 + "4";
				tvText.setText(operand1+STR);
			}
			else {
				if (Double.valueOf(operand2)==0 && pointflag==false) operand2="";
				operand2 = operand2 + "4";
				tvText.setText(operand2+STR);
			}
/*			logs.setText("Op1:"+operand1+", Op2:"+operand2+", func:"+operation+", count:"+count1operand );*/
		break;
		
		case R.id.button_5:
			if (count1operand == true) {
				if (Double.valueOf(operand1)==0 && pointflag==false) operand1="";
				operand1 = operand1 + "5";
				tvText.setText(operand1+STR);
			}
			else {
				if (Double.valueOf(operand2)==0 && pointflag==false) operand2="";
				operand2 = operand2 + "5";
				tvText.setText(operand2+STR);
			}
/*			logs.setText("Op1:"+operand1+", Op2:"+operand2+", func:"+operation+", count:"+count1operand );*/
		break;
		
		case R.id.button_6:
			if (count1operand == true) {
				if (Double.valueOf(operand1)==0 && pointflag==false) operand1="";
				operand1 = operand1 + "6";
				tvText.setText(operand1+STR);
			}
			else {
				if (Double.valueOf(operand2)==0 && pointflag==false) operand2="";
				operand2 = operand2 + "6";
				tvText.setText(operand2+STR);
			}
/*			logs.setText("Op1:"+operand1+", Op2:"+operand2+", func:"+operation+", count:"+count1operand );*/
		break;
		
		case R.id.button_7:
			if (count1operand == true) {
				if (Double.valueOf(operand1)==0 && pointflag==false) operand1="";
				operand1 = operand1 + "7";
				tvText.setText(operand1+STR);
			}
			else {
				if (Double.valueOf(operand2)==0 && pointflag==false) operand2="";
				operand2 = operand2 + "7";
				tvText.setText(operand2+STR);
			}
/*			logs.setText("Op1:"+operand1+", Op2:"+operand2+", func:"+operation+", count:"+count1operand );*/
		break;
		
		case R.id.button_8:
			if (count1operand == true) {
				if (Double.valueOf(operand1)==0 && pointflag==false) operand1="";
				operand1 = operand1 + "8";
				tvText.setText(operand1+STR);
			}
			else {
				if (Double.valueOf(operand2)==0 && pointflag==false) operand2="";
				operand2 = operand2 + "8";
				tvText.setText(operand2+STR);
			}
/*			logs.setText("Op1:"+operand1+", Op2:"+operand2+", func:"+operation+", count:"+count1operand );*/
		break;
		
		case R.id.button_9:
			if (count1operand == true) {
				if (Double.valueOf(operand1)==0 && pointflag==false) operand1="";
				operand1 = operand1 + "9";
				tvText.setText(operand1+STR);
			}
			else {
				if (Double.valueOf(operand2)==0 && pointflag==false) operand2="";
				operand2 = operand2 + "9";
				tvText.setText(operand2+STR);
			}
/*			logs.setText("Op1:"+operand1+", Op2:"+operand2+", func:"+operation+", count:"+count1operand );*/
		break;
		}
	}
	
	public void clear(){
		count1operand = true;
		pointflag = false;
		operand1 ="0";
		operand2 ="0";
		operation = 0;
			Result = 0;
			tvText.setText(0+STR);
	}
	
	//* создание меню
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	// TODO Auto-generated method stub
	menu.add(0, MENU_RESET_ID, 0, "Инженерный");
	menu.add(0, MENU_QUIT_ID, 0, "Выход");
	return super.onCreateOptionsMenu(menu);
	}

	// обработка нажатий на пункты меню
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	// TODO Auto-generated method stub
	switch (item.getItemId()) {
	case MENU_RESET_ID:
	// озапускаем активити с инженерным калькулятором
		clear();
		Intent intent = new Intent(this,SecondActivity.class);
		startActivity(intent);
	break;
	case MENU_QUIT_ID:
	// выход из приложения
	finish();
	break;
	}
	return super.onOptionsItemSelected(item);
	}
}
