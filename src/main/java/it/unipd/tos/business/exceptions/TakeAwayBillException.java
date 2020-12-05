////////////////////////////////////////////////////////////////////
// Alessandro Rago 1187504
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exceptions;

public class TakeAwayBillException extends Throwable {
    private String mex;

    public TakeAwayBillException(String exception){
        this.mex = exception;
    }

    public String getMessage(){
        return this.mex;
    }
} 