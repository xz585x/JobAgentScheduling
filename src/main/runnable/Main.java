package main.runnable;

import main.algorithm.*;

import main.model.Group;
import main.model.Job;
import main.runnable.util.Stopwatch;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by senateuser on 2017/4/21.
 */
public class Main {
    public static void main(String[] args) {
        // read input from console
        String input;
        do {
            System.out.println("Please enter: num of agents and num of jobs (space-delimited), e.g.  '500 1000'");
            Scanner inputScanner = new Scanner(System.in);
            input = inputScanner.nextLine();
        } while (input == null || input.length() == 0 || !input.contains(" "));
        String[] strs = input.split(" ");
        int numOfAgents = Integer.valueOf(strs[0]);
        int numOfJobs = Integer.valueOf(strs[1]);

        // generate agent group and job
        Group group = Generator.generateRandomGroup(numOfAgents);
        List<Job> jobList = Generator.generateRandomJob(numOfJobs);

        // run four algorithms

        BestFit bestFit = new BestFit();
        FirstFit firstFit = new FirstFit();
        NextFit nextFit = new NextFit();
        WorstFit worstFit = new WorstFit();


        System.out.println();
        // BestFit
        System.out.println("Running BestFit Algorithm on " + numOfAgents + " agents with " + numOfJobs + " jobs");
        Stopwatch bestFitWatch = new Stopwatch();
        Map<String, Integer> bestFitMap = bestFit.assign(group, jobList);
        System.out.printf("The BestFit Algorithm runs in " + bestFitWatch.elapsedTime() + " secs with assigned rate of %.2f", (double) bestFitMap.size() / jobList.size());
        System.out.println();

        // FirstFit
        System.out.println("Running FirstFit Algorithm on " + numOfAgents + " agents with " + numOfJobs + " jobs");
        Stopwatch firstFitWatch = new Stopwatch();
        Map<String, Integer> firstFitmap = firstFit.assign(group, jobList);
        System.out.printf("The FirstFit Algorithm runs in " + firstFitWatch.elapsedTime() + " secs with assigned rate of %.2f", (double) firstFitmap.size() / jobList.size());
        System.out.println();

        // NextFit
        System.out.println("Running NextFit Algorithm on " + numOfAgents + " agents with " + numOfJobs + " jobs");
        Stopwatch nextFitWatch = new Stopwatch();
        Map<String, Integer> nextFitmap = nextFit.assign(group, jobList);
        System.out.printf("The NextFit Algorithm runs in " + nextFitWatch.elapsedTime() + " secs with assigned rate of %.2f", (double) nextFitmap.size() / jobList.size());
        System.out.println();


        // WorstFit
        System.out.println("Running WorstFit Algorithm on " + numOfAgents + " agents with " + numOfJobs + " jobs");
        Stopwatch worstFitMap = new Stopwatch();
        Map<String, Integer> worstFitmap = worstFit.assign(group, jobList);
        System.out.printf("The WorstFit Algorithm runs in " + worstFitMap.elapsedTime() + " secs with assigned rate of  %.2f", (double) worstFitmap.size() / jobList.size());

    }
}
