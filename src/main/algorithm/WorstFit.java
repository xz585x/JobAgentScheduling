package main.algorithm;


import main.model.*;

import java.util.*;

/**
 * @author Xuefei Zhao
 * 
 * Assign the job into the "emptiest" agent among agents
 * 
 * If there are two or more agents tied for emptiest, use the agent with a smaller agent number;
 *
 * m: jobs
 * n: agents
 * Time complexity: O(nlogn + mlogn)
 * Space complexity: O(n)
 * Assignment efficiency: ~50 (almost half amount of jobs are properly assigned to agents)
 */
public class WorstFit implements Schedule {
	@Override
	public Map<String, Integer> assign(Group group, List<Job> jobs) {
		Collection<Agent> agents = group.getAgents();
		Map<String, Integer> assignment = new HashMap<>();
		if (agents == null || agents.size() == 0) {
			return assignment;
		}
		if (jobs == null || jobs.size() == 0) {
			return assignment;
		}
		
		Queue<Agent> pq = new PriorityQueue<>(16, new Comparator<Agent>() {
			public int compare(Agent a1, Agent a2) {
				if (a2.getCapacity() - a2.getCurrentLoad() == a1.getCapacity() - a1.getCurrentLoad()) {
					return a1.getAgentNumber() - a2.getAgentNumber();
				}
				return (a2.getCapacity() - a2.getCurrentLoad()) - (a1.getCapacity() - a1.getCurrentLoad());
			}
		});

		Iterator<Agent> agentIterator = agents.iterator();
		while (agentIterator.hasNext()){
			Agent cur = agentIterator.next();
			if (cur.getCapacity() > cur.getCurrentLoad()) {
				pq.offer(cur);
			}
		}

		for (Job job : jobs) {
			Agent cur = pq.peek();
			
			if (cur != null && cur.canAssign(job, group)) {
				pq.poll();
				cur.assign(job, group);
				assignment.put(job.getJobId(), cur.getAgentNumber());
				if (cur.getCapacity() > cur.getCurrentLoad()) {
					pq.offer(cur);
				}
			}
		
		}
		return assignment;
	}
}
