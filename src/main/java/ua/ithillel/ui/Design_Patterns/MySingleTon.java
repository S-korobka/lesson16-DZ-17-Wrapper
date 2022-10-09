package ua.ithillel.ui.Design_Patterns;

public class MySingleTon{
    private static MySingleTon singletonInst;

    private Object cat ;

    private MySingleTon() {
       cat = new Object();
    }

    public static MySingleTon getInstance(){
        if(singletonInst==null){
            singletonInst = new MySingleTon();
            System.out.println("MySingleTon instance created for the first time.");
        }
        return singletonInst;
    }

    public Object getCat() {
        return cat;
    }

    public void setCat(Object cat) {
        this.cat = cat;
    }
}
class ExamplePgm {
    public static void main(String[] args) {

        MySingleTon instance = MySingleTon.getInstance();
        instance.setCat("tom");
        displayMsg();
        MySingleTon instance2 = MySingleTon.getInstance();
        instance2.setCat("tom2");
        displayMsg();
        MySingleTon instance3 = MySingleTon.getInstance();
        instance3.setCat("tom3");
        displayMsg();
    }

    public static void displayMsg(){
        MySingleTon instance = MySingleTon.getInstance();
        System.out.println(instance.getCat());
    }
}
