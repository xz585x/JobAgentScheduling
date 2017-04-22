package main.algorithm;

import main.model.*;


import java.util.*;

/**
 *
 * @author Xuefei Zhao
 *
 * Assign job to the agent with smallest agent number and the ability to finish the job
 *
 *
 * m: jobs
 * n: agents
 * Time complexity: O(mn)
 * Space complexity: O(1)
 *
 * Assignment efficiency: ~50 (almost half amount of jobs are properly assigned to agents)
 *
 */
public class FirstFit implements Schedule {

    @Override
    public Map<String, Integer> assign(Group group, List<Job> jobs) {
        Collection<Agent> agents = group.getAgents();
        int aveCommuteTime = group.getAveCommuteTime();
        Map<String, Integer> assignment = new HashMap<>();
        if (agents == null || agents.size() == 0) {
            return assignment;
        }
        if (jobs == null || jobs.size() == 0) {
            return assignment;
        }

        for (Job job : jobs) {
            for (Agent agent : agents) {
                if (agent.canAssign(job, group)) {
                    agent.assign(job, group);
                    assignment.put(job.getJobId(), agent.getAgentNumber());
                    break;
                }
            }
        }

        return assignment;
    }
}
