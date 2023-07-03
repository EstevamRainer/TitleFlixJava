package br.com.alura.titleflix.methods.errorverifyer.errors;

public class NoSolution extends Fail {
    public NoSolution() {
        super(null);
    }

    @Override
    protected String solution(String error) {
        return error;
    }

    @Override
    protected boolean willApplySolution(String error) {
        return true;
    }
}
