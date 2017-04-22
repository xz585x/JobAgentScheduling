package main.model;

import java.util.*;

/**
 * Assign a job to a specific agent 
 * @author Xuefei Zhao
 */
public interface Schedule {

	/**
	 *  Return true if the jobs has been assigned to group
	 * @param group: group of agent
	 * @param jobs: jobs list
	 * @return
	 */
	Map<String, Integer>  assign(Group group, List<Job> jobs);
}
