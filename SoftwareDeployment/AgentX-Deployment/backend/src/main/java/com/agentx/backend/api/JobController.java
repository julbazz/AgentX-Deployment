package com.agentx.backend.api;

import com.agentx.backend.api.dto.CreateJobRequest;
import com.agentx.backend.service.JobService;
import com.agentx.domain.model.Job;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin("*")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> getAll() {
        return jobService.getAllJobs();
    }

    @PostMapping
    public Job create(@RequestBody CreateJobRequest request) {
        return jobService.createJob(request.getSoftware());
    }
}