
class Testing {
    //public static final int VAR = 1;

    void hola(){
        //this.VAR = 2;
        System.out.println("testing class");
    }
}

public class demo{

    public static void main(String[] args){
        Testing obj = new Testing();
        System.out.println(obj.hola());
    }
}