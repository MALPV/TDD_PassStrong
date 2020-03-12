package cl.desafiolatam.passstrength;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import cl.desafiolatam.passstrength.Presenter.IPresenterView;
import cl.desafiolatam.passstrength.Presenter.Presenter;

public class MainActivity extends AppCompatActivity implements IPresenterView {

    @BindView(R.id.editText2)
    EditText inputText;

    @BindView(R.id.textView2)
    TextView textView;

    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        presenter = new Presenter(this);


        inputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.evaluatePass(charSequence.toString());
                verifyEmpty();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void verifyEmpty() {
        if (inputText.getText().toString().isEmpty()){
            textView.setText("Password Strength!");
            textView.setBackgroundColor(Color.WHITE);
        }
    }

    /**********************************************
     *** IPresenterView interface implementation **
     **********************************************/
    @Override
    public void showWeak() {
        textView.setBackgroundColor(Color.RED);
        textView.setText(R.string.weak);
    }

    @Override
    public void showMedium() {
        textView.setBackgroundColor(Color.YELLOW);
        textView.setText(R.string.medium);
    }

    @Override
    public void showStrong() {
        textView.setBackgroundColor(Color.GREEN);
        textView.setText(R.string.strong);
    }

    @Override
    public void showVeryStrong() {
        textView.setBackgroundColor(Color.BLUE);
        textView.setText(R.string.veryStrong);
    }
}
