package linke.com.linke;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Login extends ActionBarActivity {

    private EditText textTextEmail;
    private EditText textTextPassword;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        InitVar();
        InitListener();
        Init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_button_signup) {
            startActivity(new Intent(Login.this, SignUp.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void InitVar() {
        textTextEmail = (EditText)findViewById(R.id.textbox_login_email);
        textTextPassword = (EditText)findViewById(R.id.textbox_login_password);
        login = (Button)findViewById(R.id.buttin_login);

    }
    private void InitListener(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(Utili.buttonClick);
                startActivity(new Intent(Login.this, MainActivity.class));
            }
        });
    }
    private void Init() {
        //getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.linke_blue)));
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.linke_blue)));
    }
}
