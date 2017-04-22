package main.algorithm;

import main.model.*;

import java.util.*;

/**
 * @author Xuefei Zhao
 *
 * Next Fit Algorithm:
 * 
 * Assign the job in the last agent seen. If it does not fit there, then
 * check the next agent after it and assign it there.
 *
 * m: jobs
 * n: agents
 * Time complexity: O(n)
 * Space complexity: O(1)
 *
 * Assignment efficiency: ~25% (worst, almost 1/4 of jobs are properly assigned to agents)
 */
public class NextFit implements Schedule {
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
		Iterator<Agent> agentIterator = agents.iterator();
		Agent cur = agentIterator.hasNext() ? agentIterator.next() : null;
		for (Job job : jobs) {
			if (cur == null) { // no agent is left for assignment
				break;
			}
			while (!cur.canAssign(job, group) && agentIterator.hasNext()) {
				cur = agentIterator.next();
			}
			if (cur.canAssign(job, group)) {
				cur.assign(job, group);
				assignment.put(job.getJobId(), cur.getAgentNumber());
			} else {
				break;
			}
		
		}
		return assignment;
	}
}
