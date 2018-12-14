import TestRailApi.APIClient;
import TestRailApi.APIException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestRail {
    static String userName = "rvalek@intersog.com";
    static String userPassweord =  "hillel";
    static APIClient client;
    static String RunName = "Run " + new Date();
    static int idProject = 4;
    Long  runId;
    TestRail (){
        this.client =  new APIClient("https://hillel5.testrail.io/");
        client.setUser(userName);
        client.setPassword(userPassweord);

    }
    public void createRun() throws IOException, APIException {
        Map<String, String> data = new HashMap();
       //data.put("project_id", 4);
        data.put("name", RunName);
        JSONObject run = (JSONObject) client.sendPost("add_run/" + idProject, data);
        runId = (Long) run.get("id");

        client.sendPost("get_cases/" + idProject, data);
      //  System.out.println(client.sendGet("get_suites/" + idProject));
       // JSONArray runs = (JSONArray) client.sendGet("get_runs/" + idProject);


       /* System.out.println(runs.get(0));
        System.out.println("----");
        System.out.println(runs);*/
    }

    public void reportStatus(int caseID, int statucCode){

    }


}
