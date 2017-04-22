package main.model;

import java.util.*;

/**
 * @author Xuefei Zhao
 */
public class Group {
	// average time cost for agents within this group
	private int aveCommuteTime; 
	// by default, average time cost is half hour within this group; 
	private final int defaultAveCommuteTime = 1;  
	
	// agent belonging to this group with agentNumber of 0;
	private Collection<Agent> agents;
	
	
	// how many agents belonging to this agent
	private int agentAmount;

	/**
	 * Constructor of Group
	 *
	 */
	public Group() {
		aveCommuteTime = defaultAveCommuteTime;
		agents = new LinkedList<>();
		agentAmount = 0;
	}

	/**
	 *constructor of group
	 * @param aveCommuteTime: average time cost for agents within this group
	 * @param agentAmount: how many agents belonging to this agent
	 * @param agents: agents belonging to this group;
	 */
	public Group(int aveCommuteTime, int agentAmount, Collection<Agent> agents) {
		this.aveCommuteTime = aveCommuteTime;
		this.agentAmount = agentAmount;
		this.agents = agents;
	}
	
	
    /**
     *  Get average commute time within this group
     * @return aveCommuteTime
     */

	public int getAveCommuteTime() {
		return aveCommuteTime;
	}
	
	
    /**
     *  Get agents within this group
     * @return agents
     */

	public Collection<Agent> getAgents() {
		return agents;
	}
	
  
	
    /**
     *  Get the total number of agents belonging to this group
     * @return agentAmount
     */

	public int getAgentAmount() {
		return agentAmount;
	}

}
