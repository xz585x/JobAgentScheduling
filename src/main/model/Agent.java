package main.model;

import java.util.*;

/**
 * @author Xuefei Zhao
 */
public class Agent implements Comparable<Agent> {
    // total available time per day in this agent; default value is 18;
    private final int capacity;
    // by default, work hour is 8:00 am to 5:00 pm, 9 hour, 18 half-hour
    private final int defaultCapacity = 18;
    
    // current assigned job load; default value is 0;
    private int currentLoad;
    // by default, no job is assigned to this agent
    private int defaultCurrentLoad = 0;
    
    // the number of agent in a group;
    private final int agentNumber;

    // job assigned to this agent
    private final List<String> jobs;

	/**
	 * Constructor of Agent
     * @param cap: total available time per day in this agent;
     */
    public Agent(int cap, int agentNumber) {
        capacity = cap;
        currentLoad = 0;
        this.agentNumber = agentNumber;
        jobs = new LinkedList<>();
    }

    /**
     *  Constructor of Agent
     *
     * @param cap: total available time per day in this agent;
     * @param currentLoad: current job load assigned to this agent;
     */
    public Agent(int cap, int currentLoad, int agentNumber) {
        capacity = cap;
        this.currentLoad = currentLoad;
        this.agentNumber = agentNumber;
        jobs = new LinkedList<>();
    }

    /**
     *  Return true if job assign to this agent. otherwise false
     * @param job: job waiting for assignment
     * @param group: a group of agents provided to assign the job
     * @return Return true if job assign to this agent. otherwise false
     */
    public boolean canAssign(Job job, Group group) {
        return currentLoad + job.getWorkLoad() + group.getAveCommuteTime() <= capacity;
    }

    /**
     * Return true if job assign to this agent. otherwise false
     * @param job: job waiting for assignment
     * @param group: a group of agents provided to assign the job
     * @return Return true if job assign to this agent. otherwise false
     */
    public boolean assign(Job job, Group group) {
        if (canAssign(job, group)) {
            currentLoad += job.getWorkLoad() + group.getAveCommuteTime();
            jobs.add(job.getJobId());
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Agent agent) {
        if (currentLoad == agent.getCurrentLoad()) {
            return agentNumber - agent.getAgentNumber();
        }
        return agent.getCurrentLoad() - currentLoad;
    }

    /**
     *  Get currentLoad
     * @return currentLoad
     */
    public int getCurrentLoad() {
        return currentLoad;
    }

    /**
     * Get Capacity
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     *  Get agentNumber
     * @return agentNumber
     */
    public int getAgentNumber() {
        return agentNumber;
    }

    /**
     * Get jobs
     * @return jobs
     */
    public List<String> getJobs() {
        return jobs;
    }


}
