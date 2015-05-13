package mg.quadraticequationsolver;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "mg.quadraticequationsolver.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void solve(View view) {
		
		try
		{
		EditText  mEditText1   = (EditText)findViewById(R.id.editText1);
		double a=Double.parseDouble(mEditText1.getText().toString());
		EditText  mEditText2   = (EditText)findViewById(R.id.editText2);
		double b=Double.parseDouble(mEditText2.getText().toString());
		EditText  mEditText3   = (EditText)findViewById(R.id.editText3);
		double c=Double.parseDouble(mEditText3.getText().toString());
		
		double D=b*b-4*a*c;
		double x1,x2;
		String solution,rP,iP;
		if(D>=0)
		{
		x1=(-b+Math.sqrt(D))/(2*a);
		x2=(-b-Math.sqrt(D))/(2*a);
		solution="x1="+String.valueOf(x1)+"\n"+"x2="+String.valueOf(x2);
		}
		else
		{
		iP=String.valueOf(Math.sqrt(-D)/(2*a))+"i";
		rP=String.valueOf(-b/(2*a));
		solution="x1="+rP+"+"+iP+"\n"+"x2="+rP+"-"+iP;

		}

		Intent intent = new Intent(this, Solution.class);
		intent.putExtra(EXTRA_MESSAGE, solution);
		startActivity(intent);
		}
		catch(Exception e)
		{
			
		}
		
		
	}

}
