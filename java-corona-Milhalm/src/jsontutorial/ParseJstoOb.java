package jsontutorial;

import com.google.gson.Gson;

/**
 *
 * @author lukasmilhalm
 */
public class ParseJstoOb {

    public static void main(String[] args) {
        Gson gson = new Gson();

        System.out.println(
                gson.fromJson("{'id':1,'firstName':'Lokesh','lastName':'Gupta','roles':['ADMIN','MANAGER']}",
                        Employee.class));
    }

}
