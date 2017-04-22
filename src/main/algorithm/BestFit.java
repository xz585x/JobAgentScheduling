package main.algorithm;

import main.model.Agent;
import main.model.Group;
import main.model.Job;
import main.model.Schedule;

import java.util.*;

/**
 * @author Xuefei Zhao
 * Best Fit Algorithm:
 * 
 * Assign the jobs into the agents that are the most full, but still has enough
 * space for the jobs. Uses a Navigable TreeSet for the ceiling and flooring
 * operations that it has.
 *
 * m: jobs
 * n: agents
 * Time complexity: O(nlogn + mlogn)
 * Space complexity: O(n)
 *
 *
 * Assignment efficiency: ~100% (best, almost all jobs are properly assigned to agents)
 */

public class BestFit implements Schedule {
    private int cap = 18;

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
        NavigableSet<Agent> agentSet = new TreeSet<>();

        Iterator<Agent> agentIterator = agents.iterator();

        for (Job job : jobs) {
            int workLoad = job.getWorkLoad() + aveCommuteTime;
            Agent agent = new Agent(cap, workLoad, 11);

            if ((agent = agentSet.floor(agent)) != null) {
                agentSet.remove(agent);
                agent.assign(job, group);
                assignment.put(job.getJobId(), agent.getAgentNumber());
                agentSet.add(agent);
            } else {
                while (agentIterator.hasNext()) {
                    Agent cur = agentIterator.next();
                    if (cur.canAssign(job, group)) {
                        cur.assign(job, group);
                        agentSet.add(cur);
                        assignment.put(job.getJobId(), cur.getAgentNumber());
                        break;
                    }
                    agentSet.add(cur);
                }
            }
        }
        return assignment;
    }

}
