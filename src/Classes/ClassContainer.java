package Classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassContainer {
    public Map<String, MyClass> grupy;

    public ClassContainer() {
        this.grupy = new HashMap<>();
    }

    public void addClass(MyClass myClass){
        grupy.put(myClass.groupName, myClass);
    }

    public void removeClass(String nazwaGrupy){
        grupy.remove(nazwaGrupy);
    }

}