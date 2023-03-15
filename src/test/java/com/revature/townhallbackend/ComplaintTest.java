package com.revature.townhallbackend;

import com.revature.townhallbackend.entity.Complaint;
import com.revature.townhallbackend.repository.ComplaintRepository;
import com.revature.townhallbackend.service.ComplaintService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ComplaintTest {

    @MockBean(ComplaintRepository.class)
    private ComplaintRepository complaintRepository;

    @Autowired
    ComplaintService complaintService;

    @Test
    public void testFindByStatus(){
        List<Complaint> complaints = new ArrayList<>();
        Complaint test1 = new Complaint(1L,"test1","PENDING",1L);
        complaints.add(test1);
        Complaint test2 = new Complaint(2L, "test2", "Unresolved", 2L);

        List<Complaint> expectedComplaint = Arrays.asList(
                new Complaint(
                        3L,
                        "Test Description",
                        "UNRESOLVED",
                        3L
                )
        );
        Mockito.when(complaintRepository
                .findByStatus("UNRESOLVED")).thenReturn((List<Complaint>) expectedComplaint);
        Assertions.assertEquals(expectedComplaint, complaintService
                .getComplaintByStatus("UNRESOLVED"));

    }

}
