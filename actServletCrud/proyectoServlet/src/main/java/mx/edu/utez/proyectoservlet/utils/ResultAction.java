package mx.edu.utez.proyectoservlet.utils;

public class ResultAction<T> {
    T obj;        //nos va a devolver un obj, un msj, status y resultado
    private String message;
    private int status;
    private boolean result;

    public ResultAction(){
    }

    public ResultAction(T obj) {this.obj = obj;}

    public T getObj() {return obj;}

    public void setObj(T obj) {this.obj = obj;}

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message;}

    public int getStatus() {return status;}

    public void setStatus(int status) {this.status = status;}

    public boolean isResult() {return result;}

    public void setResult(boolean result) {this.result = result;}
}





//esta clase nos va a ayudar a saber el resultado de cada operación
