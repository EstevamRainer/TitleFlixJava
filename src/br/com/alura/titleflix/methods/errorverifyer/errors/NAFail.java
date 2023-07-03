package br.com.alura.titleflix.methods.errorverifyer.errors;

public class NAFail extends Fail {
    public NAFail(Fail next) {
        super(next);
    }

    @Override
    protected String solution(String error) {
        return "Indisponível";
    }
    @Override
    protected boolean willApplySolution(String error) {
        return error.equals("N/A");
    }
}
