package main.runnable;

import main.model.Agent;
import main.model.Group;
import main.model.Job;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by senateuser on 2017/4/21.
 */
public class Generator {
    private Generator(){};

    private static Random random = new Random();
    public static Group generateRandomGroup(int numOfAgent){
        List<Agent> list = new LinkedList<>();
        for (int i = 1; i <= numOfAgent; i++) {
            int cap = random.nextInt(18)+1;
            int cur = random.nextInt(cap);
            list.add(new Agent(cap,cur,i));
        }
        int aveCommuteTime = random.nextInt(2);
        return new Group(aveCommuteTime,numOfAgent,list);
    }

    public static List<Job> generateRandomJob(int numOfJob) {
        List<Job> list = new LinkedList<>();
        for (int i = 1; i <= numOfJob ; i++) {
            int workLoad = random.nextInt(18)+1;
            list.add(new Job(workLoad, String.valueOf(i)));
        }
        return list;
    }
}
