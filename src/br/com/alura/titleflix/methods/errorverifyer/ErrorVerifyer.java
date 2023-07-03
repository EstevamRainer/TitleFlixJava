package br.com.alura.titleflix.methods.errorverifyer;

import br.com.alura.titleflix.methods.errorverifyer.errors.Fail;
import br.com.alura.titleflix.methods.errorverifyer.errors.NAFail;
import br.com.alura.titleflix.methods.errorverifyer.errors.NoSolution;

public class ErrorVerifyer {
    public String verifyError(String information) {

        Fail fail = new NAFail(
                        new NoSolution(
                            ));

        return fail.applySolution(information);
    }

}