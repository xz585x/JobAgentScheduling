package test.main;

import main.algorithm.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import main.model.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import test.main.util.Stopwatch;

/**
 * Tests for BestFit main.algorithm
 * @author Xuefei Zhao
 * Created by Xuefei Zhao on 4/15/2017.
 */
public class BestFitTest {

    List<Job> jobs;
    Group group;
    BestFit bestFit;

    @Before
    public void beforeTest() throws FileNotFoundException {
        jobs = new ArrayList<>();
        Scanner scn = new Scanner(new File("src/test/resources/JobList"));
        String s = scn.nextLine();
        int total = Integer.valueOf(s);
        for(int i = 0 ; i < total; i++) {
        	s = scn.nextLine();
        	String[] strs = s.split(" ");
        	jobs.add(new Job(Integer.valueOf(strs[0]), strs[1]));
         }
        scn.close();

        Scanner scnGroup = new Scanner(new File( "src/test/resources/GroupOfAgents"));
        s = scnGroup.nextLine();
        int aveCommuteTime = Integer.valueOf(s);
        s = scnGroup.nextLine();
        int agentAmount = Integer.valueOf(s);
        LinkedList<Agent> agents = new LinkedList<>();

        for (int i = 0; i < agentAmount; i++) {
            s = scnGroup.nextLine();
            String[] strs = s.split(" ");
            agents.addLast(new Agent(Integer.valueOf(strs[0]), Integer.valueOf(strs[1]), Integer.valueOf(strs[2])));

        }
        scnGroup.close();
        group = new Group(aveCommuteTime, agentAmount, agents);

    }

    @Test
    public void testBestFit() {
        bestFit = new BestFit();
        Stopwatch stopwatch = new Stopwatch();
        Map<String, Integer> result = bestFit.assign(group,jobs);
        System.out.println("BestFit main.algorithm runs in " + stopwatch.elapsedTime()+" with successfully assigned job " +result.size());
    }

    @After
    @Deprecated
    public void afterTest(){

    }

}
