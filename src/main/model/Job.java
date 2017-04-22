package main.model;

/**
 * A job represent a job with its workload, the workload is defined as  measurement of availability for agent
 *
 * @author Xuefei Zhao
 */
public class Job {
    // The workload of job
    private Integer workLoad;
    // The jobId of Job
    private String jobId;

    /**
     * Job may have many other fields
     * we will only use jobId and workLoad for optimized scheduling
     */
    public Job(Integer workLoad, String jobId) {
        this.workLoad = workLoad;
        this.jobId = jobId;
    }

    /**
     * Get workload
     *
     * @return workload
     */
    public Integer getWorkLoad() {
        return workLoad;
    }

    /**
     * Set workload
     *
     * @param workLoad workload
     */
    public void setWorkLoad(Integer workLoad) {
        this.workLoad = workLoad;
    }

    /**
     * Get jobId
     *
     * @return jobId
     */
    public String getJobId() {
        return jobId;
    }

    /**
     * Set jobId
     *
     * @param jobId jobId
     */
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}
