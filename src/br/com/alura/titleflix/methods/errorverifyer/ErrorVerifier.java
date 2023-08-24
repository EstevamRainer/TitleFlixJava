package br.com.alura.titleflix.methods.errorverifyer;

import br.com.alura.titleflix.methods.errorverifyer.errors.Fail;
import br.com.alura.titleflix.methods.errorverifyer.errors.NAFail;
import br.com.alura.titleflix.methods.errorverifyer.errors.NoSolution;

public class ErrorVerifier {
    public String verifyError(String information) {

        Fail fail = new NAFail(
                        new NoSolution(
                            ));

        return fail.applySolution(information);
    }
}
//Aqui foi usado o conceito de Chain of Responsibility para verificar se existe algum erro nas informação adquiridas pela API
