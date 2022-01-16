package model.exceptions;

public class WithdrawErrorException extends RuntimeException{

    public WithdrawErrorException(String msg){
        super(msg);
    }
}
