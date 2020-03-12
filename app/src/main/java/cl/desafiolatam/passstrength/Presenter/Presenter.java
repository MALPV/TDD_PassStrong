package cl.desafiolatam.passstrength.Presenter;

import android.util.Log;

import cl.desafiolatam.passstrength.model.Verifier;

public class Presenter {

    IPresenterView view;
    Verifier verifier;

    public Presenter(IPresenterView view) {
        this.view = view;
        verifier = new Verifier();
    }

    public void evaluatePass(final String pass) {

        int res = verifier.evaluatePass(pass);
        switch (res ){
            case Verifier.WEAK:
                this.view.showWeak();
                break;
            case Verifier.MEDIUM:
                this.view.showMedium();
                break;
            case Verifier.STRONG:
                this.view.showStrong();
                break;
            case Verifier.VERY_STRONG:
                this.view.showVeryStrong();
                break;
        }
    }
}
